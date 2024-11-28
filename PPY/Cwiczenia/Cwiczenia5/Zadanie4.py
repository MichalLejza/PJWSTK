from math import sqrt


def isNumberPrime(number):
    if number <= 1:
        return False
    for i in range(2, int(sqrt(number)) + 1):
        if number % i == 0:
            return False
    return True


def generatorNPrimeNumbers(number):
    count = 0
    numberToCheck = 2
    while count < number:
        if isNumberPrime(numberToCheck):
            yield numberToCheck
            count += 1
        numberToCheck += 1


if __name__ == '__main__':
    n = 10
    primeGenerator = generatorNPrimeNumbers(n)
    print(f"The first {n} prime numbers are: ")
    for prime in primeGenerator:
        print(prime, end=', ')
