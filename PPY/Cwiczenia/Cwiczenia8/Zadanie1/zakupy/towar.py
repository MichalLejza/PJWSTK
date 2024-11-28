class Towar:
    def __init__(self, nazwa, cenaJednostkowa: float):
        self.nazwa = nazwa
        self.cenaJednostkowa = cenaJednostkowa

    def __str__(self):
        return self.nazwa + " cena: " + str(self.cenaJednostkowa)
