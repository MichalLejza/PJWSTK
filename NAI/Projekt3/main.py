from singleLayer import SingleLayerNetwork
from ui import UserInterFace

if __name__ == '__main__':
    slp = SingleLayerNetwork("data", "train", 0.05)
    slp.train()
    ui = UserInterFace(slp)
    ui.printModelPrecision()
    ui.calculateAccuracy()
    ui.userInput()
