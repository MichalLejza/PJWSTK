import pandas as pd

"""
Zadanie 1: 
Wczytanie, wyświetlenie danych.
Wykonaj następujące czynności:
a) Importuj zbiór danych Housing.csv.

b) Zrób wstępną analizę danych i podaj:
 - liczbę rekordów (pandas.DataFrame.shape).
 - liczbę atrybutów.
 - typy atrybutów (pandas.DataFrame.info()).
 - czy wartości brakujące (missing values) print(df.isnull())?
 - znaczenia atrybutów.
 
"""

# zimportowanie pliku CSV do data frame-u
path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)

# liczba rekordów
liczbaRekordow = df.shape[0]
print("Liczba Rekordów czyli ile jest wierszy: ", liczbaRekordow)

# liczba atrybutów
liczbaKolumn = df.shape[1]
print("Liczba Kolumn czyli ile różnych atrybutów jest: ", liczbaKolumn)
print()

# typy atrybutów
print("Wszystkie typy atrybutów czyli kolumn:\n", df.dtypes, end="\n\n")

# brakujące wartości
print("Liczba wartości NULL czyli brakujących wartości w każdej kolumnie:\n", df.isnull().sum())
