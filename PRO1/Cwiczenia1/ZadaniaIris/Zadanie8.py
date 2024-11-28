import pandas as pd
from sklearn.model_selection import train_test_split, StratifiedKFold, cross_val_score
from sklearn.naive_bayes import GaussianNB
from sklearn.neighbors import KNeighborsClassifier

path = "/Users/michallejza/PycharmProjects/PRO/Data/iris.csv"
# czytamy dane z podanego pliku i umieszczamy w dat framie i nazywamy kolumny w liście 'names'
data = pd.read_csv(path, header=None, names=['sepal_len', 'sepal_with', 'petal_len', 'petal_width', 'class'])

# dzielimy zbiór danych na podzbiór treningowy i testowy w proprocjach 100/50 i za każdym razem mieszamy zbiór
train, test = train_test_split(data, test_size=50, random_state=50, shuffle=True)

# odpowiednio dzielimy zbiór treningowy i testowy na wartości obiektu i nazwę kwiatka
X_train = train.iloc[:, :4]
# .values.ravel() zmienia tablicę dwuwwymiarową 100x1 na tablicę jednowymiarową 100
y_train = train.iloc[:, 4:].values.ravel()
X_test = test.iloc[:, :4]
y_test = test.iloc[:, 4:].values.ravel()

# wykonujemy walidację krzyzową z uzyciem 10 podziałów (folds) na zbiorze treningowym, aby ocenić model
# na podstawie jego dokładności
# najpierw dzielimy zbiór treningowy na 10 części z dbamy żeby proporcje klas w każdej części są takie same
# 1 zbiór służy jako zbiór walidacyjny a reszta zbiór treningowy
kfold = StratifiedKFold(n_splits=10, random_state=1, shuffle=True)
cv_results = cross_val_score(GaussianNB(), X_train, y_train, cv=kfold, scoring='accuracy')
print(cv_results.mean(), cv_results.std())

kfold = StratifiedKFold(n_splits=10, random_state=1, shuffle=True)
cv_results = cross_val_score(KNeighborsClassifier(), X_train, y_train, cv=kfold, scoring='accuracy')
print(cv_results.mean(), cv_results.std())

