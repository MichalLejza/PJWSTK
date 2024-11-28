import numpy as np
import pandas as pd
from matplotlib import pyplot as plt
from sklearn.ensemble import RandomForestRegressor
from sklearn.linear_model import LinearRegression, Ridge, Lasso
from sklearn.metrics import mean_squared_error
from sklearn.model_selection import train_test_split, RepeatedKFold, GridSearchCV
from sklearn.tree import DecisionTreeRegressor

# pobranie bazy danych
path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)
# zamiana atrybutu ocean_proximity na liczbowy
df['ocean_proximity'] = pd.factorize(df['ocean_proximity'])[0]

# usuwanie wartości nullowych
# df.dropna(inplace=True)
# zastąpienie wartości nullowych wartościami średnimi
df.fillna(df.mean(), inplace=True)

# usunięcie wartości odstających
Q1 = df.quantile(0.25)
Q3 = df.quantile(0.75)
IQR = Q3 - Q1
df = df[~((df < (Q1 - 1.5 * IQR)) | (df > (Q3 + 1.5 * IQR))).any(axis=1)]

# normalizacja danych
# df = (df - df.mean()) / df.std()

# podzielenie zbioru na zbiór treningowy i testowy
median = df['median_house_value']
X_train, X_test, y_train, y_test = train_test_split(df.drop(columns='median_house_value'), median,
                                                    test_size=0.3, random_state=1)

# model Regresji Liniowej
model = LinearRegression()
model.fit(X_train, y_train)
predictions = model.predict(X_test)
mse = mean_squared_error(y_test, predictions)
rmse = np.sqrt(mse)
print("Linear Regression: ", rmse)

# regresja liniowa z regulacją L1
model = Ridge(alpha=0.99)
model.fit(X_train, y_train)
predictions = model.predict(X_test)
mse = mean_squared_error(y_test, predictions)
rmse = np.sqrt(mse)
print("Ridge (L1): ", rmse)

# strojenie parametrów Ridge
model = Ridge()
cv = RepeatedKFold(n_splits=10, n_repeats=3, random_state=1)
grid = dict()
grid['alpha'] = np.arange(0, 1, 0.01)
search = GridSearchCV(model, grid, cv=cv, scoring='neg_mean_absolute_error', n_jobs=-1)
results = search.fit(X_train, y_train)
print("Strojenie parametrów Ridge")
print("MAE: %.3f" % results.best_score_)
print('Config: %s' % results.best_params_)

# regresja liniowa z regulacją L2
model = Lasso(alpha=0.99)
model.fit(X_train, y_train)
predictions = model.predict(X_test)
mse = mean_squared_error(y_test, predictions)
rmse = np.sqrt(mse)
print("Lasso (L2): ", rmse)

# Model Drzewa decycyjnego
model = DecisionTreeRegressor(criterion='squared_error', max_depth=10, splitter='best')
model.fit(X_train, y_train)
predictions = model.predict(X_test)
mse = mean_squared_error(y_test, predictions)
rmse = np.sqrt(mse)
print("Decision Tree: ", rmse)

# strojenie parametrów Drzewa Decyzyjnego

model = DecisionTreeRegressor()
cv = RepeatedKFold(n_splits=10, n_repeats=3, random_state=1)
grid = dict()
grid['max_depth'] = np.arange(1, 20, 2)
search = GridSearchCV(model, grid, cv=cv, scoring='neg_mean_absolute_error', n_jobs=-1)
results = search.fit(X_train, y_train)
print("Strojenie parametrów DecisionTree")
print("MAE: %.3f" % results.best_score_)
print('Config: %s' % results.best_params_)

# Model Random Forest
model = RandomForestRegressor(n_estimators=100, criterion='squared_error')
model.fit(X_train, y_train)
predictions = model.predict(X_test)
mse = mean_squared_error(y_test, predictions)
rmse = np.sqrt(mse)
print("Random Forest: ", rmse)

X = np.arange(0, 100, 1)
y = y_test[:100]
z = predictions[:100]

# Przedstawienie najlepszego modelu
plt.plot(X, y, color='r', label='Actual')
plt.plot(X, z, color='b', label='Predicted')
plt.xlabel("Test record number")
plt.ylabel("Median house value")
plt.title("Predicted vs. true label")
plt.legend(loc='best')
plt.show()
