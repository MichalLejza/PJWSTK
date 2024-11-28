import numpy as np

vector1 = np.array([22, 1, 42, 10])
vector2 = np.array([20, 0, 36, 8])

euclid = np.sqrt(np.sum((vector1 - vector2) ** 2))
print("Odległość Euklideoswa: " + str(euclid))

manhattan = np.sum(np.abs(vector1 - vector2))
print("Odległość Manhattan: " + str(manhattan))

p = 2
minkowski = np.power(np.sum(np.abs(vector1 - vector2) ** p), 1/p)
print("Odleglosc minkowskiego: " + str(minkowski))

cosinusowa = 1 - (np.dot(vector1, vector2) / (np.linalg.norm(vector1) * np.linalg.norm(vector2)))
print("Odleglosc cosinusowa: " + str(cosinusowa))
