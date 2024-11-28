import pandas as pd
from sklearn.metrics import accuracy_score
from sklearn.metrics import classification_report
from sklearn.metrics import confusion_matrix
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import GaussianNB

path = "/Users/michallejza/PycharmProjects/PRO/Data/iris.csv"
data = pd.read_csv(path, header=None, names=['sepal_len', 'sepal_with', 'petal_len', 'petal_width', 'class'])

train, test = train_test_split(data, test_size=50, random_state=50, shuffle=True)

X_train = train.iloc[:, :4]
y_train = train.iloc[:, 4:].values.ravel()
X_test = test.iloc[:, :4]
y_test = test.iloc[:, 4:].values.ravel()

gnb = GaussianNB()
gnb.fit(X_train, y_train)
predictions = gnb.predict(X_test)
accuracy = accuracy_score(y_test, predictions)

print(f"Dokładność klasyfikatora Bayesowskiego: {accuracy * 100:.2f}%")
print(confusion_matrix(y_test, predictions))
print(classification_report(y_test, predictions))
