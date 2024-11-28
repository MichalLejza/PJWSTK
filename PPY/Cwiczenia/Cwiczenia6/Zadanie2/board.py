from random import randint


class PlanszaTicTacToe:
    def __init__(self, size):
        self.size = size
        self.board = [['' for _ in range(size)] for _ in range(size)]

    def printBoard(self):
        for i in range(self.size):
            for j in range(self.size):
                if self.board[i][j] != '':
                    print(" " + self.board[i][j] + " ", end="")
                else:
                    print("   ", end="")
                if j != len(self.board[i]) - 1:
                    print("|", end="")
            print()
            if i != self.size - 1:
                for _ in range(self.size * 4):
                    print('-', end="")
            print()

    def insert(self, x, y, znak):
        if self.board[x][y] == '':
            self.board[x][y] = znak


class GraTicTacToe:
    def __init__(self, size, znak):
        self.size = size
        self.znak = znak
        self.board = PlanszaTicTacToe(size)

    def getCoordinates(self):
        x = int(input("Podaj wiersz w który chcesz wpisac znak: "))
        while not 0 <= x < self.size:
            x = int(input("Podaj wiersz w który chcesz wpisac znak: "))
        y = int(input("Podaj kolumne w który chcesz wpisas znak: "))
        while not 0 <= y < self.size:
            y = int(input("Podaj kolumne w który chcesz wpisas znak: "))
        return x, y

    def checkIfAnyRowIsEmpty(self):
        counterRows = 0
        for i in range(self.size):
            znakRows = self.board.board[i][0]
            for j in range(self.size):
                if self.board.board[i][j] == znakRows and self.board.board[i][j] != '':
                    counterRows += 1
            if counterRows == self.size:
                return True
            else:
                counterRows = 0
        return False

    def checkIfAnyColumnIsEmpty(self):
        counterColumns = 0
        for i in range(self.size):
            znakColumns = self.board.board[0][i]
            for j in range(self.size):
                if self.board.board[j][i] == znakColumns and self.board.board[j][i] != '':
                    counterColumns += 1
            if counterColumns == self.size:
                return True
            else:
                counterColumns = 0
        return False

    def checkIfAnyCrossIsEmpty(self):
        counterCross = 0
        znakCross = self.board.board[0][0]
        for i in range(self.size):
            if znakCross == self.board.board[i][i] and self.board.board[i][i] != '':
                counterCross += 1
        if counterCross == self.size:
            return True

        znakCross = self.board.board[0][-1]
        for i in range(self.size - 1, 0, -1):
            if znakCross == self.board.board[i][i] and self.board.board[i][i] != '':
                counterCross += 1
        if counterCross == self.size:
            return True
        return False

    def computerMove(self):
        x = randint(0, self.size - 1)
        y = randint(0, self.size - 1)
        while self.board.board[x][y] != '':
            x = randint(0, self.size - 1)
            y = randint(0, self.size - 1)
        znak = 'X' if self.znak == '0' else '0'
        self.board.insert(x, y, znak)

    def checkIfGameEnded(self):
        if self.checkIfAnyRowIsEmpty():
            return True
        if self.checkIfAnyColumnIsEmpty():
            return True
        if self.checkIfAnyCrossIsEmpty():
            return True
        return False

    def play(self):
        while not self.checkIfGameEnded():
            self.board.printBoard()
            x, y = self.getCoordinates()
            while self.board.board[x][y] != '':
                x, y = self.getCoordinates()
            self.board.insert(x, y, self.znak)
            self.computerMove()
        self.board.printBoard()
        print("KONIEC GRY")
