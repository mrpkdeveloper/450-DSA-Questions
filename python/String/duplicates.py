# Python program to count all
# duplicates from string using hashing
NO_OF_CHARS = 256
 
# Fills count array with
# frequency of characters
def fillCharCounts(string, count):
    for i in string:
        count[ord(i)] += 1
    return count
 
# Print duplicates present
# in the passed string
def printDups(string):
     
    # Create an array of size 256
    # and fill count of every character in it
    count = [0] * NO_OF_CHARS
    count = fillCharCounts(string,count)
 
    # Utility Variable
    k = 0
 
    # Print characters having
    # count more than 0
    for i in count:
        if int(i) > 1:
            print(chr(k) + ", count = " + str(i))
        k += 1
 
# Driver program to test the above function
string = "test string"
print(printDups(string))