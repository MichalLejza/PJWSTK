import numpy as np
from matplotlib import pyplot as plt


ages = [23, 23, 27, 39, 41, 47, 49, 50, 52, 54, 54, 56, 57, 58, 58, 60, 61]
fat = [9.5, 26.5, 17.8, 31.4, 25.9, 27.4, 27.2, 31.2, 34.6, 42.5, 28.8, 33.4, 30.2, 34.1, 32.9, 41.2, 35.7]

averageAge = np.average(ages)
medianAge = np.median(ages)
stdAge = np.std(ages)

print("DLA WIEKU:")
print("Srednia: " + str(averageAge))
print("Mediana: " + str(medianAge))
print("StdDev: " + str(stdAge))

averageFat = np.average(fat)
medianFat = np.median(fat)
stdFat = np.std(fat)

print("\nDLA POZIOMU TLUSZCZU")
print("Srednia: " + str(averageFat))
print("Mediana: " + str(medianFat))
print("StdDev: " + str(stdFat))

correlation = np.corrcoef(ages, fat)[0, 1]
print("\nWSPOLCZYNNIK KRELACJI PEARSONA: ")
print("Wspolczynnik Korelacji: " + str(correlation))


# Tworzenie wykresu punktowego
plt.figure(figsize=(10, 6))
plt.scatter(ages, fat, color='blue', marker='o')

# Dodawanie tytułu i etykiet
plt.title('Wykres punktowy: Wiek vs Poziom tłuszczu', fontsize=14)
plt.xlabel('Wiek', fontsize=12)
plt.ylabel('Poziom tłuszczu', fontsize=12)
plt.grid(True)

# Wyświetlenie wykresu
plt.show()
