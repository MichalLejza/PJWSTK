import random


# 1a
def fileReader(filePath):
    file = open(filePath, 'r')
    lines = file.read().split('\n')
    for line in lines:
        print(line)
    print()
    return lines


# 1b
def fileWriter(lines, filePath):
    with open(filePath, 'w') as file:
        for line in lines:
            if len(line) > 5:
                file.write(line + "\n")


# 1c
def matrixWriter(filePath):
    matrix = [[random.uniform(0, 1) for _ in range(10)] for _ in range(10)]
    with open(filePath, 'w') as file:
        for i in range(len(matrix) - 1):
            for j in range(len(matrix[i]) - 1):
                file.write(str(round(matrix[i][j], 2)) + " ")
            file.write(str(round(matrix[i][-1], 2)) + "\n")

        for i in range(len(matrix[-1]) - 1):
            file.write(str(round(matrix[-1][i], 2)) + " ")
        file.write(str(round(matrix[-1][-1], 2)))


# 1d
def matrixReader(filePath):
    with open(filePath, 'r') as file:
        matrix = file.readline().strip().split(" ")
    numbers = [float(i) for i in matrix]
    print(numbers)


if __name__ == '__main__':
    fileContent = fileReader("test1.txt")
    fileWriter(fileContent, "test2.txt")
    matrixWriter("test3.txt")
    matrixReader("test3.txt")
