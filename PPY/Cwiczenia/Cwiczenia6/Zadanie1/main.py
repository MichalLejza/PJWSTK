from ksiazka import *


def printKsiazka(ksiazka):
    print(ksiazka.title)
    print(ksiazka.author)
    print(ksiazka.publishDate)
    print(ksiazka.pageCount)
    print()


if __name__ == '__main__':
    ksiazka1 = Ksiazka("Pan Tadeusz", "Adam Mieckiewicz", 1901, 400)
    ksiazka2 = Ksiazka("Krzyżacy", "Henryk Sienkiewicz", 1850, 500)

    printKsiazka(ksiazka1)
    printKsiazka(ksiazka2)

    ksiazka2.title = "Ogniem i mieczem"
    printKsiazka(ksiazka2)

    ebok = Ebook("Balladyna", "Julisz Słowacki", 1839, 350, "UTF-8")
    ebok.cytowanie()

    print(len(ksiazka1))
