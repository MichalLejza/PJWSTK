import os
import struct
import time

import matplotlib.pyplot as plt
import numpy as np
import xgboost as xgb
from scipy.ndimage import shift
from sklearn.ensemble import RandomForestClassifier, ExtraTreesClassifier
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report
from sklearn.tree import DecisionTreeClassifier, plot_tree, export_text

data_dir = '/Users/michallejza/Desktop/Data/MNIST/classic'
train_images_path = os.path.join(data_dir, 'train-images')
train_labels_path = os.path.join(data_dir, 'train-labels')
test_images_path = os.path.join(data_dir, 'test-images')
test_labels_path = os.path.join(data_dir, 'test-labels')


class DataHandler:
    def __init__(self, imagesPath, labelsPath):
        self.images = self.loadImages(imagesPath)
        self.labels = self.loadLabels(labelsPath)

    def showClassDistribution(self):
        labelList, labelCount = np.unique(self.labels, return_counts=True)
        plt.figure(figsize=(10, 6))
        bars = plt.bar(labelList, labelCount, color='blue')
        plt.xticks(range(10))
        plt.xlabel('Labels')
        plt.ylabel('Count')
        plt.title('Distribution of Labels')
        plt.grid(axis='y')
        for bar in bars:
            yval = bar.get_height()
            plt.text(bar.get_x() + bar.get_width() / 2, yval, str(yval), ha='center', va='bottom', fontsize=10)
        plt.show()

    def showClassPercentageDistribution(self):
        labelList, labelCount = np.unique(self.labels, return_counts=True)
        labelPercentage = labelCount / len(self.labels) * 100
        plt.figure(figsize=(10, 6))
        bars = plt.bar(labelList, labelPercentage, color='blue')
        plt.xticks(range(10))
        plt.xlabel('Labels')
        plt.ylabel('Count')
        plt.title('Percentage Distribution of Labels')
        plt.grid(axis='y')
        for bar in bars:
            yval = float(format(bar.get_height(), '.2f'))
            plt.text(bar.get_x() + bar.get_width() / 2, yval, str(yval), ha='center', va='bottom', fontsize=10)
        plt.show()

    @staticmethod
    def loadImages(file_path):
        with open(file_path, 'rb') as f:
            _, num_images, rows, cols = struct.unpack(">IIII", f.read(16))
            images = np.fromfile(f, dtype=np.uint8).reshape(num_images, rows * cols)
        return images

    @staticmethod
    def loadLabels(file_path):
        with open(file_path, 'rb') as f:
            _, num_labels = struct.unpack(">II", f.read(8))
            labels = np.fromfile(f, dtype=np.uint8)
        return labels

    def modifyDataset(self):
        images = []
        labels = []
        for i in range(len(self.images)):
            image = self.images[i].reshape(28, 28)
            images.append(self.images[i])
            labels.append(self.labels[i])
            images.append(np.roll(image, -3, axis=0).flatten())
            labels.append(self.labels[i])
            images.append(np.roll(image, 3, axis=0).flatten())
            labels.append(self.labels[i])
            images.append(np.roll(image, -3, axis=1).flatten())
            labels.append(self.labels[i])
            images.append(np.roll(image, 3, axis=1).flatten())
            labels.append(self.labels[i])
        self.images = np.array(images)
        self.labels = np.array(labels)

    def showFirstEightImages(self):
        number = 8
        plt.figure(figsize=(10, 5))
        for i in range(number):
            plt.subplot(2, 4, i + 1)
            plt.imshow(self.images[i].reshape(28, 28), interpolation="nearest", cmap="Greys")
            plt.title(f"Label: {self.labels[i]}")
            plt.axis('off')

        plt.tight_layout()
        plt.show()

    def showImage(self, index: int):
        plt.figure(figsize=(8, 8))
        plt.imshow(self.images[index].reshape(28, 28), interpolation="nearest", cmap="Greys")
        plt.title(f"Label: {self.labels[index]}")
        plt.axis('off')
        plt.show()

    def showShiftedImages(self, index: int):
        image = self.images[index].reshape(28, 28)
        shiftedDown = shift(image, [5, 0], cval=0, mode="constant")
        shiftedLeft = shift(image, [0, -5], cval=0, mode="constant")
        plt.figure(figsize=(12, 3))
        plt.subplot(131)
        plt.title("Original", fontsize=14)
        plt.imshow(image.reshape(28, 28), interpolation="nearest", cmap="Greys")
        plt.subplot(132)
        plt.title("Shifted Down", fontsize=14)
        plt.imshow(shiftedDown.reshape(28, 28), interpolation="nearest", cmap="Greys")
        plt.subplot(133)
        plt.title("Shifted Left", fontsize=14)
        plt.imshow(shiftedLeft.reshape(28, 28), interpolation="nearest", cmap="Greys")
        plt.show()


