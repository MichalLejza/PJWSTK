
def piramid(n):
    piramida = [[i for i in range(1, j)] for j in range(2, n + 2)]
    for i in piramida:
        print(i)


if __name__ == '__main__':
    piramid(2)
