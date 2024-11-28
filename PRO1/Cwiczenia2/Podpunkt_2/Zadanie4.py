import matplotlib.pyplot as plt
import pandas as pd

"""
Zadanie 4: (Analiza korelacji) (Correlation matrix)
a) Wyznaczyć współczynniki korelacji zmiennymi (macierz korelacji).
b) Narysować wykresy punktowe dla dwóch atrybutów, które mają najwięk-
szy współczynnik korelacji ze median-house-value.
c) Wybrać 5 najważniejszych zmiennych.
"""

path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)

correlation_matrix = df.drop(columns='ocean_proximity').corr()
print(correlation_matrix)
print(correlation_matrix["median_house_value"].sort_values(ascending=False))

plt.figure(figsize=(8, 6))
plt.scatter(df["median_house_value"], df["median_income"], color='blue', marker='o', alpha=0.1, s=10)
plt.xlabel("Median House Value")
plt.ylabel("Median Income")
plt.title("Correlation between House Value and Income")

plt.figure(figsize=(8, 6))
plt.scatter(df["median_house_value"], df["total_rooms"], color='blue', marker='o', alpha=0.1, s=10)
plt.xlabel("Median House Value")
plt.ylabel("Total Rooms")
plt.title("Correlation between House Value and Total Rooms")
plt.show()
