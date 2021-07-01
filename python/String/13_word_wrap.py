#User function Template for python3

class Solution:
    def helper(self,nums,si,k,dp):
        if si == len(nums)-1:
            extra = 0
            return extra
        if si == len(nums):
            return 0

        char_used = 0
        i = si
        min_cost = 10**8

        while i < len(nums) and ((char_used==0 and nums[i] <= k) or (char_used!=0 and char_used+nums[i]+(i-si+1-1) <= k)):
    
            if i != len(nums)-1: 
                char_used = char_used+nums[i]
                row_cost = (k - char_used - (i - si + 1 -1))**2  #number of words -1
                    
                if dp[i+1] == None:
                    small_cost = self.helper(nums,i+1,k,dp)
                    dp[i+1] = small_cost
                else:
                    small_cost = dp[i+1]

                total_cost = row_cost + small_cost
            else: #if it is last element => it is last row so total cost of this and below this will be 0
                total_cost = 0
                
            if total_cost < min_cost:
                min_cost = total_cost
            i+=1
        
        return min_cost
        
        
    def solveWordWrap(self, nums, k):
        #Code here
        dp = [None for i in range(len(nums))]
        return self.helper(nums,0,k,dp)
		

#{ 
#  Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		n = int(input())
		nums = list(map(int, input().split()))
		k = int(input())
		obj = Solution()
		ans = obj.solveWordWrap(nums, k)
		print(ans)

# } Driver Code Ends