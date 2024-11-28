import pandas as pd
import matplotlib.pyplot as plt


path = "/Users/michallejza/PycharmProjects/PRO/Data/iris.csv"
data = pd.read_csv(path, header=None, names=['sepal_len', 'sepal_with', 'petal_len', 'petal_width', 'class'])

# zamiana odpowiednich wartości na listy
petalWidth = data['petal_width'].to_list()
petalLength = data['petal_len'].to_list()

Iris_features = data.iloc[:, :4]
Iris_class = data.iloc[:, 4:]

fig = plt.figure(figsize=(10, 5), dpi=100, facecolor='w', edgecolor='k')
Iris_features.plot(kind='box', subplots=True, layout=(2, 2), sharex=False, sharey=False)
plt.show()
