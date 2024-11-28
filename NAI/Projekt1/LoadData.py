import csv


def importData(pathName):
    try:
        rows = []
        with open(pathName, newline='') as csvFile:
            csvReader = csv.reader(csvFile, delimiter=';')
            for row in csvReader:
                rows.append(row)
        return rows
    except FileNotFoundError:
        print(f"Error: file '{pathName}' not found.")


def prepareData(dataSet):
    for row in dataSet:
        for column in range(len(row) - 1):
            row[column] = float(row[column].strip())


def classificationMap(dataSet):
    classMap = {}
    for row in dataSet:
        flower = row[-1]
        if flower not in classMap.keys():
            classMap[flower] = len(classMap)
        row[-1] = classMap[flower]
    return classMap


def dataLoader(pathName):
    dataSet = importData(pathName)
    dataSet.pop()
    prepareData(dataSet)
    classMap = classificationMap(dataSet)
    return dataSet, classMap
