import matplotlib.pyplot as plt
import pandas as pd
from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier

path = "/Users/michallejza/PycharmProjects/PRO/Data/iris.csv"
data = pd.read_csv(path, header=None, names=['sepal_len', 'sepal_with', 'petal_len', 'petal_width', 'class'])

train, test = train_test_split(data, test_size=50, random_state=50, shuffle=True)

X_train = train.iloc[:, :4]
y_train = train.iloc[:, 4:].values.ravel()
X_test = test.iloc[:, :4]
y_test = test.iloc[:, 4:].values.ravel()

accuracies = []

k_values = range(1, 21)

for k in k_values:
    knn = KNeighborsClassifier(n_neighbors=k)
    knn.fit(X_train, y_train)
    y_pred = knn.predict(X_test)
    accuracy = accuracy_score(y_test, y_pred)
    accuracies.append(accuracy)

plt.figure(figsize=(8, 6))
plt.plot(k_values, accuracies, marker='o', color='b', label='Accuracy')
plt.title('Accuracy vs. K in KNN')
plt.xlabel('K value')
plt.ylabel('Accuracy')
plt.xticks(k_values)
plt.ylim(0.85, 1.0)
plt.grid(True)
plt.legend()
plt.show()
