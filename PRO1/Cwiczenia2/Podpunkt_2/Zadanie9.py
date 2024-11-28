import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error
from sklearn.model_selection import train_test_split

"""
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
"""

path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)
df['ocean_proximity'] = pd.factorize(df['ocean_proximity'])[0]

df.dropna(inplace=True)

df['room_ave'] = df['total_rooms'] / df['households']
df['bedrooms_ave'] = df['total_bedrooms'] / df['households']
df['persons_per_house'] = df['population'] / df['households']
df.drop(columns='population', inplace=True)
df.drop(columns='total_rooms', inplace=True)
df.drop(columns='total_bedrooms', inplace=True)


X_train, X_test, y_train, y_test = train_test_split(df.drop(columns='median_house_value'), df['median_house_value'], test_size=0.3, random_state=42)

model = LinearRegression()
model.fit(X_train, y_train)
y_pred = model.predict(X_test)
mse = mean_squared_error(y_test, y_pred)
rmse = np.sqrt(mse)

print(f'Root Mean Squared Error: {rmse:.2f}')

