from collections import Counter
from math import sqrt
import LoadData


def getFlowerName(trainMap, value):
    for key, item in trainMap.items():
        if value == item:
            return key
    return None


def euclideanDistance(vectorOne, vectorTwo):
    distance = 0.0
    num_features = len(vectorOne) - 1
    for i in range(num_features):
        distance += (vectorOne[i] - vectorTwo[i]) ** 2
    return sqrt(distance)


def getKNeighbours(testRow, trainData, k):
    distances = []
    for trainRow in trainData:
        distance = euclideanDistance(testRow, trainRow)
        distances.append([trainRow, distance])
    distances.sort(key=lambda idx: idx[1])
    return [distances[i][0] for i in range(k)]


def predictClassification(testRow, trainData, k):
    neighbours = getKNeighbours(testRow, trainData, k)
    neighbourClasses = [neighbour[-1] for neighbour in neighbours]
    counts = Counter(neighbourClasses)
    return max(counts, key=counts.get)


def KNNAlgorithm(testSet, trainSet, k):
    return [predictClassification(testRow, trainSet, k) for testRow in testSet]


def predictImage(testRow, trainSet, k):
    return predictClassification(testRow, trainSet, k)


def getAccuracy(testSet, algorithmPrediction):
    testClasses = [row[-1] for row in testSet]
    numTestClasses = len(testClasses)
    num_correct_predictions = sum([actual == predicted for actual, predicted in zip(testClasses, algorithmPrediction)])
    accuracy = (num_correct_predictions / numTestClasses) * 100
    return accuracy


def printAccuracyTable(algorithmPrediction, testSet, k, flowerMap):
    print(f"ACCURACY TABLE FOR K = {k}")
    print("ACTUAL           PREDICTION")
    for i in range(len(algorithmPrediction)):
        prediction = getFlowerName(flowerMap, algorithmPrediction[i])
        actual = getFlowerName(flowerMap, testSet[i][-1])
        if prediction == actual:
            print(f"\033[92m{prediction}      {actual}\033[0m")
        else:
            print(f"\033[91m{prediction}      {actual}\033[0m")


def trainModel():
    trainSet, trainMap = LoadData.dataLoader("../Projekt2/irisTrain.csv")
    testSet, testMap = LoadData.dataLoader("../Projekt2/irisTest.csv")

    k = int(input("Podaj k: "))
    algorithmPrediction = KNNAlgorithm(testSet, trainSet, k)
    printAccuracyTable(algorithmPrediction, testSet, k, trainMap)
    accuracy = getAccuracy(testSet, algorithmPrediction)
    print(f'K = {k} : Average Accuracy:', accuracy)
    s = input("Podaj wymiary kwiatka: ")
    while s != '0':
        numbers = s.split(';')
        coordinates = [float(number) for number in numbers]
        prediction = predictImage(coordinates, trainSet, k)
        print(getFlowerName(trainMap, prediction))
        s = input("Podaj wymiary kwiatka: ")
