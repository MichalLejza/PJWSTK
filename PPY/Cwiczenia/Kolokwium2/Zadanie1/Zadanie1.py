import numbers


# . (10 pkt.) Zaimplementuj klasę Data, która będzie zawierała pola dzień, miesiąc, rok.
# a. Zaimplementuj funkcjonalność wymaganą do sortowania chronologicznie
# (funkcje __lt__ i __eq__).
# b. Zaimplementuj obsługę nieprawidłowych zakresów danych przekazanych do
# __init__ (w przypadku nieprawidłowych danych powinien być podnoszony
# wyjątek z informacją o wprowadzonych danych i prawidłowym zakresie)
# 2. (2 pkt.) Zdefiniuj klasę notatka. Każda notatka ma id, datę i tekst.
# 3. (10 pkt.) Napisz klasę Terminarz, która będzie przechowywała notatki. Dodaj do
# terminarza możliwość dodawania notatek, usuwania notatek i wyświetlania
# wszystkich notatek posortowanych po dacie. Do funkcji dodającej notatkę
# przekazywana jest data i tekst notatki, id jest nadawane automatycznie jako pierwsza
# wolna liczba naturalna.
# a. Dodaj funkcję zapisującą zawartość terminarza do pliku tekstowego w
# formacie: id dd-mm-rrrr tekst notatki (każda notatka w nowej linii).
# 4. (3 pkt.) Utwórz terminarz, dodaj kilka notatek z przykładowymi danymi. Dodaj
# notatkę z danym wczytanymi od użytkownika (obsłuż wyjątki). Wyświetl notatki w
# kolejności chronologicznej.


class WrondData(Exception):
    def __init__(self, message, value, correctValues):
        print("Wrong data: " + str(value) + " should be " + str(correctValues))
        self.message = message


class Data:
    def __init__(self, day, month, year):
        self.day = day
        self.month = month
        self.year = year

    def __lt__(self, other) -> bool:
        if (self.year == other.year) and (self.month == other.month):
            return self.day < other.day
        if self.year == other.year:
            return self.month < other.month
        return self.year < other.year

    def __eq__(self, other) -> bool:
        return self.day == other.day and self.month == other.month and self.year == other.year


class Notatka:
    def __init__(self, ID, date, text):
        self.ID = ID
        self.date = date
        self.text = text


class Terminarz:
    def __init__(self):
        self.notatki = list()
        self.counter = 1

    def addNote(self, date, note) -> None:
        self.notatki.append(Notatka(note, date, self.counter))
        self.counter += 1

    def deleteNote(self, ID) -> None:
        note = None
        for n in self.notatki:
            if n.ID == ID:
                note = n
        self.notatki.remove(note)

    def saveToFile(self, filaPath) -> None:
        with open(filaPath, "w") as f:
            for note in self.notatki:
                f.write(note.ID + " " + note.date + " " + note.text + "\n")
