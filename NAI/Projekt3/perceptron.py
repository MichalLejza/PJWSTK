from random import random


class Percptron:
    def __init__(self, dataSet, language, learningRate, size):
        self.dataSet = dataSet
        self.language = language
        self.learningRate = learningRate
        self.threshold = random()
        self.size = size
        self.weights = []
        self.iniciateWeights()

    def iniciateWeights(self):
        self.weights = [random() for _ in range(self.size)]

    def dotProduct(self, vector):
        return sum(x * y for x, y in zip(self.weights, vector)) - self.threshold

    def deltaRule(self, vector, error):
        for i in range(len(self.weights)):
            self.weights[i] += error * self.learningRate * vector[i]
        self.threshold += error * self.learningRate

    def trainPerceptron(self):
        for row in self.dataSet:
            net = self.dotProduct(row[1])
            algorithmPrediction = 1 if net >= 0 else 0
            actualAnwsear = 1 if self.language == row[0] else 0
            self.deltaRule(row[1], actualAnwsear - algorithmPrediction)

    def testPerceptron(self, row):
        return self.dotProduct(row)


