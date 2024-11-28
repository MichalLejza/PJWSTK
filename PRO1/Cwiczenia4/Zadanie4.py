import numpy as np
import pandas as pd
from sklearn.tree import DecisionTreeClassifier
from sklearn.tree import export_text

#  Zadanie 1
#  Czy w drzewie decyzyjnym Indeks Giniego syna na ogół jest większy czy mniejszy niż
#  Indeks Giniego ojca? Czy na ogół jest on większy/mniejszy czy zawsze jest większy/mniejszy?

#  W drzewie decyzyjnym indeks Giniego syna na ogół jest mniejszy niż indeks Giniego ojca.
#  Indeks Giniego jest miarą czystości węzła w drzewie decyzyjnym. Im niższy indeks Giniego, tym lepiej,
#  ponieważ oznacza to, że węzeł zawiera bardziej jednorodne dane. Gdy drzewo decyzyjne dzieli dane w węźle ojca
#  na mniejsze grupy (dzieci), oczekujemy, że różnorodność w tych grupach (dzieciach) będzie mniejsza niż w grupie
#  węzła ojca, co prowadzi do niższego indeksu Giniego dla synów.
#  W praktyce, nie zawsze możemy to gwarantować w przypadku, gdy podział nie jest udany lub w przypadku bardzo
#  małych grup, gdzie losowe wahania mogą prowadzić do sytuacji, w której indeks Giniego syna jest większy niż ojca.
#  Jednak w dobrze skonstruowanym drzewie decyzyjnym, które skutecznie dzieli dane, można oczekiwać, że indeks Giniego
#  synów będzie na ogół mniejszy.

#  Zadanie 2
#  Czy następujące zdania są prawdziwe?
#  a) Jeśli drzewo decyzyjne jest przeuczone (overfitting), to trzeba zwiększyć jego wysokość (maxdepth).
#  Fałsz.
#  Kiedy drzewo decyzyjne jest przeuczone, oznacza to, że jest zbyt złożone i zbyt dobrze dopasowuje się do danych
#  treningowych, w tym do szumów. Zwiększanie wysokości drzewa (max depth) prowadzi do jeszcze większej złożoności,
#  co może pogłębić problem przeuczenia. Aby walczyć z przeuczeniem, zazwyczaj należy zmniejszyć wysokość drzewa
#  (lub zastosować inne techniki, takie jak przycinanie (pruning), regularyzacja lub użycie mniej złożonych modeli).

#  b) Jeśli drzewo jest niedouczone underfitting, to trzeba dyskretyzować atrybuty wejściowe?
#  Fałsz (z zastrzeżeniem).
#  Niedouczenie oznacza, że model jest zbyt prosty, aby uchwycić złożoność danych. Dyskretyzacja atrybutów wejściowych
#  może być jedną z metod poprawy modelu, ale nie zawsze jest konieczna. Niedouczenie można rozwiązać na wiele sposobów,
#  takich jak zwiększenie złożoności modelu (np. poprzez zwiększenie głębokości drzewa), dodanie nowych atrybutów,
#  użycie bardziej skomplikowanego modelu lub zmiana parametrów modelu. Dyskretyzacja może pomóc w niektórych
#  przypadkach, ale nie jest to uniwersalne rozwiązanie dla problemu niedouczenia.


#  Zadanie 3
#  Tablica Car_examples zawiera opisy modeli samochodów. Zmienna docelowa opisuje,
#  czy klient akceptuje dany model czy nie. Do klasyfikacji modelu samochodu drzewo decyzyjne jest
#  stosowane. Zakłada się, że miara Entropia jest stosowana do oceny jakości podziału. Wyznaczyć
#  najlepszy podział, który znajduje się w korzeniu drzewa.
#  Wskazówki
#  1. Jakie typy mają atrybuty.
#  2. Dla atrybutu wyznaczyć Entropię podziału.
#  3. Wyznaczyć atrybut z najniższą entropią podziału (z największym zyskiem entropii).

path = "/Users/michallejza/PycharmProjects/PRO/Data/Book1.xlsx"
df = pd.read_excel(path)


def entropy(probs):
    return -np.sum([p * np.log2(p) for p in probs if p > 0])


