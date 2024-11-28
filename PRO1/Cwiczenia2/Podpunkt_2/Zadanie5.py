import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error
from sklearn.model_selection import train_test_split
import numpy as np

"""
Zadanie 5: (Konwertowanie wartości symbolicznych na numeryczne):
a) Konwertować atrybut ocean-proximity na wartości numeryczne {1, 2, 3, 4}.
b) Usunąć wartości brakujące

Zadanie 6: (Podział zbioru danych, Modelowanie i walidacja)
Podzielić zbiór Housing na dwa podzbiory w stosunku 70 / 30 

Zadanie 7 (Modelowanie i walidacja)
a) Wykorzystać z regresji liniowej do modelowania danych: {from sklearn.linear_model
import LinearRegression.
b) Wyznaczyć skuteczność klasykatora:
from sklearn.metrics import mean_squared_error

Zadanie 8 (Odfiltrowanie wartości odstających)
a) Usunąć rekordy zawierające wartości odstające na total_bedrooms i to-
tal_rooms.
b) Tworzyć model regresyjny.
c) Oblicz błąd RMSE i related error.
d) Porównywać wyniki modelu obliczonych na danych oryginalnych i danych
bez wartości ostających

Zadanie 9: (Tworzenie nowych atrybutów)
Generować nowe zmienne przez kombinację zmiennych regularnych:
rooms_Ave: średnia liczba pokojów,
bedrooms_Ave: średnia liczba sypialni,
persons_per_house: średnia liczba domowników w mieszkaniu

Wzory są następujące:
room_Ave = total_rooms / households
bedrooms_Ave = total_bedrooms / households
persons_per_house = population / households

Zastąpić zmienne total_room, total_bedrooms, population nowymmi zmiennymi.
Tworzyć model regresyjny.
a) Oblicz błąd RMSE i related error.
b) Porównywać wyniki modelu obliczonych na danych oryginalnych i danych
z nowymi atrybutami.

Zadanie 10 (Podsumowanie)
a) Które zmienne są istotne (mają wpływ na cenę nieruchomości)?
b) Wpływ nowych atrybutów na jakość predykcji.
c) Wpływ usunięcia wartości odstających na jakość predykcji.
d) Najlepszy wynik RMSE.
"""

path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)
df['ocean_proximity'] = pd.factorize(df['ocean_proximity'])[0]

df.fillna(df.mean(), inplace=True)

X_train, X_test, y_train, y_test = train_test_split(df.drop(columns='median_house_value'), df['median_house_value'],
                                                    test_size=0.3, random_state=42)

model = LinearRegression()
model.fit(X_train, y_train)
y_pred = model.predict(X_test)
mse = mean_squared_error(y_test, y_pred)


print(f'Root Mean Squared Error: {np.sqrt(mse):.2f}')
