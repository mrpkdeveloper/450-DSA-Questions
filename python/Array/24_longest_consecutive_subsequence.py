 #User function Template for python3
 
class Solution:
    
    # arr[] : the input array
    # N : size of the array arr[]
    
    #Function to return length of longest subsequence of consecutive integers.
    def findLongestConseqSubseq(self,arr, N):
        #code here
        
        is_visited = {n:0 for n in arr}
        max_len = 0
        
        for n in arr:
            curr_len = 1
            curr = n
            if is_visited[n] == 0:
                # count consecutive numbers > and < n 
                # if curr_len > max_len update max_len

                # check len of consecutive numbers greater than n
                while True:
                    if curr+1 in is_visited:
                        is_visited[curr+1] = 1
                        curr_len+=1
                        curr = curr+1
                    else:
                        break
                    
                # check len of consecutive numbers less than n
                curr = n
                while True:
                    if curr-1 in is_visited:
                        is_visited[curr-1] = 1
                        curr_len += 1 
                        curr = curr-1
                    else:
                        break
                
                is_visited[n] = 1
                if curr_len > max_len:
                    max_len = curr_len
        # print(store_len)
        return max_len
#{ 
#  Driver Code Starts
#Initial Template for Python 3

import atexit
import io
import sys

_INPUT_LINES = sys.stdin.read().splitlines()
input = iter(_INPUT_LINES).__next__
_OUTPUT_BUFFER = io.StringIO()
sys.stdout = _OUTPUT_BUFFER

@atexit.register

def write():
    sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())

if __name__ == '__main__':
    t = int(input())
    for tt in range(t):
        n=int(input())
        a = list(map(int, input().strip().split()))
        print(Solution().findLongestConseqSubseq(a,n))
# } Driver Code Ends