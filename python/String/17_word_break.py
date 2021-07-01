#User function Template for python3

def helper(line,dictionary,si,dp):
    #nothing left
    if si == len(line):
        return True
    i=si
    while i<len(line):
        if line[si:i+1] in dictionary:
            if dp[i+1] == None:
                small = helper(line,dictionary,i+1,dp)
                dp[i+1] = small
            else:
                small = dp[i+1]
            
            if small == True:
                return True
            else:
                i+=1
        else :
            i+=1
    return False

def wordBreak(line, dictionary):
    dp = [None for i in range(len(line))]
    dp.append(None) #base case
    dictionary = set(dictionary)
    return helper(line,dictionary,0,dp)
    # Complete this function

#{ 
#  Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	test_case = int(input())

	for _ in range(test_case):
		number_of_elements = int(input())
		dictionary = [word for word in input().strip().split()]
		line = input().strip()
		res = wordBreak(line, dictionary)
		if res:
			print(1)
		else:
			print(0)
# } Driver Code Ends