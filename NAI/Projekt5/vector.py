class Vector:
    def __init__(self, vector, groupNumber):
        self._vector = vector
        self._groupNumber = groupNumber

    def getVector(self):
        return self._vector

    def getElementAt(self, i):
        return self._vector[i]

    def getGroupNumber(self):
        return self._groupNumber

    def setGroupNumber(self, groupNumber):
        self._groupNumber = groupNumber

    def printVector(self):
        print(self._vector, end=' grupa: ')
        print(self._groupNumber)
