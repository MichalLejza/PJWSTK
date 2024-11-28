import csv


def loadData(path):
    data = []
    with open(path, 'r', newline='', encoding='utf-8') as file:
        csvReader = csv.reader(file)
        for row in csvReader:
            data.append(row)
    return data


def countDecisions(dataSet):
    decisions = {}
    for row in dataSet:
        if row[-1] in decisions:
            decisions[row[-1]] += 1
        else:
            decisions[row[-1]] = 1
    return decisions


def printPredictions(bayes):
    for i in bayes.bayesPredictions:
        print(i)


def getUserInput(bayes):
    while 1:
        row = input("Podaj parametry:\n")
        data = [word.strip() for word in row.split(',')]
        prediction, calculations = bayes.predict(data)
        print("Prediction: " + prediction)
        print("Probabilities: ", end='')
        print(calculations)
