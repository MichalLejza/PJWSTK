def onlyVowels(napis):
    napis = napis.lower()
    vowels = {'a', 'e', 'i', 'o', 'u', 'y'}
    vowelsOnly = set(char for char in napis if char in vowels)
    listOfVowels = [char for char in vowelsOnly]
    return listOfVowels


if __name__ == '__main__':
    print(onlyVowels("Witam Nazywam sie"))
