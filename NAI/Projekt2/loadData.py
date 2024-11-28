import csv
from random import shuffle


def readFile(pathName):
    try:
        rows = []
        with open(pathName, newline='') as csvFile:
            csvReader = csv.reader(csvFile, delimiter=';')
            for row in csvReader:
                rows.append(row)
        return rows
    except FileNotFoundError:
        print(f"Error: file '{pathName}' not found.")


def classificationMap(dataSet):
    classMap = {}
    for row in dataSet:
        flower = row[-1]
        if flower not in classMap.keys():
            classMap[flower] = len(classMap)
        row[-1] = classMap[flower]
    return classMap


def prepareData(dataSet):
    for row in dataSet:
        for column in range(len(row) - 1):
            row[column] = float(row[column].strip())


def dataLoader(pathName):
    dataSet = readFile(pathName)
    prepareData(dataSet)
    shuffle(dataSet)
    return dataSet


def loadSelectedData(pathname, nameOne, nameTwo):
    flowerList = dataLoader(pathname)
    listOne = [row for row in flowerList if row[-1] == nameOne]
    listTwo = [row for row in flowerList if row[-1] == nameTwo]
    trainListOne = []
    testListOne = []
    trainListTwo = []
    testListTwo = []
    for i in range(len(listOne)):
        if i > 0.7 * len(listOne):
            testListOne.append(listOne[i])
        else:
            trainListOne.append(listOne[i])

    for i in range(len(listTwo)):
        if i > 0.7 * len(listTwo):
            testListTwo.append(listTwo[i])
        else:
            trainListTwo.append(listTwo[i])
    trainListOne.extend(trainListTwo)
    testListOne.extend(testListTwo)
    shuffle(trainListOne)
    shuffle(testListTwo)

    return trainListOne, testListOne
