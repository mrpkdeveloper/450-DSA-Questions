class Solution:
    def sb(self, arr, n, x):
        # Your code goes here 
        # sliding window approach 
        # find and shrink window 
        
        left = 0
        right = 0
        sum_n = arr[0]
        while sum_n <= x:
            right+=1
            sum_n += arr[right]
        
        result = right-left+1
        
        while right<n and left<n:
            # print(left,right)
            # shrink to minimum possible length
            while sum_n > x:
                sum_n -= arr[left]
                left+=1
                if left>=n:
                    break
            
            curr_answer = right - (left-1) + 1 #left-1 because we need to include left-1 index as at this position sum_n<=x
            result = min(result,curr_answer)
            
            while sum_n <= x:
                right+=1
                if right>=n:
                    break
                sum_n+=arr[right]
        return result
#{ 
#  Driver Code Starts
def main():

    T = int(input())

    while(T > 0):
        sz = [int(x) for x in input().strip().split()]
        n, m = sz[0], sz[1]
        a = [int(x) for x in input().strip().split()]
        print(Solution().sb(a, n, m))

        T -= 1


if __name__ == "__main__":
    main()

# } Driver Code Ends