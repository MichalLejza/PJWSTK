class UserInterFace:
    def __init__(self, model):
        self.model = model

    def printModelPrecision(self):
        print("---------------------------------")
        modelPredictions = self.model.test()
        for prediction in modelPredictions:
            if prediction[0] == prediction[1]:
                print('\033[92m' + prediction[0] + " " + prediction[1] + '\033[0m')
            else:
                print('\033[91m' + prediction[0] + " " + prediction[1] + '\033[0m')
        print("---------------------------------")

    def calculateAccuracy(self):
        print("Average Accuracy for : " + str(self.model.iteration) + " epochs: ", end=" ")
        accuracySum = 0
        for i in self.model.accuracyHistory:
            accuracySum += i
        print(str(accuracySum / len(self.model.accuracyHistory)) + "%")
        print("---------------------------------")

    def userInput(self):
        while 1:
            text = input("Podaj tekst do sprawdzenia: \n")
            self.model.predictText(text)
