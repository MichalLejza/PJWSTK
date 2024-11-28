import pandas as pd
import matplotlib.pyplot as plt


path = "/Users/michallejza/PycharmProjects/PRO/Data/iris.csv"
data = pd.read_csv(path, header=None, names=['sepal_len', 'sepal_with', 'petal_len', 'petal_width', 'class'])

# zamiana odpowiednich wartości na listy
petalWidth = data['petal_width'].to_list()
petalLength = data['petal_len'].to_list()

Iris_features = data.iloc[:, :4]
Iris_class = data.iloc[:, 4:]

correlation_matrix = Iris_features.corr()
plt.figure(figsize=(9, 4))
plt.matshow(correlation_matrix, cmap='BrBG')
plt.colorbar()
plt.title('Correlation Map Of Iris', fontdict={'fontsize': 12}, pad=12)

plt.figure(figsize=(6, 5))
plt.scatter(petalWidth, petalLength)
plt.xlabel('Petal Width')
plt.ylabel('Petal Length')
plt.show()

