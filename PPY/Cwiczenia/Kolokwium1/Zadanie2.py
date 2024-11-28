from random import randint


def getMandNValues():
    m = int(input("Podaj liczbę m: "))
    while m % 2 == 0 or m <= 5:
        print("Zła wartość m")
        m = int(input("Podaj jeszcze raz liczbę m: "))
    n = int(input("Podaj liczbę n: "))
    while n > 15 or n % 2 == 1:
        print("Zła wartość n")
        n = int(input("Podaj jeszcze raz liczbę n: "))
    return m, n


def createLists():
    m, n = getMandNValues()
    L1 = [randint(1, n) for _ in range(n)]
    L2 = [randint(1, m) for _ in range(m)]
    return L1, L2


def createDictionaries():
    L1, L2 = createLists()
    S1 = {}
    S2 = {}
    for i in L1:
        if i in S1:
            S1[i] += 1
        else:
            S1[i] = 1
    for i in L2:
        if i in S2:
            S2[i] += 1
        else:
            S2[i] = 1
    return S1, S2


def createUniqueueLists():
    S1, S2 = createDictionaries()
    print(S1)
    print(S2)
    F1 = [key for key in S1.keys() if S1[key] % 2 == 1]
    F2 = [key for key in S2.keys() if S2[key] % 3 == 2]
    print(F1)
    print(F2)


if __name__ == '__main__':
    createUniqueueLists()
