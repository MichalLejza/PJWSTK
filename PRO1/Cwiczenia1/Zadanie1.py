import numpy as np
import matplotlib.pyplot as plt

ages = [1, 3, 15, 16, 16, 19, 20, 20, 21, 22, 22, 25, 25, 25, 25, 30, 33, 33, 35, 35, 36, 40, 45, 46, 95]
ages = np.sort(ages)

med = np.median(ages)
print("Mediana: " + str(med))

average = np.average(ages)
print("Srednia: " + str(average))

dolnyKwartyl = np.percentile(ages, 25)
print("Dolny Kwartyl: " + str(dolnyKwartyl))

gornyKwartyl = np.percentile(ages, 75)
print("Górny kwartyl: " + str(gornyKwartyl))

rozstep = np.max(ages) - np.min(ages)
print("Rozstęp: " + str(rozstep))

IQR = gornyKwartyl - dolnyKwartyl

# Ustalanie granic dla wartości odstających
lower_bound = dolnyKwartyl - 1.5 * IQR
upper_bound = gornyKwartyl + 1.5 * IQR

# Wyszukiwanie wartości odstających
outliers = [x for x in ages if x < lower_bound or x > upper_bound]
print(f'IQR: {IQR}')
print(f'Granice wartości odstających: {lower_bound} (dolna), {upper_bound} (górna)')
print(f'Wartości odstające: {outliers}')

plt.figure(figsize=(10, 6))
plt.boxplot(ages, vert=True, patch_artist=True)

# Dodawanie tytułu i etykiet
plt.title('Wykres pudełkowy: Wiek', fontsize=14)
plt.ylabel('Wiek', fontsize=12)

# Wyświetlenie wykresu
plt.grid(axis='y')
plt.show()


