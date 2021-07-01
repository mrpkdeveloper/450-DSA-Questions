#User function Template for python3

class Solution:
    def permute(self,a, l, r,res):
        if l==r:
            res.append(''.join(a))
        else:
            for i in range(l,r+1):
                a[l], a[i] = a[i], a[l]
                self.permute(a, l+1, r,res)
                a[l], a[i] = a[i], a[l] # backtrack
        
    def find_permutation(self, S):
        # Code here
        si = 0
        # print("dsfsdfsddsfsdf")
        s_list = list(S)
        
        res = []
        self.permute(s_list,0,len(S)-1,res)
        res.sort()
        return res


#{ 
#  Driver Code Starts
#Initial Template for Python 3


if __name__ == '__main__':
	t=int(input())
	for i in range(t):
		S=input()
		ob = Solution()
		ans = ob.find_permutation(S)
		for i in ans:
			print(i,end=" ")
		print()
# } Driver Code Ends