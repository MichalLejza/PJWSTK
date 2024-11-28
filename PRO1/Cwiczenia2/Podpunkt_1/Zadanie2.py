import numpy as np

"""
Wykorzystano dwa klasykatory kNN i Bayesowski do klasykacji dokumentów. Zakłada się, że macierze pomyłek
(ang. confusion matrix) tych klasykatorów są odpowiednio:

TP FP   45 12
FN TN   8 35

TP FP   50 15
FN TN   5 30

a) Która miara oceny jest najbardziej adekwatna dla danego problemu?
b) Oceń, który klasykator jest lepszy?
"""

knn = np.array([[45, 12], [8, 35]], dtype=np.int32)
bayes = np.array([[50, 15], [5, 30]], dtype=np.int32)

print("KNN: ")
print(knn)

accuracyKNN = (knn[0][0] + knn[1][1]) / np.sum(knn)
print("Accuracy KNN: ", accuracyKNN)
accuracyBayes = (bayes[0][0] + bayes[1][1]) / np.sum(bayes)

precisionKNN = knn[0][0] / (knn[0][0] + knn[0][1])
print("Precision KNN: ", precisionKNN)
precisionBayes = bayes[0][0] / (bayes[0][0] + bayes[0][1])

recallKNN = knn[0][0] / (knn[0][0] + knn[1][0])
print("Recall KNN: ", recallKNN)
recallBayes = bayes[0][0] / (bayes[0][0] + bayes[1][0])

FMeasureKNN = (2 * precisionKNN * recallKNN) / (precisionKNN + recallKNN)
print("F-Measure KNN: ", FMeasureKNN)
FMeasureBayes = (2 * precisionBayes * recallBayes) / (precisionBayes + recallBayes)

print("\nBayes: ")
print(bayes)
print("Accuracy Bayes: ", accuracyBayes)
print("Precision Bayes: ", precisionBayes)
print("Recall Bayes: ", recallBayes)
print("F-Measure Bayes: ", FMeasureBayes)

