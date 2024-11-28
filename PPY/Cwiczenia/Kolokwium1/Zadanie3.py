from random import randint

if __name__ == '__main__':
    lista = [[randint(0, 10) for _ in range(5)] for _ in range(5)]
    tupla = (
        *lista[0],
        *[lista[i][-1] for i in range(1, len(lista) - 1, -1)],
        *[lista[-1][i] for i in range(len(lista) - 1, 0, -1)],
        *[lista[i][0] for i in range(len(lista) - 1, 1, -1)]
    )

    for i in lista:
        print(i)

    for i in tupla:
        print(i)