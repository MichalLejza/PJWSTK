from zakupy.exceptions import BelowZero
from zakupy.list_zakupow import ListZakupow
from zakupy.towar import Towar

if __name__ == '__main__':
    lista = [(Towar("Mleko", 4), 2), (Towar("Masło", 3), 2), (Towar("Piwo", 4.5), 5)]
    zakupy = ListZakupow(lista)
    zakupy.obliczCeneSumaryczna()

    while True:
        try:
            nazwa = input("Podaj nazwe produktu: ")
            cena = float(input("Podaj cenę produktu: "))
            if cena < 0:
                raise BelowZero("Cena nie może być ujemna !!!")
            ilosc = int(input("Podaj ilosc: "))
            if ilosc < 0:
                raise BelowZero("Ilosc nie moze być ujemna !!!")
            zakupy.dodajElementDoListy((Towar(nazwa, cena), ilosc))
        except BelowZero as e:
            print(e)
            break
        except ValueError as e:
            print(e)
            break
    zakupy.printLista()
    print(zakupy.sumarycznaCena)
