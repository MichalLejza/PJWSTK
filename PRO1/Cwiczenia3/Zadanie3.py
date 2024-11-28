import matplotlib.pyplot as plt
import pandas as pd

path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)
df.drop(columns='ocean_proximity', inplace=True)

corr_matrix = df.corr()

print(corr_matrix["median_house_value"].sort_values(ascending=False))

plt.figure(figsize=(8, 6))
plt.imshow(corr_matrix, cmap='coolwarm', interpolation='none')
plt.colorbar(label='Correlation Coefficient')
plt.xticks(range(len(corr_matrix.columns)), corr_matrix.columns, rotation=45)
plt.yticks(range(len(corr_matrix.columns)), corr_matrix.columns)
plt.title('Correlation Matrix')
for i in range(len(corr_matrix.columns)):
    for j in range(len(corr_matrix.columns)):
        plt.text(j, i, f"{corr_matrix.iloc[i, j]:.2f}",
                 ha="center", va="center", color="black")
plt.show()
