import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error

"""
Zadanie 7 (Modelowanie i walidacja)
a) Wykorzystać z regresji liniowej do modelowania danych: {from sklearn.linear_model
import LinearRegression.
b) Wyznaczyć skuteczność klasykatora:
from sklearn.metrics import mean_squared_error
"""

path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)
df['ocean_proximity'] = pd.factorize(df['ocean_proximity'])[0]

df.dropna(inplace=True)

X_train, X_test, y_train, y_test = train_test_split(df.drop(columns='ocean_proximity'), df['ocean_proximity'], test_size=0.3, random_state=42)

model = LinearRegression()
model.fit(X_train, y_train)
y_pred = model.predict(X_test)
mse = mean_squared_error(y_test, y_pred)

print(f'Mean Squared Error: {mse:.2f}')

