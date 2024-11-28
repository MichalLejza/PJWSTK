import re


def loadData(filePath) -> list:
    with open(filePath, 'r') as f:
        content = f.read()
    numbers: list = re.findall(r'\d+', content)
    numbersList: list = [int(num) for num in numbers]
    return numbersList


def createObjects(numbers: list, size: int) -> list[tuple]:
    objects: list[tuple] = [(x, y) for x, y in zip(numbers[:size], numbers[size:])]
    return objects


def printIntegerAsBits(integer: int) -> None:
    bits: list[int] = []
    while integer > 0:
        bits.append(integer % 2)
        integer //= 2
    print(bits)


class KnapSack:
    def __init__(self, dataPath):
        self.numbers = loadData(dataPath)
        self.objectsSize = self.numbers[1]
        self.backPackCapacity = self.numbers[0]
        self.objects = createObjects(numbers=self.numbers[2:], size=self.objectsSize)

    def printKnapsack(self) -> None:
        print("Objects number: ", self.objectsSize)
        print("Knapsack capacity: ", self.backPackCapacity)
        print(self.objects)

    def solveProblem(self) -> None:
        bestSum = 0
        for combination in range(1, 2**self.objectsSize):
            currentSum = 0
            currentWeight = 0
            index = 1
            i = 0
            while index <= combination and currentWeight <= self.backPackCapacity:
                if index & combination != 0:
                    currentSum += self.objects[i][1]
                    currentWeight += self.objects[i][0]
                i += 1
                index = index << 1

            if currentWeight <= self.backPackCapacity and currentSum > bestSum:
                bestCombination = combination
                bestSum = currentSum
                print(str(combination) + " Value:" + str(currentSum) + " Weight: " + str(currentWeight), end=' ')
                printIntegerAsBits(bestCombination)
