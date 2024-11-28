import pandas as pd
import matplotlib.pyplot as plt


path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)

longitude = df['longitude']
latitude = df['latitude']

plt.scatter(longitude, latitude, color='blue', marker='o', alpha=0.5, s=10)
plt.title('Ocean Proximity Scatter Chart')
plt.xlabel('Longitude')
plt.ylabel('Latitude')
plt.grid(True)


df.drop(columns='ocean_proximity', inplace=True)
fig, axes = plt.subplots(3, 3, figsize=(12, 12))
i = 0
j = 0
for column in df.columns:
    if i == 3:
        i = 0
        j += 1
    axes[i][j].hist(df[column], bins=50, color='skyblue', edgecolor='black')
    axes[i][j].set_title(f'Histogram of {column}')
    axes[i][j].set_xlabel(column)
    axes[i][j].set_ylabel('Number')
    axes[i][j].grid(True)
    i += 1
plt.tight_layout()


plt.figure(figsize=(10, 8))
plt.boxplot(df['median_house_value'])
plt.title('Wykres pudełkowy: median_house_value')
plt.xlabel('median_house_value')
plt.ylabel('Values')
plt.show()
