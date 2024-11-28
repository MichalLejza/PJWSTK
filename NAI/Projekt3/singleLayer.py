import loadData
from perceptron import Percptron


class SingleLayerNetwork:
    def __init__(self, pathTrain, pathTest, learningRate):
        self.learningRate = learningRate
        self.testSet = loadData.loadData(pathTest)
        self.trainSet = loadData.loadData(pathTrain)
        self.outputLayer = []
        self.accuracyHistory = []
        self.iteration = 300
        self.languages = set()
        self.languageClasses()
        self.createPerceptrons()

    def languageClasses(self):
        for language in self.trainSet:
            self.languages.add(language[0])

    def createPerceptrons(self):
        for language in self.languages:
            p = Percptron(self.trainSet, language, self.learningRate, 26)
            self.outputLayer.append(p)

    def calculateAccuracyOverTime(self):
        temp = []
        accuratePredictions = 0
        for row in self.testSet:
            for perceptron in self.outputLayer:
                temp.append([perceptron.language, perceptron.testPerceptron(row[1])])
            if row[0] == max(temp, key=lambda x: x[1])[0]:
                accuratePredictions += 1
            temp.clear()
        self.accuracyHistory.append(accuratePredictions / len(self.testSet))

    def train(self):
        for _ in range(self.iteration):
            for perecptron in self.outputLayer:
                perecptron.trainPerceptron()
            self.calculateAccuracyOverTime()

    def test(self):
        temp = []
        modelPredictions = []
        for row in self.testSet:
            for perceptron in self.outputLayer:
                temp.append([perceptron.language, perceptron.testPerceptron(row[1])])
            modelPredictions.append([row[0], max(temp, key=lambda x: x[1])[0]])
            temp.clear()
        return modelPredictions

    def predictText(self, text):
        row = loadData.prepareText(text)
        temp = []
        for perceptron in self.outputLayer:
            temp.append([perceptron.language, perceptron.testPerceptron(row)])
        print(max(temp, key=lambda x: x[1])[0])
