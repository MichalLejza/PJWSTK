import numpy as np
from matplotlib import pyplot as plt


s1 = np.array([2.02, 2.33, 2.99, 6.85, 9.20, 8.80, 7.50, 6.00, 5.85, 3.85, 4.85, 3.85, 2.22, 1.45, 1.34])
s2 = np.array([-0.12, -0.16, -0.13, 0.28, 0.37, 0.39, 0.18, 0.09, 0.15, -0.06, 0.06, -0.07, -0.13, -0.18, -0.26])


plt.figure(figsize=(12, 6))
plt.plot(s1, marker='o', linestyle='-', color='b', label='pierwszy szereg')
plt.plot(s2, marker='o', linestyle='-', color='g', label='drugi szereg')
plt.title('Wykresy szeregow', fontsize=14)
plt.xlabel('Indeks', fontsize=12)
plt.ylabel('Wartości', fontsize=12)
plt.grid()
plt.legend()

# pierwszy szereg
# MaxMin-normalizacja
s1_max = np.max(s1)
s1_min = np.min(s1)
s1_max_min_normalized = (s1 - s1_min) / (s1_max - s1_min)

# Z-normalizacja
s1_mean = np.mean(s1)
s1_std = np.std(s1)
s1_z_normalized = (s1 - s1_mean) / s1_std

print("SZEREG PIERWSZY: ")
print("Wartości po MaxMin-normalizacji:")
print(s1_max_min_normalized)

print("\nWartości po z-normalizacji:")
print(s1_z_normalized)

# drugi szerek
# max min normalizacja
s2_max = np.max(s2)
s2_min = np.min(s2)
s2_max_min_nominalized = (s2 - s2_min) / (s2_max - s2_min)

s2_mean = np.mean(s2)
s2_std = np.std(s2)
s2_z_normalized = (s2 - s2_mean) / s2_std

# wyniki
print("SZEREG DRUGI: ")
print("Wartości po MaxMin-normalizacji:")
print(s2_max_min_nominalized)

print("\nWartości po z-normalizacji:")
print(s2_z_normalized)

plt.figure(figsize=(12, 6))
plt.plot(s1_max_min_normalized, marker='o', linestyle='-', color='g', label='pierwszy szereg')
plt.plot(s2_max_min_nominalized, marker='o', linestyle='-', color='r', label='drugi szereg')
plt.title('Wykres pierwszego szeregu', fontsize=14)
plt.xlabel('Indeks', fontsize=12)
plt.ylabel('Wartości', fontsize=12)
plt.grid()
plt.legend()

plt.figure(figsize=(12, 6))
plt.plot(s1_z_normalized, marker='o', linestyle='-', color='g', label='pierwszy szereg')
plt.plot(s2_z_normalized, marker='o', linestyle='-', color='r', label='drugi szereg')
plt.title("Wykres drugiego szeregu", fontsize=14)
plt.xlabel('Indeks', fontsize=12)
plt.ylabel("Wartości", fontsize=12)
plt.grid()
plt.legend()
plt.show()
