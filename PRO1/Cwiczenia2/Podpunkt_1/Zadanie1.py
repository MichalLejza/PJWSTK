import numpy as np

"""
Zadanie 1. Zakłada się, że macierze pomyłek (ang. confusion matrix) dla pew-
nego klasykatora jest następujący:
TP FP   57 3
FN TN   5 35
Wyznaczyć następujące parametry oceniające klasykator
a) Accuracy.
b) Sensitivity (TP rate, Recall).
c) Specicity (TN rate).
d) False positive rate (F P rate = 1−T N rate).
e) Precision
f) F-Measure
"""

# utworzenie macierzy pomyłek
matrix = np.array([[57, 3], [5, 35]], dtype=np.int32)

TP = matrix[0, 0]
FP = matrix[0, 1]
FN = matrix[1, 0]
TN = matrix[1, 1]
# dokładność (accuracy) sumujemy poprawne predykcje i dzielimy przez sume wszystkich predykcji
# acc = (TP + TN) / (TP + FN + TN + FP)
acc: float = (TP + TN) / np.sum(matrix)
print("Model Accuracy: ", acc)

# Recall to miara w uczeniu maszynowym, która określa,
# jaką część rzeczywistych pozytywnych przypadków model poprawnie zidentyfikował
# Recall = TP / (TP + FN)
recall = (TP / (TP + FN))
print("Recall: ", recall)

# Specificity to miara, która określa, jaką część rzeczywistych negatywnych przypadków model poprawnie zidentyfikował
# Specifity = TN / (TN + FP)
specificity = (TN / (TN + FP))
print("Specificity: ", specificity)

# False Positive Rate to miara, która określa, jaką część rzeczywistych
# negatywnych przypadków model błędnie zaklasyfikował jako pozytywne
# FPRate = FP / (FP + TN)
FPRate = (matrix[0][1] / (matrix[0][1] + matrix[1][1]))
print("FPRate: ", FPRate)

# Precision to miara w uczeniu maszynowym, która wskazuje, jaki procent przypadków zaklasyfikowanych
# przez model jako pozytywne, faktycznie jest pozytywny
# Precision = TP / (TP + FP)
precision = (matrix[0][0] / (matrix[0][0] + matrix[0][1]))
print("Precision: ", precision)

# F-measure to harmoniczna średnia Precision i Recall, używana do oceny modelu,
# gdy zależy nam zarówno na precyzji, jak i pełności.
# F-Measure = (2 * Precision * Recall) / (Precision + Recall)
FMeasure = (2 * precision * recall) / (precision + recall)
print("FMeasure: ", FMeasure)
