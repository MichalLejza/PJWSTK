class ListZakupow:
    def __init__(self, lista: list = None):
        if lista is None:
            lista = [tuple]
        self.lista: list = lista
        self.sumarycznaCena: float = 0

    def obliczCeneSumaryczna(self):
        self.sumarycznaCena = sum(towar.cenaJednostkowa * liczba for towar, liczba in self.lista)

    def dodajElementDoListy(self, towar):
        self.lista.append(towar)
        self.sumarycznaCena = sum(towar.cenaJednostkowa * liczba for towar, liczba in self.lista)

    def printLista(self):
        print()
        for zakup in self.lista:
            print(zakup[0], end=" ilosc: ")
            print(zakup[1])
