import pandas as pd
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split

"""
Zadanie 10 (Podsumowanie)
a) Które zmienne są istotne (mają wpływ na cenę nieruchomości)?
b) Wpływ nowych atrybutów na jakość predykcji.
c) Wpływ usunięcia wartości odstających na jakość predykcji.
d) Najlepszy wynik RMSE.
"""

# pobranie danych do data frame'a
path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)

# zastąpienie atrybutu 'ocean_proximity' liczbami
df['ocean_proximity'] = pd.factorize(df['ocean_proximity'])[0]

# zastąpienie wartości NULL wartościami średnimi w kazdej kolumnie


# usunięcie wartości odstających
for column in df.columns:
    Q1 = df[column].quantile(0.25)
    Q3 = df[column].quantile(0.75)
    IQR = Q3 - Q1
    df = df[(df[column] >= Q1 - 1.5 * IQR) & (df[column] <= Q3 + 1.5 * IQR)]

X_train, X_test, y_train, y_test = train_test_split(df.drop(columns='median_house_value'), df['median_house_value'],
                                                    test_size=0.3, random_state=42)

