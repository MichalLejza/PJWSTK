import loadData
from perceptron import Perceptron
from ui import UserIntarface

if __name__ == '__main__':
    trainSet, testSet = loadData.loadSelectedData("iris.csv", "Iris-versicolor", "Iris-virginica")

    learnRate = 0.1
    threshhold = -1

    p = Perceptron(trainSet, testSet, learnRate, threshhold)
    p.trainPerceptron()

    # root = tk.Tk()
    # display = Display(master=root, width=400, height=400, flowerSet=flowerSet, flowerClasses=flowerClass)
    # display.mainloop()

    flowerSet = loadData.dataLoader("iris.csv")
    flowerClass = loadData.classificationMap(flowerSet)
    ui = UserIntarface(p, flowerClass)
    ui.displayAccuracy()
    ui.displayAccuracyForFlower()
    ui.displayPredictions()
    ui.userInput()
