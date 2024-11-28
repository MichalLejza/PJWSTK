

class Ksiazka:
    def __init__(self, title, author, publishDate, pageCount):
        self.title = title
        self.author = author
        self.publishDate = publishDate
        self.pageCount = pageCount

    def cytowanie(self):
        print("Liczba stron książki: " + self.title + ", " + str(self.pageCount))

    def __len__(self):
        return self.pageCount


class Ebook(Ksiazka):
    def __init__(self, title, author, publishDate, pageCount, epub):
        super().__init__(title, author, publishDate, pageCount)
        self.epub = epub

    def cytowanie(self):
        print("Liczba stron książki: " + self.title + ", " + str(self.pageCount) + " format: " + self.epub)

