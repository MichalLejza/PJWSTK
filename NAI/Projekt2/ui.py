class UserIntarface:
    def __init__(self, perceptron, flowerClass):
        self.perceptron = perceptron
        self.flowerClass = flowerClass

    def getFlowerName(self, value):
        for key, item in self.flowerClass.items():
            if value == item:
                return key
        return None

    def displayAccuracy(self):
        predictionList = self.perceptron.testPerceptron()
        predictions = 0
        for row in predictionList:
            if row[0] == row[1]:
                predictions += 1
        print("Accuracy of model for learning rate: " + str(self.perceptron.getLearningRate()) + " and threshold: " + str(self.perceptron.getThreshold()))
        print(str(predictions / len(predictionList) * 100) + "%")

    def displayAccuracyForFlower(self):
        predictionList = self.perceptron.testPerceptron()
        predictionsOne = 0
        predictionsTwo = 0
        actualSizeOne = 0
        actualSizeTwo = 0

        for row in predictionList:
            if row[0] == row[1] and row[0] == 0:
                predictionsOne += 1
                actualSizeOne += 1
            elif row[0] != row[1] and row[0] == 0:
                actualSizeOne += 1
            if row[0] == row[1] and row[0] == 1:
                predictionsTwo += 1
                actualSizeTwo += 1
            elif row[0] != row[1] and row[0] == 1:
                actualSizeTwo += 1

        print(str(self.getFlowerName(0)) + " " + str(predictionsOne / actualSizeOne * 100) + "%")
        print(str(self.getFlowerName(1)) + " " + str(predictionsTwo / actualSizeTwo * 100) + "%")

    def displayPredictions(self):
        predictionList = self.perceptron.testPerceptron()
        for row in predictionList:
            if row[0] == row[1]:
                print('\033[32m' + str(self.getFlowerName(row[0])) + " " + str(self.getFlowerName(row[1])))
            else:
                print('\033[31m' + str(self.getFlowerName(row[0])) + " " + str(self.getFlowerName(row[1])))

    def userInput(self):
        while 1:
            x = input("Podaj wymiary kwiata:\n")
            numbers = x.split(';')
            coordinates = [float(number) for number in numbers]
            prediction = self.perceptron.predictFlower(coordinates)
            print(self.getFlowerName(prediction))

