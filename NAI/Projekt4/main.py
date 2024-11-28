from bayes import BayesClassificator
from utility import *


if __name__ == '__main__':
    bayes = BayesClassificator("Data/trainingset.csv", "Data/testset.csv")
    bayes.testClassificator()
    printPredictions(bayes)
    getUserInput(bayes)
