import numpy as np

"""
Zakłada się, że klasykator Bayesowski rankinguje rekordy względem prawdopodobieństwa przynalezienia do 
klasy pozytywnej w następujący sposób: 
Sporządzić krzywą Lift dla tego klasykatora dla nast¦puj¡cych punktów ci¦cia:
20%, 40%, 60%, 80%, 100%.

Id      Score          Yes  No
1-10    [0.97-0.90]     8   2
11-20   [0.86-0.82]     7   3
21-30   [0.79-0.78]     6   4
31-40   [0.73-0.70]     3   7
41-50   [0.65-0.60]     1   9

"""
import matplotlib.pyplot as plt

# Krzywa lift jest używana do oceny skuteczności modelu klasyfikacyjnego w porównaniu z
# losowym zgadywaniem. Pokazuje, jak dobrze model radzi sobie w przewidywaniu pozytywnych
# przypadków (tutaj klasy "Yes") w porównaniu z bazowym modelem losowym.

# Aby sporządzić krzywą lift na podstawie podanych danych, postępujemy według tych kroków:
#
# Krok 1: Oblicz łączną liczbę przypadków i "Yes"
# W tabeli podano łącznie 50 przypadków. Sumujemy liczbę przypadków, które są "Yes" i "No":
#
# Łączna liczba przypadków: 50 (10 w każdym zakresie Id)
# Łączna liczba "Yes":
# 8+7+6+3+1=25
# 8+7+6+3+1=25

# Krok 2: Określenie punktów cięcia
# Dla punktów cięcia 100%, 80%, 60%, 40%, 20% oznacza to, że bierzemy określony procent
# próbek uszeregowanych według ich Score (od najwyższego do najniższego), a następnie obliczamy,
# jaki odsetek "Yes" jest zawarty w tym przedziale w stosunku do całkowitej liczby "Yes".

# Krok 3: Oblicz odsetek "Yes" w kolejnych punktach cięcia

# Punkt cięcia 100%:
# Obejmuje wszystkie 50 przypadków (Id od 1 do 50).
# Liczba "Yes" w całym zbiorze: 25.
# Odsetek "Yes" w całym zbiorze: 25/25 = 1

# Punkt cięcia 80%:
# Obejmuje 80% przypadków, czyli Id od 1 do 40.
# Liczba "Yes" w tym zakresie: 8 + 7 + 6 + 3 = 24
# Odsetek "Yes" w tych 80%: 24 / 25 = 0.96

# Punkt cięcia 60%:
# Obejmuje 60% przypadków, czyli Id od 1 do 30.
# Liczba "Yes" w tym zakresie: 8 + 7 + 6 = 21
# Odsetek "Yes" w tych 60%: 21 / 25 = 0.84

# Punkt cięcia 40%:
# Obejmuje 40% przypadków, czyli Id od 1 do 20.
# Liczba "Yes" w tym zakresie: 8 + 7 = 15
# Odsetek "Yes" w tych 40%: 12 / 25 = 0.6

# Punkt cięcia 20%:
# Obejmuje 20% przypadków, czyli Id od 1 do 10.
# Liczba "Yes" w tym zakresie: 8.
# Odsetek "Yes" w tych 20%: 8 / 25 = 0.32

# Dane: id, score, liczba "Yes", liczba "No"
data = {
    'id_range': ['1-10', '11-20', '21-30', '31-40', '41-50'],
    'score_range': [0.97, 0.86, 0.79, 0.73, 0.65],  # Używamy najwyższych wartości z zakresów
    'yes': [8, 7, 6, 3, 1],
    'no': [2, 3, 4, 7, 9]
}

# Suma wszystkich "Yes" i "No"
total_yes = sum(data['yes'])
total_no = sum(data['no'])

# Obliczamy punkt cięcia (100%, 80%, 60%, 40%, 20%) i odsetek "Yes"
cuts = [1.0, 0.8, 0.6, 0.4, 0.2]
yes_accumulated = [sum(data['yes'][:int(len(data['yes']) * cut)]) for cut in cuts]
percent_yes = [yes / total_yes for yes in yes_accumulated]

# Bazowy odsetek "Yes" w całej populacji
baseline_yes_rate = total_yes / (total_yes + total_no)

# Obliczamy lift
lift_values = [yes_rate / baseline_yes_rate for yes_rate in percent_yes]

# Tworzymy wykres
plt.plot([100, 80, 60, 40, 20], lift_values, marker='o', linestyle='-', color='b')

# Ustawienia wykresu
plt.title('Lift Curve')
plt.xlabel('Percentage of Population (%)')
plt.ylabel('Lift')
plt.grid(True)

# Wyświetlamy wykres
plt.show()
