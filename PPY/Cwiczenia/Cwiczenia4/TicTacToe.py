from random import randint


def printTable(plansza, size):
    for i in range(len(plansza)):
        for j in range(len(plansza[i])):
            if plansza[i][j] != '0':
                print(" " + plansza[i][j] + " ", end="")
            else:
                print("   ", end="")
            if j != len(plansza[i]) - 1:
                print("|", end="")
        print()
        if i != len(plansza) - 1:
            for _ in range(size * 4):
                print('-', end="")
        print()


def writeASymbolToTable(plansza, x, y, znak):
    if plansza[x][y] == '0':
        plansza[x][y] = znak


def getCoordinates(size):
    x = int(input("Podaj wiersz w który chcesz wpisac znak: "))
    while not 0 <= x < size:
        x = int(input("Podaj wiersz w który chcesz wpisac znak: "))
    y = int(input("Podaj kolumne w który chcesz wpisas znak: "))
    while not 0 <= y < size:
        y = int(input("Podaj kolumne w który chcesz wpisas znak: "))
    return x, y


def checkIfAnyRowIsEmpty(plansza):
    counterRows = 0
    for i in range(len(plansza)):
        znakRows = plansza[i][0]
        for j in range(len(plansza[i])):
            if plansza[i][j] == znakRows and plansza[i][j] != '0':
                counterRows += 1
        if counterRows == len(plansza[i]):
            return True
        else:
            counterRows = 0
    return False


def checkIfAnyColumnIsEmpty(plansza):
    counterColumns = 0
    for i in range(len(plansza[0])):
        znakColumns = plansza[0][i]
        for j in range(len(plansza)):
            if plansza[j][i] == znakColumns and plansza[j][i] != '0':
                counterColumns += 1
        if counterColumns == len(plansza):
            return True
        else:
            counterColumns = 0
    return False


def checkIfAnyCrossIsEmpty(plansza):
    counterCross = 0
    znakCross = plansza[0][0]
    for i in range(len(plansza)):
        if znakCross == plansza[i][i] and plansza[i][i] != '0':
            counterCross += 1
    if counterCross == len(plansza):
        return True

    znakCross = plansza[0][-1]
    for i in range(len(plansza) - 1, 0, -1):
        if znakCross == plansza[i][i] and plansza[i][i] != '0':
            counterCross += 1
    if counterCross == len(plansza):
        return True
    return False


def computerMove(plansza, size, znak):
    x = randint(0, size - 1)
    y = randint(0, size - 1)
    while plansza[x][y] != '0':
        x = randint(0, size - 1)
        y = randint(0, size - 1)
    plansza[x][y] = znak


def checkIfGameEnded(plansza):
    if checkIfAnyRowIsEmpty(plansza):
        return True
    if checkIfAnyColumnIsEmpty(plansza):
        return True
    if checkIfAnyCrossIsEmpty(plansza):
        return True
    return False


if __name__ == '__main__':
    N = 3
    table = []
    for i in range(N):
        row = []
        for j in range(N):
            row.append('0')
        table.append(row)

    while not checkIfGameEnded(plansza=table):
        printTable(table, N)
        x, y = getCoordinates(N)
        while table[x][y] != '0':
            x, y = getCoordinates(N)
        writeASymbolToTable(plansza=table, x=x, y=y, znak='X')
        computerMove(plansza=table, size=N, znak='O')
    printTable(plansza=table, size=N)
