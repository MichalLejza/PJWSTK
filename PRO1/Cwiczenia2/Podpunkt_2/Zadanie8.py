import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.metrics import root_mean_squared_error
from sklearn.model_selection import train_test_split

"""
Zadanie 8 (Odfiltrowanie wartości odstających)
a) Usunąć rekordy zawierające wartości odstające na total_bedrooms i to-
tal_rooms.
b) Tworzyć model regresyjny.
c) Oblicz błąd RMSE i related error.
d) Porównywać wyniki modelu obliczonych na danych oryginalnych i danych
bez wartości ostających
"""

path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)
df['ocean_proximity'] = pd.factorize(df['ocean_proximity'])[0]

df.dropna(inplace=True)

roomsQ1 = df['total_rooms'].quantile(0.25)
roomsQ3 = df['total_rooms'].quantile(0.75)
roomsIQR = roomsQ3 - roomsQ1

df = df[(df['total_rooms'] >= roomsQ1 - 1.5 * roomsIQR) & (df['total_rooms'] <= roomsQ3 + 1.5 * roomsIQR)]

bedroomsQ1 = df['total_bedrooms'].quantile(0.25)
bedroomsQ3 = df['total_bedrooms'].quantile(0.75)
bedroomsIQR = bedroomsQ3 - bedroomsQ1

df = df[(df['total_bedrooms'] >= bedroomsQ1 - 1.5 * bedroomsIQR) & (df['total_bedrooms'] <= bedroomsQ3 + 1.5 * bedroomsIQR)]

X_train, X_test, y_train, y_test = train_test_split(df.drop(columns='median_house_value'), df['median_house_value'], test_size=0.3, random_state=42)

model = LinearRegression()
model.fit(X_train, y_train)
y_pred = model.predict(X_test)
rmse = root_mean_squared_error(y_test, y_pred)

print(f'Root Mean Squared Error: {rmse:.2f}')

