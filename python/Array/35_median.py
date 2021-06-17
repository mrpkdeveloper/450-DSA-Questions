# question link should be https://www.geeksforgeeks.org/median-of-two-sorted-arrays/

# answer for original link in sheet 
class Solution:
    def find_median(self, v):
        v.sort()
        mid = (len(v))//2
        if len(v)%2!=0:
            return v[mid]
        else:
            return (v[mid] + v[mid-1])//2
        # Code here

#{ 
#  Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    T=int(input())
    for i in range(T):
        n = int(input())
        v = list(map(int,input().split())) 
        ob = Solution();
        ans = ob.find_median(v)
        print(ans)
# } Driver Code Ends