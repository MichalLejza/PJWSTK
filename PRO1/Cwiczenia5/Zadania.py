import numpy as np

# Zadanie 1
print("ZADANIE 1: ")
vec = np.array([[1], [2], [3]])
print(vec)
norm = np.linalg.norm(vec)
unitVec = np.divide(vec, norm)
print(unitVec)
print(vec * unitVec)
print()

# Zadanie 2
print("ZADANIE 2: ")
matrix = np.array([[3, 2], [2, 6]])
print(matrix)

eigenvalues, eigenvectors = np.linalg.eig(matrix)
print("Eigenvalues:", eigenvalues)
print("Eigenvectors:")
print(eigenvectors)
print()

# Zadanie 3

# Zadanie 4

# Zadanie 5

print("ZADANIE 5: ")
matrix = np.array([[1, 1], [2, 4], [3, 9], [4, 16]])
matrixT = np.transpose(matrix)
print(matrix, end='\n\n')
print(matrixT, end='\n\n')

first = np.matmul(matrix, matrixT)
second = np.matmul(matrixT, matrix)
print(second.shape)
print(second, end="\n\n")
print(first.shape)
print(first, end="\n\n")

eigenvalues, eigenvectors = np.linalg.eig(first)
print("Eigenvalues:", eigenvalues)
print("Eigenvectors:")
print(eigenvectors)
print()

print()

# Zadanie 6


print("ZADANIE 6: ")
matrix = np.array([[1, 1], [2, 4], [3, 9], [4, 16]])
matrixT = np.transpose(matrix)
print(matrix, end='\n\n')
print(matrixT, end='\n\n')

first = np.matmul(matrix, matrixT)
second = np.matmul(matrixT, matrix)
print(second.shape)
print(second, end="\n\n")
print(first.shape)
print(first, end="\n\n")

print()

# Zadanie 7


# Zadanie 8

print("ZADANIE 8: ")
matrix = np.array([[1, 1, 1], [1, 2, 3], [1, 3, 5]])
print(matrix)
eigenvalues, eigenvectors = np.linalg.eig(matrix)
print("Eigenvalues:", eigenvalues)
print("Eigenvectors:")
print(eigenvectors)
