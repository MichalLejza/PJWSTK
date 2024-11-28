from random import random
from random import shuffle


class Perceptron:
    def __init__(self, trainSet, testSet, trainRate, threshhold):
        self.trainSet = trainSet
        self.testSet = testSet
        self.trainRate = trainRate
        self.threshhold = threshhold
        self.weights = [random() for _ in range(len(trainSet[0]) - 1)]
        self.classMap = self.classificationMap()
        shuffle(self.trainSet)

    def getWeights(self):
        return self.weights

    def getLearningRate(self):
        return self.trainRate

    def getThreshold(self):
        return self.threshhold

    def classificationMap(self):
        classMap = {}
        for row in self.trainSet:
            flower = row[-1]
            if flower not in classMap.keys():
                classMap[flower] = len(classMap)
            row[-1] = classMap[flower]

        for row in self.testSet:
            flower = row[-1]
            if flower not in classMap.keys():
                classMap[flower] = len(classMap)
            row[-1] = classMap[flower]
        return classMap

    def dotProduct(self, vector):
        return sum(x * y for x, y in zip(self.weights, vector))

    def deltaRule(self, vector, actualFlower, predictedFlower):
        for i in range(len(self.weights)):
            self.weights[i] += (actualFlower - predictedFlower) * self.trainRate * vector[i]
        self.threshhold -= (actualFlower - predictedFlower) * self.trainRate

    def trainPerceptron(self):
        for row in self.trainSet:
            net = self.dotProduct(row[0:-1])
            algorithmPrediction = 1 if net > 0 else 0
            self.deltaRule(row, row[-1], algorithmPrediction)

    def testPerceptron(self):
        shuffle(self.testSet)
        flowerPredictions = []
        for row in self.testSet:
            net = self.dotProduct(row[0:-1])
            prediction = 1 if net > 0 else 0
            flowerPredictions.append([row[-1], prediction])
        return flowerPredictions

    def predictFlower(self, flower):
        net = self.dotProduct(flower)
        return 1 if net > 0 else 0

    def calculateAccuracy(self, predictionsNumber):
        print(str(100 * (predictionsNumber / len(self.testSet))) + '%')
