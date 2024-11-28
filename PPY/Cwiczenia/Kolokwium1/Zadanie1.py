from random import randint
from math import fsum


def printSquareList(l):
    for i in l:
        print(i)


def findMaxSum(l, rows, cols):
    maxSum = 0
    for i in range(rows - 1):
        for j in range(cols - 1):
            temp = l[i][j] + l[i + 1][j] + l[i][j + 1] + l[i + 1][j + 1]
            maxSum = temp if temp > maxSum else maxSum
    print(maxSum)


def sumUpperTriangle(l, rows, cols):
    suma = 0
    for i in range(rows):
        for j in range(i + 1, cols):
            suma += l[i][j]
    print(suma)


def mostCommonElement(l, rows, cols):
    elements = {}
    for i in range(rows):
        for j in range(cols):
            if l[i][j] in elements:
                elements[l[i][j]] += 1
            else:
                elements[l[i][j]] = 1
    print(elements)
    print(max(elements, key=elements.get))


def averageValues(l, rows, cols):
    values = {}
    for i in range(rows):
        values[i] = fsum(l[i]) / cols
    print(values)


def sumOfColumns(l, rows, cols):
    values = []
    for i in range(cols):
        suma = 0
        for j in range(rows):
            suma += l[j][i]
        values.append(suma)


def maxAndMinValues(l, rows, cols):
    valueMax = 0
    valueMin = 100
    iMin = 0
    jMin = 0
    iMax = 0
    jMax = 0

    for i in range(rows):
        for j in range(cols):
            temp = l[i][j]
            if temp > valueMax:
                valueMax = temp
                iMax = i
                jMax = j
            if temp < valueMin:
                valueMin = temp
                iMin = i
                jMin = j

    print("Smallest value: " + str(valueMin) + " at coordinates: " + str(iMin) + ", " + str(jMin))
    print("Biggest value: " + str(valueMax) + " at coordinates: " + str(iMax) + ", " + str(jMax))


def filterMatrix(l, rows, cols):
    sumElements = 0
    for i in l:
        sumElements += fsum(i)
    average = sumElements / (rows * cols)
    print(average)
    newList = [[i for i in l[j] if i > average] for j in range(rows)]
    printSquareList(newList)


if __name__ == '__main__':
    m = 10
    n = 10
    lista = [[randint(0, 99) for _ in range(n)] for _ in range(m)]
    printSquareList(lista)
    filterMatrix(lista, m, n)
