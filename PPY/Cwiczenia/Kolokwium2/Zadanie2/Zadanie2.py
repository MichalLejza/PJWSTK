class WrongEmailExceptions(Exception):
    def __init__(self, message, wrongEmail):
        self.wrongEmail = wrongEmail
        self.message = message


class Osoba:
    def __init__(self, name, surname):
        self.name = name
        self.surname = surname

    def __lt__(self, other):
        if self.surname == other.surname or self.name != other.name:
            return self.name < other.name
        return self.surname < other.surname

    def __eq__(self, other):
        return self.name == other.name and self.surname == other.surname


class Wypozyczajacy(Osoba):
    def __init__(self, name, surname, ID, email: str):
        super().__init__(name, surname)
        if email.__contains__('@'):
            self.email = email
        else:
            raise WrongEmailExceptions("Your email has to have '@'", email)
        self.ID = ID


class Ksiazka:
    def __init__(self, ID: id, title: str, author: Osoba, year: int):
        self.ID = ID
        self.title = title
        self.author = author
        self.year = year


class Biblioteka:
    def __init__(self):
        self.books: list = []
        self.leders: list = []
        self.currentLenders: dict = {}
        self.IDBook: int = 0
        self.IDLender: int = 0

    def addBook(self, title: str, author: Osoba, year: int):
        book = Ksiazka(self.IDBook, title, author, year)
        self.books.append(book)
        self.IDBook += 1

    def printBooks(self):
        sorted(self.books, key=lambda x: x.author)
        for book in self.books:
            print(book)

    def addLender(self, name: str, surname: str, email: str):
        self.leders.append(Wypozyczajacy(self.IDLender, name, surname, email))
        self.IDLender += 1

    def lendBook(self, osoba: Osoba, book: Ksiazka):
        if osoba in self.leders and book.ID not in self.currentLenders.values():
            self.currentLenders[osoba] = book
    