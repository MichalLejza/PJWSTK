import pandas as pd
import matplotlib.pyplot as plt

"""
Zadanie 2: (Wstępna eksploracja)
Dla zbioru Housing.csv:
a) Wyznaczyć wskaźniki statystystyczne: min, max, średnia. Sprawdzić czy
w danych występują wartości brakujące (missing values).

b) Jaka jest średnia cena mieszkań?

c) Wyznaczyć 5 wskaźników statystystycznych: min. dolny kwartyl, mean,
górny kwartyl, max dla median-house-value.

d) Wyświetlić histogram opisujący rozkład wartości zmiennej median-house-
value. Ustaw liczbę kubków (bin) na 20. Czy ten rozkład jest symetryczny?
Jeśli nie to jaki jest typ asymetrii.

e) Wyświetlić wykres słupkowy dla zmiennej ocean-proximity. Ile jest unika-
towych wartości posiada ta zmienna? Jaki jest rozkład liczby nieruchomo-
ści deniuje ocean-proximity?

"""

path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)

# opisanie wszystkich wskażników statystycznych na całym dataFramie
print(df.describe())

# średnia cena mieszkań
meanPrice = df['median_house_value'].mean()
print("Średnia Cena Mieszkań: ", meanPrice)

# wyznaczanie wartości średniej z każdej kolumny
print("AVERAGE VALUE z każdej kolumny\n", df.drop(columns='ocean_proximity').mean(), end='\n\n')

# wyznaczanie wartości średniej z każdej kolumny
print("MIN VALUE z każdej kolumny\n", df.drop(columns='ocean_proximity').quantile(0.25), end='\n\n')

# wyznaczanie wartości maksymalnej z każdej kolumny
print("MAX VALUE z każdej kolumny\n", df.drop(columns='ocean_proximity').mean(), end='\n\n')

# wyznaczanie wartości średniej z każdej kolumny
print("AVERAGE VALUE z każdej kolumny\n", df.drop(columns='ocean_proximity').quantile(0.75), end='\n\n')

# wyznaczanie wartości maksymalnej z każdej kolumny
print("MAX VALUE z każdej kolumny\n", df.drop(columns='ocean_proximity').max(), end='\n\n')

plt.figure(figsize=(10, 6))
plt.hist(df['median_house_value'], bins=20, color='skyblue', edgecolor='black')
plt.title('Distribution of Median House Value')
plt.xlabel('Median House Value')
plt.ylabel('Frequency')
plt.grid(axis='y', linestyle='--', alpha=0.7)

# wykres
plt.figure(figsize=(10, 6))
plt.bar(df['ocean_proximity'].value_counts().index, df['ocean_proximity'].value_counts().values, color='skyblue',
        edgecolor='black')
plt.title('Distribution of Ocean Proximity')
plt.xlabel('Ocean Proximity')
plt.ylabel('Frequency')
plt.grid(axis='y', linestyle='--', alpha=0.7)

plt.show()
