
#User function Template for python3

class Solution:
    
    #Function to check whether there is a subarray present with 0-sum or not.

    # store sum found at each index and if same sum comes again for another index i.e there was a subarray with sum = 0
    def subArrayExists(self,arr,n):
        sum_exists = set()
        sum_exists.add(0) #if some of whole array == 0
        sum_n =0 
        for n in (arr):
            sum_n+=n
            if sum_n in sum_exists:
                return True
            else:
                sum_exists.add(sum_n)    
        return False

#{ 
#  Driver Code Starts
#Initial Template for Python 3



def main():
    T=int(input())
    while(T>0):
        
        n=int(input())
        arr=[int(x) for x in input().strip().split()]
        if(Solution().subArrayExists(arr,n)):
            print("Yes")
        else:
            print("No")
        
        
        T-=1

if __name__=="__main__":
    main()
# } Driver Code Ends