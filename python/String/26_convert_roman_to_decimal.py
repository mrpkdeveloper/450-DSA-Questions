#User function Template for python3



def romanToDecimal(str):
    # 
    code = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
    decimal = 0
    prev = None
    for ch in str:
        if prev == None:
            decimal += code[ch]
        else:
            if code[ch] <= prev:
                decimal+=code[ch]
            else:
                decimal += -1*prev + (code[ch]-prev) #substracting wrong addition then adding correct number
        prev = code[ch]
    return decimal
#{ 
#  Driver Code Starts
#Initial Template for Python 3




if __name__=='__main__':
    t = int(input())
    for _ in range(t):
        print(romanToDecimal(str(input())))
# } Driver Code Ends