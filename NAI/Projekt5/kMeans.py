from random import randint
from group import Group
from utility import *


class KMeans:
    def __init__(self, pathName, k):
        self._data = loadData(pathName=pathName)
        self._groupNumber = k
        self._groups = [Group(i, []) for i in range(k)]

    def randomlyAssignVectors(self):
        for row in self._data:
            i = randint(0, self._groupNumber - 1)
            self._groups[i].addVector(row)

    def printGroups(self):
        for group in self._groups:
            group.printGroup()
            print("E: " + str(group.calculateE()), end='\n\n')

    def calculateDistances(self, vector):
        distances = {}
        for group in self._groups:
            distances[group.getGroupNumber()] = euclideanDistance(group.getCentroid(), vector.getVector())
        return min(distances, key=distances.get)

    def printInfo(self, iteration):
        print("\033[92mITERATION: \033[0m" + str(iteration))
        self.printGroups()
        print("E FOR GIVEN ITERATION: ", end=' ')
        print(sum(e.calculateE() for e in self._groups), end='\n\n')

    def trainModel(self):
        iteration = 1
        changes = 1
        self.printInfo(0)
        while changes != 0:
            changes = 0
            for vector in self._data:
                newGroup = self.calculateDistances(vector)
                if vector.getGroupNumber() != newGroup:
                    self._groups[vector.getGroupNumber()].removeVector(vector)
                    self._groups[newGroup].addVector(vector)
                    changes += 1
            self.printInfo(iteration)
            iteration += 1