def calculateEntropy(column):
    entropies = {}
    for klasa, group in df.groupby(column):
        counts = group['Akceptacja'].value_counts()
        p0 = counts.get(0, 0) / len(group)
        p1 = counts.get(1, 0) / len(group)
        entropies[klasa] = entropy([p0, p1])
    print("Entropia dla atrybutów:")
    for klasa, ent in entropies.items():
        print(f"{klasa}: {ent:.4f}")

    split_entropy = sum((len(group) / total_count) * entropies[klasa] for klasa, group in df.groupby(column))
    print(f"Entropia split: {split_entropy:.4f}\n")
    return split_entropy


total_count = len(df)
entropiesAll = {col: calculateEntropy(df[col]) for col in df.columns if col != 'Akceptacja'}

for i in entropiesAll.keys():
    print(i, entropiesAll[i])

# Rozdzielenie cech i etykiet
X = df.drop(columns=['Akceptacja'])
y = df['Akceptacja']

X_encoded = pd.get_dummies(X)
clf = DecisionTreeClassifier(criterion='entropy', max_depth=3, random_state=42)
clf.fit(X_encoded, y)

feature_names = X_encoded.columns.tolist()
r = export_text(clf, feature_names=feature_names, max_depth=4)
print(r)

feature_importances = pd.DataFrame({'Feature': X_encoded.columns, 'Importance': clf.feature_importances_})
feature_importances = feature_importances.sort_values(by='Importance', ascending=False)
print("Znaczenie (Importance) atrybutów w drzewie decyzyjnym:")
print(feature_importances)


#  Zadanie 4
tablica = {
    'department': ['sales', 'sales', 'sales', 'systems', 'systems', 'systems', 'systems', 'marketing', 'marketing',
                   'secretary', 'secretary'],
    'status': ['senior', 'junior', 'junior', 'junior', 'senior', 'junior', 'senior', 'senior', 'junior', 'senior',
               'junior'],
    'age': [[31, 35], [26, 30], [31, 35], [21, 25], [31, 35], [36, 30], [41, 45], [36, 40], [31, 35], [46, 50],
            [26, 30]],
    'salary': [[46000, 50000], [26000, 30000], [31000, 35000], [46000, 50000], [66000, 70000], [46000, 50000],
               [66000, 70000], [46000, 50000], [41000, 45000], [36000, 40000], [26000, 30000]],
    'count': [30, 40, 40, 20, 5, 3, 3, 10, 4, 4, 6]
}

df = pd.DataFrame(tablica)

# Zakłada się, że Indeks Giniego jest metryką oceny podziału. Który z podanych niżej podziałów jest
# lepszy?
# deparment = sales.
# salary ≤ 35

# department = sales
totalCount = np.sum(df['count'])

print("\nAll count: ", totalCount)

salesDepartment = df[df['department'] == 'sales']
sumSenior = np.sum(salesDepartment[salesDepartment['status'] == 'senior']['count'])
sumJunior = np.sum(salesDepartment[salesDepartment['status'] == 'junior']['count'])

notSalesDepartment = df[df['department'] != 'sales']
notSumSenior = np.sum(notSalesDepartment[notSalesDepartment['status'] == 'senior']['count'])
notSumJunior = np.sum(notSalesDepartment[notSalesDepartment['status'] == 'junior']['count'])
total = sumSenior + sumJunior

print("Ile juniorów pracujących w sales: ", sumJunior)
print("Ile seniorów pracujących w sales", sumSenior)
print("Ile w sumie osób pracujących w sales: ", total)

giniSales = 1 - (pow(sumJunior / total, 2) + pow(sumSenior / total, 2))
giniNotSales = 1 - (pow(notSumJunior / (totalCount - total), 2) + pow(notSumSenior / (totalCount - total), 2))
print("Wartość Gini dla department = sales: ", giniSales)
print("Wartość Gini dla department != sales: ", giniNotSales)
giniSalesSplit = (total / totalCount) * giniSales + ((totalCount - total) / totalCount) * giniNotSales
print("Wartość Gini Split dla department=sales: ", giniSalesSplit)

# salary < 35
salary = df[df['salary'].apply(lambda x: x[1] <= 35000)]
sumSenior = np.sum(salary[salary['status'] == 'senior']['count'])
sumJunior = np.sum(salary[salary['status'] == 'junior']['count'])
total = sumSenior + sumJunior

