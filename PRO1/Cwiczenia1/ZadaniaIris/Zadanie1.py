import pandas as pd


path = "/Users/michallejza/PycharmProjects/PRO/Data/iris.csv"
data = pd.read_csv(path, header=None, names=['sepal_len', 'sepal_with', 'petal_len', 'petal_width', 'class'])
print(data)
