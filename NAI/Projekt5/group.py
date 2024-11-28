from utility import euclideanDistance


class Group:
    def __init__(self, groupNumber, vectors):
        self._vectors = vectors
        self._groupNumber = groupNumber
        self._centroid = []

    def calculateE(self):
        e = 0
        for vector in self._vectors:
            e += euclideanDistance(self._centroid, vector.getVector())
        return e

    def getGroupNumber(self):
        return self._groupNumber

    def getVector(self):
        return self._vectors

    def getCentroid(self):
        return self._centroid

    def addVector(self, vector):
        vector.setGroupNumber(self._groupNumber)
        self._vectors.append(vector)
        self.calculateCentroid()

    def removeVector(self, vector):
        self._vectors.remove(vector)
        self.calculateCentroid()

    def calculateCentroid(self):
        self._centroid = [0.0 for _ in range(len(self._vectors[0].getVector()))]
        for vector in self._vectors:
            for i in range(len(vector.getVector())):
                self._centroid[i] += vector.getElementAt(i)
        for i in range(len(self._centroid)):
            self._centroid[i] = self._centroid[i] / len(self._vectors)

    def printGroup(self):
        print("Grupa " + str(self._groupNumber) + ": ")
        for i in self._vectors:
            i.printVector()
        print("Centroid: ", end=" ")
        print(self._centroid)