notSalary = df[df['salary'].apply(lambda x: x[0] > 35000)]
notSumSenior = np.sum(notSalary[notSalary['status'] == 'senior']['count'])
notSumJunior = np.sum(notSalary[notSalary['status'] == 'junior']['count'])

print("\nIle juniorów mających pensję mniejszą niż 35K: ", sumJunior)
print("Ile seniorów mających pensję mniejszą niż 35K: ", sumSenior)
print("Ile w sumie osób mających pensję mniejszą niż 35K: ", total)

giniSalary = 1 - (pow(sumJunior / total, 2) - pow(sumSenior / total, 2))
ginigNotSalary = 1 - (pow(notSumJunior / (totalCount - total), 2) + pow(notSumSenior / (totalCount - total), 2))
giniSalarySplit = (total / totalCount) * giniSalary + ((totalCount - total) / totalCount) * ginigNotSalary
print("Wartość Gini dla salary <= 35K: ", giniSalary)
print("Wartość Gini dla salary > 35K: ", ginigNotSalary)
print("Wartość Gini split dla salary <= 35K: ", giniSalarySplit)

#  Zadanie 5
#  Wyjaśnij, dlaczego algorytm EnsembleLearning, kiedy agregujemy wyniki n słabych
#  modeli przez ich średnią, to redukujemy wariancję modelu końcowego?
#  Algorytm Ensemble Learning, polegający na agregacji wyników kilku modeli (zwłaszcza słabych modeli)
#  poprzez ich średnią, redukuje wariancję modelu końcowego dzięki zasadzie uśredniania, która jest kluczowa w
#  statystyce i teorii prawdopodobieństwa.
#  Oto, dlaczego tak się dzieje:
#  1. Zrozumienie wariancji w modelu
#  Wariancja w modelu odnosi się do tego, jak bardzo wyniki modelu mogą się zmieniać w zależności od danych
#  treningowych. Modele o wysokiej wariancji są wrażliwe na zmiany w danych treningowych, co może prowadzić do
#  przeuczenia (overfittingu), czyli dobrego dopasowania do danych treningowych, ale słabego do danych testowych.
#  2. Uśrednianie wyników redukuje wariancję
#  Jeśli mamy n niezależnych modeli, które są słabymi klasyfikatorami, to wyniki tych modeli (np. ich prognozy)
#  mają pewien poziom wariancji. Kiedy uśredniamy ich wyniki, efekt losowych odchyleń poszczególnych modeli się znosi.
#  To dlatego, że odchylenia jednych modeli mogą być w przeciwną stronę niż odchylenia innych, co prowadzi do ich
#  wzajemnej kompensacji.
#  Widać, że wzrost liczby modeli n powoduje, że wariancja końcowego modelu (średniej) maleje. Tak więc większa liczba
#  modeli, których prognozy uśredniamy, prowadzi do większej stabilności i mniejszej wariancji końcowego modelu.
#  3. Zależność od niezależności modeli
#  Ważne jest, aby modele były jak najbardziej niezależne od siebie, ponieważ tylko wtedy efekt redukcji wariancji
#  będzie najbardziej efektywny. W praktyce stosuje się różne techniki (jak np. losowe podziały danych, różne parametry
#  modelu, algorytmy oparte na różnych metodach), aby zapewnić, że modele będą zróżnicowane i mniej zależne od siebie.
#  Podsumowanie
#  Ensemble Learning redukuje wariancję modelu końcowego poprzez uśrednianie wyników wielu słabych modeli, co
#  zmniejsza wpływ losowych odchyleń poszczególnych modeli. To prowadzi do bardziej stabilnego, mniej wariantnego
#  modelu, który generalizuje lepiej na danych testowych.

#  Zadanie 6
#  W algorytmie Random Forest, zbiory treningowe są wylosowane z powtórzeniem.
#  Zbiór OOB (Out Of Bag) jest używany do estymacji błędu modelu. Zakłada się, że liczba rekordów
#  jest równa n i losujemy rekordy n razy. Udowodnij, że rozmiar OOB jest rzędu 1/3 n, czyli około 1/3 liczby
#  rekordów nie zostało wylosowanych do zbioru treningowego.
