#User function Template for python3

class Solution:
    def getPairsCount(self, arr, n, k):
        # code here
        store_freq = dict()
        for n in arr:
            store_freq[n] = store_freq.get(n,0)+1
        count=0
        for n in arr:
            # one element used so reduce frequency by one
            store_freq[n] -= 1
            wanted = k - n
            if wanted in store_freq:
                # count+= (number of pairs with (n,wanted))
                count+=store_freq[wanted]
                
        return count

#{ 
#  Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        n, k = list(map(int, input().strip().split()))
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        ans = ob.getPairsCount(arr, n, k)
        print(ans)
        tc -= 1

# } Driver Code Ends