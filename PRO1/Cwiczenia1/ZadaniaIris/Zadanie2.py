import pandas as pd


path = "/Users/michallejza/PycharmProjects/PRO/Data/iris.csv"
data = pd.read_csv(path, header=None, names=['sepal_len', 'sepal_with', 'petal_len', 'petal_width', 'class'])

print("Liczba obiektów / Liczba kolumn: ")
print(data.shape)
print(data.groupby('class').size())

print("Pierwsze 10 wierszy: ")
print(data.head(10))

print("Typy atrybutów: ")
print(data.info())
