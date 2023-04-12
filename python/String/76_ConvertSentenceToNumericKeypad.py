# How to convert a sentence into its equivalent mobile numeric keypad sequence


def printSequence(arr, input):

    # length of input string
    n = len(input)
    output = ""

    for i in range(n):

        # checking for space
        if(input[i] == ' '):
            output = output + "0"
        else:
            # calculating index for each character
            position = ord(input[i]) - ord('A')
            output = output + arr[position]
    # output sequence
    return output


keypad= ["2", "22", "222",
       "3", "33", "333",
       "4", "44", "444",
       "5", "55", "555",
       "6", "66", "666",
       "7", "77", "777", "7777",
       "8", "88", "888",
       "9", "99", "999", "9999"]

input = "DEVANG"
print(printSequence(keypad, input))