class DecisionTree:
    def __init__(self, trainData=None, testData=None):
        self.trainData = trainData
        self.testData = testData
        self.classifier = DecisionTreeClassifier(max_depth=10, criterion='gini')
        print("Train images dimensions", self.trainData.images.shape)
        print("Train labels size", self.trainData.labels.shape)
        print("Test images dimensions", self.testData.images.shape)
        print("Train labels size", self.testData.labels.shape)

    def classify(self):
        trainImages = self.trainData.images
        trainLabels = self.trainData.labels
        self.classifier.fit(trainImages, trainLabels)

        testImages = self.testData.images
        testLabels = self.testData.labels
        prediction = self.classifier.predict(testImages)

        accuracy = accuracy_score(testLabels, prediction)
        print(f"Decision Tree Accuracy: {accuracy:.4f}")

        confusionMatrix = confusion_matrix(testLabels, prediction)
        print(f"Confusion Matrix: \n{confusionMatrix}")
        print()
        return accuracy

    def displayTree(self, max_depth=1):
        plt.figure(figsize=(12, 8))
        plot_tree(self.classifier, max_depth=max_depth, filled=True, feature_names=[f'pixel_{i}' for i in range(784)],
                  class_names=[str(i) for i in range(10)], rounded=True)
        plt.title("Decision Tree Classifier (max_depth=2)")
        plt.show()

    def showImportantAtributes(self):
        importances = self.classifier.feature_importances_
        top_5_indices = np.argsort(importances)[-5:][::-1]
        top_5_importances = importances[top_5_indices]
        plt.figure(figsize=(10, 6))
        plt.bar(range(5), top_5_importances, tick_label=[f'Pixel {i}' for i in top_5_indices], color='orange')
        plt.xlabel('Pixel Index', fontsize=12)
        plt.ylabel('Importance Score', fontsize=12)
        plt.title('Top 5 Most Important Pixels', fontsize=14)
        plt.grid(axis='y', linestyle='--', alpha=0.7)
        plt.show()

    def displayTreeText(self, max_depth=2):
        feature_names = [f'pixel_{i}' for i in range(784)]
        r = export_text(self.classifier, feature_names=feature_names, max_depth=max_depth)
        print(r)


class RandomForest:
    def __init__(self, trainData=None, testData=None):
        self.trainData = trainData
        self.testData = testData
        self.classifier = RandomForestClassifier(n_estimators=20, criterion='gini')

    def classify(self):
        trainImages = self.trainData.images
        trainLabels = self.trainData.labels
        self.classifier.fit(trainImages, trainLabels)

        testImages = self.testData.images
        testLabels = self.testData.labels
        prediction = self.classifier.predict(testImages)

        accuracy = accuracy_score(testLabels, prediction)
        print(f"Random Forest Accuracy: {accuracy:.4f}")
        print(classification_report(testLabels, prediction))
        return accuracy


class ExtraTrees:
    def __init__(self, trainData=None, testData=None):
        self.trainData = trainData
        self.testData = testData
        self.classifier = ExtraTreesClassifier(n_estimators=20, criterion='gini')

    def classify(self):
        trainImages = self.trainData.images
        trainLabels = self.trainData.labels
        self.classifier.fit(trainImages, trainLabels)

        testImages = self.testData.images
        testLabels = self.testData.labels
        prediction = self.classifier.predict(testImages)

        accuracy = accuracy_score(testLabels, prediction)
        print(f"Extra Trees Accuracy: {accuracy:.4f}")
        print(classification_report(testLabels, prediction))
        return accuracy


class XGBBoost:
    def __init__(self, trainData=None, testData=None):
        self.trainData = trainData
        self.testData = testData
        self.classifier = xgb.XGBClassifier(n_estimators=20, criterion='gini')

    def classify(self):
        trainImages = self.trainData.images
        trainLabels = self.trainData.labels
        self.classifier.fit(trainImages, trainLabels)

        testImages = self.testData.images
        testLabels = self.testData.labels
        prediction = self.classifier.predict(testImages)

        accuracy = accuracy_score(testLabels, prediction)
        print(f"XGBBosst Accuracy: {accuracy:.4f}")
        print(classification_report(testLabels, prediction))
        return accuracy


def showClassifiersAccuracy(accuracies: list, names: list):
    plt.figure(figsize=(10, 10))
    bars = plt.bar(names, accuracies, color='blue')
    plt.xlabel('Classfier')
    plt.ylabel('Accuracy')
    plt.title('Accuracies of Classifiers')
    plt.grid(axis='y')
    for bar in bars:
        yval = bar.get_height()
        plt.text(bar.get_x() + bar.get_width() / 2, yval, str(yval), ha='center', va='bottom', fontsize=10)
    plt.show()


def normalClassifiers(trainData, testData):
    dt = DecisionTree(trainData=trainData, testData=testData)
    dtA = dt.classify()
    dt.showImportantAtributes()
    dt.displayTree()
    dt.displayTreeText()

    rf = RandomForest(trainData=trainData, testData=testData)
    rfA = rf.classify()

    et = ExtraTrees(trainData=trainData, testData=testData)
    etA = et.classify()

    xgb = XGBBoost(trainData=trainData, testData=testData)
    xgbA = xgb.classify()

    showClassifiersAccuracy([dtA, rfA, etA, xgbA], ["Decision Tree", "Random Forest", "Extra Tree",
                                                    "XGBoost"])


def shiftedClassifiers(trainData, testData):
    dt = DecisionTree(trainData=trainData, testData=testData)
    dtA = dt.classify()

    rf = RandomForest(trainData=trainData, testData=testData)
    rfA = rf.classify()

    et = ExtraTrees(trainData=trainData, testData=testData)
    etA = et.classify()

    xgb = XGBBoost(trainData=trainData, testData=testData)
    xgbA = xgb.classify()

    showClassifiersAccuracy([dtA, rfA, etA, xgbA], ["Decision Tree", "Random Forest", "Extra Tree",
                                                    "XGBoost"])


if __name__ == '__main__':
    train = DataHandler(train_images_path, train_labels_path)
    test = DataHandler(test_images_path, test_labels_path)
    trainModified = DataHandler(train_images_path, train_labels_path)
    trainModified.modifyDataset()

    train.showClassDistribution()
    train.showClassPercentageDistribution()
    train.showFirstEightImages()
    train.showShiftedImages(index=0)

    trainModified.showFirstEightImages()

    normalClassifiers(train, test)

    start_time = time.time()
    shiftedClassifiers(trainModified, test)
    end_time = time.time()
    elapsed_time = end_time - start_time
    print(f"Training classifiers took: {elapsed_time:.2f} seconds to complete.")
