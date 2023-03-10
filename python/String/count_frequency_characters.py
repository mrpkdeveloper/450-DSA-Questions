def count_frequency(str1):
    dictionary = {}
    for i in str1:
        keys = dictionary.keys()
        if i in keys:
            dictionary[i] += 1
        else:
            dictionary[i] = 1

    print("The frequency of the elements in given string:")
    print(dictionary)


if __name__ == '__main__':
    string = input("Enter a string: ")
    count_frequency(string)
