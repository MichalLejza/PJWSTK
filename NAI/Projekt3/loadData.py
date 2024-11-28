import os
from random import shuffle
from cmath import sqrt


def normaliseText(text):
    maxValue = 0
    for values in text:
        maxValue += pow(values, 2)
    for i in range(len(text)):
        text[i] = (text[i] / sqrt(maxValue)).real


def normaliseData(dataSet):
    for file in dataSet:
        maxValue = 0
        for values in file[1]:
            maxValue += pow(values, 2)
        for i in range(len(file[1])):
            file[1][i] = (file[1][i] / sqrt(maxValue)).real


def prepareText(text):
    bufor = [0 for _ in range(26)]
    file = text.lower()
    for char in file:
        if 96 < ord(char) < 123:
            bufor[ord(char) - ord('a')] += 1
    normaliseText(bufor)
    return bufor


def prepareData(filesContent):
    data = []
    for folderName, content in filesContent:
        for file in content:
            bufor = [0 for _ in range(26)]
            file = file.lower()
            for char in file:
                if 96 < ord(char) < 123:
                    bufor[ord(char) - ord('a')] += 1
            data.append([folderName, bufor])
    shuffle(data)
    normaliseData(data)
    return data


def loadData(pathName):
    filesContent = []
    for root, dirs, folders in os.walk(pathName):
        foldersNameAndFiles = []
        for file in folders:
            if file.endswith(".txt"):
                filePath = os.path.join(root, file)
                with open(filePath, "r") as f:
                    fileContent = f.read()
                foldersNameAndFiles.append(fileContent)
        if foldersNameAndFiles:
            folder_name = os.path.relpath(root, pathName)
            filesContent.append([folder_name, foldersNameAndFiles])
    return prepareData(filesContent)
