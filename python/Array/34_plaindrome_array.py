# Your task is to complete this function
# Function should return True/False or 1/0
def isPalindrome(string):
    string = str(string)
    left = 0
    right = len(string)-1
    while left<right:
        if string[left]!=string[right]:
            return False
        left+=1
        right-=1
    return True
def PalinArray(arr ,n):
    for string in arr:
        if not isPalindrome(string):
            return 0
    return 1
    # Code here


#{ 
#  Driver Code Starts
# Driver Program
if __name__=='__main__':
    t=int(input())
    for i in range(t):
        n = int(input())
        arr = list(map(int, input().strip().split()))
        if PalinArray(arr, n):
            print(1)
        else:
            print(0)
# Contributed By: Harshit Sidhwa

# } Driver Code Ends