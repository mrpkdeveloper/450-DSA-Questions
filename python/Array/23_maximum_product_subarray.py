#User function Template for python3
class Solution:

	# Function to find maximum
	# product subarray
    def maxProduct(self,a, n):
        # variation of kaden's algorithm 
        if len(a) ==1:
            return a[0]

        max_prod = a[0]
        curr_max = a[0]
        curr_min = a[0]
        # need to maintain a minimum till curr_element becuase if current element is -ve and min is -ve there product can be maximum

        for i in range(1,n):
            temp = curr_max
            curr_max = max(curr_max*a[i],curr_min*a[i],a[i])
            curr_min = min(temp*a[i],curr_min*a[i],a[i])
            
            if curr_max > max_prod:
                max_prod = curr_max
                
        return max_prod
	        
		# code here

#{ 
#  Driver Code Starts
#Initial Template for Python 3



if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        n = int(input())
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        ans = ob.maxProduct(arr, n)
        print(ans)
        tc -= 1

# } Driver Code Ends