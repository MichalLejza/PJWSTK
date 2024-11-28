from random import randint


def printList(lista):
    for i in lista:
        print(i)
    print()


def generateList(n):
    lista = [[randint(1, 10) for _ in range(n)] for _ in range(n)]
    return lista


def tranposeMatrix(lista):
    lista = [[lista[i][j] for i in range(len(lista))] for j in range(len(lista[0]))]
    return lista


def getDiagonal(m):
    lista = [m[i][i] for i in range(len(m))]
    return lista


if __name__ == '__main__':
    matrix = generateList(5)
    printList(matrix)
    transposed = tranposeMatrix(matrix)
    printList(transposed)
    print(getDiagonal(transposed))
