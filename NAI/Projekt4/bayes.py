from utility import *


class BayesClassificator:
    def __init__(self, trainPath, testPath):
        self.trainData = loadData(trainPath)
        self.testData = loadData(testPath)
        self.decisionsCount = countDecisions(dataSet=self.trainData)
        self.bayesPredictions = []

    def getNumberOfAttributes(self, decision, col, value):
        numberOfAttributes = 0
        for row in self.trainData:
            if row[-1] == decision and row[col] == value:
                numberOfAttributes += 1
        return numberOfAttributes

    def getNumberOfDifferentAttributes(self, col):
        attributes = set()
        for row in self.trainData:
            attributes.add(row[col])
        return len(attributes)

    def testClassificator(self):
        for row in self.testData:
            probablities = {}
            for decision, numberOfDecisions in self.decisionsCount.items():
                probability = numberOfDecisions / len(self.trainData)
                for column in range(len(row)):
                    numberOfAttributes = self.getNumberOfAttributes(decision, column, row[column])
                    if numberOfAttributes == 0:
                        probability *= (1 / (numberOfDecisions + self.getNumberOfDifferentAttributes(column)))
                    else:
                        probability *= (numberOfAttributes / numberOfDecisions)
                probablities[decision] = round(probability, 5)
            self.bayesPredictions.append([probablities, max(probablities, key=probablities.get)])

    def predict(self, row):
        probablities = {}
        for decision, numberOfDecisions in self.decisionsCount.items():
            probability = numberOfDecisions / len(self.trainData)
            for column in range(len(row)):
                numberOfAttributes = self.getNumberOfAttributes(decision, column, row[column])
                if numberOfAttributes == 0:
                    probability *= (1 / (numberOfDecisions + self.getNumberOfDifferentAttributes(column)))
                else:
                    probability *= (numberOfAttributes / numberOfDecisions)
            probablities[decision] = round(probability, 5)
        return max(probablities, key=probablities.get), probablities
