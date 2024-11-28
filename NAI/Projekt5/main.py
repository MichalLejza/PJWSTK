from kMeans import KMeans


if __name__ == '__main__':
    k = KMeans("Data/test.csv", 5)
    k.randomlyAssignVectors()
    k.trainModel()
