import tkinter as tk
from copy import copy


def normaliseSets(copySet):
    maxElement = 0
    for i in copySet:
        for j in range(len(i) - 1):
            if i[j] > maxElement:
                maxElement = i[j]
    for i in range(len(copySet)):
        for j in range(len(copySet[i]) - 1):
            copySet[i][j] /= maxElement
            copySet[i][j] *= 7


class Display(tk.Frame):
    def __init__(self, master, width, height, flowerSet, flowerClasses):
        super().__init__(master, width=width, height=height)
        self.master = master
        self.canvas = tk.Canvas(self, width=400, height=400)
        self.ovalsList = []
        self.entryOne = tk.Entry()
        self.entryTwo = tk.Entry()
        self.deleteButton = tk.Button(text="delete", command=self.deleteOvals)
        self.button = tk.Button(text="Show", command=self.plotPoints)
        self.flowerSet = flowerSet
        self.width = width
        self.flowerClasses = flowerClasses
        self.height = 400
        self.createFields()
        self.drawaxis()
        self.pack()

    def deleteOvals(self):
        self.canvas.delete("all")
        self.drawaxis()

    def createFields(self):
        self.canvas.pack()
        self.entryOne.pack(side=tk.BOTTOM)
        self.entryTwo.pack(side=tk.BOTTOM)
        self.button.pack(side=tk.BOTTOM)
        self.deleteButton.pack(side=tk.TOP)

    def drawaxis(self):
        # X axis
        self.canvas.create_line(50, self.height - 50, self.width - 50, self.height - 50, arrow=tk.LAST, width=2)
        # Y axis
        self.canvas.create_line(50, self.height - 50, 50, 50, arrow=tk.LAST, width=2)

        # Add labels
        self.canvas.create_text(self.width - 40, self.height - 40, text="X")
        self.canvas.create_text(40, 40, text="Y")
        for i in range(8):
            x = 50 + i * 40
            self.canvas.create_line(x, 345, x, 350, width=2)
            self.canvas.create_text(x, 360, text=str(i))

            # Draw ticks and labels for Y axis
        for i in range(1, 8):
            y = 350 - i * 40
            self.canvas.create_line(50, y, 55, y, width=2)
            self.canvas.create_text(45, y, anchor=tk.E, text=str(i))

    def plotPoints(self):
        copySet = copy(self.flowerSet)
        normaliseSets(copySet)
        if self.entryOne.get() in self.flowerClasses and self.entryTwo.get() in self.flowerClasses:
            first = self.flowerClasses[self.entryOne.get()]
            second = self.flowerClasses[self.entryTwo.get()]
            if second != first:
                for row in copySet:
                    x = row[2]
                    y = row[3]
                    x_coord = 50 + x * 40
                    y_coord = 350 - y * 40
                    if (row[-1] == first or row[-1] == second) and row[-1] == 0:
                        self.canvas.create_oval(x_coord - 4, y_coord - 4, x_coord + 4, y_coord + 4, fill="red")
                    elif (row[-1] == first or row[-1] == second) and row[-1] == 1:
                        self.canvas.create_oval(x_coord - 4, y_coord - 4, x_coord + 4, y_coord + 4, fill="blue")
                    elif (row[-1] == first or row[-1] == second) and row[-1] == 2:
                        self.canvas.create_oval(x_coord - 4, y_coord - 4, x_coord + 4, y_coord + 4, fill="yellow")
