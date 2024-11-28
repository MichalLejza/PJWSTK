import pandas as pd
from sklearn.model_selection import train_test_split

"""
Zadanie 6: (Podział zbioru danych, Modelowanie i walidacja)
Podzielić zbiór Housing na dwa podzbiory w stosunku 70 / 30 
"""


path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)
df['ocean_proximity'] = pd.factorize(df['ocean_proximity'])[0]

df.dropna(inplace=True)

train_df, test_df = train_test_split(df, test_size=0.3, random_state=42)

# Wyświetlenie zbiorów
print("Zbiór treningowy:")
print(train_df)
print("\nZbiór testowy:")
print(test_df)
