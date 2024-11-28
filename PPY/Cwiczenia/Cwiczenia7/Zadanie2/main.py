# 2a
def createBoard(n):
    return [['' for _ in range(n)] for _ in range(n)]


# 2b
def getCoordinates(n):
    while True:
        x = input("Enter X coordinate: ")
        y = input("Enter Y coordinate: ")
        try:
            xValue = int(x)
            if xValue >= n or xValue < 0:
                raise OutOfRangeCoordinate
            yValue = int(y)
            if yValue >= n or yValue < 0:
                raise OutOfRangeCoordinate
            return xValue, yValue
        except ValueError:
            print("You entered float number, please try again")
        except OutOfRangeCoordinate as e:
            e.__init__("Coordinates out of range: ", n, )


# 2c
class OutOfRangeCoordinate(Exception):
    def __init__(self, message, n, value):
        super().__init__(message)
        self.value = value
        self.n = n
        print(message + str(n) + " and you put: " + value)


if __name__ == '__main__':
    N = 3
    board = createBoard(n=N)
    X, Y = getCoordinates(n=N)
    print("X: ", X)
    print("Y: ", Y)
