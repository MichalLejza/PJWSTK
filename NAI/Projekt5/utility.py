import csv
from vector import Vector


def loadData(pathName):
    try:
        rows = []
        with open(pathName, newline='') as csvFile:
            csvReader = csv.reader(csvFile, delimiter=',')
            for row in csvReader:
                rows.append(prepareData(row))
        return rows
    except FileNotFoundError:
        print(f"Error: file '{pathName}' not found.")


def prepareData(vector):
    numbers = []
    for i in range(len(vector)):
        numbers.append(float(vector[i].strip()))
    vector = Vector(numbers, -1)
    return vector


def euclideanDistance(vecOne, vecTwo):
    return sum((x - y) * (x - y) for x, y in zip(vecOne, vecTwo))
