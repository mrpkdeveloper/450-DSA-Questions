class Solution:
    #User function Template for python3
    def merge(self,arr1,arr2,counter):
        if len(arr1) == 0:
            return arr2
        if len(arr2) == 0:
            return arr1
            
        i = 0 
        j = 0
        sorted_arr = []
    
        while i<len(arr1) and j<len(arr2):
            if arr1[i] <= arr2[j]:
                sorted_arr.append(arr1[i])
                i+=1
            else:
                counter[0]+=len(arr1)-i
                sorted_arr.append(arr2[j])
                j+=1
        
        while i<len(arr1):
            # counter[0]+=1
            sorted_arr.append(arr1[i])
            i+=1
            
        while j<len(arr2):
            sorted_arr.append(arr2[j])
            j+=1
            
        return sorted_arr
    
    def mergeSort(self,arr,counter):
        if len(arr) == 1:
            return arr
        mid = (len(arr)+1)//2
        small1 = self.mergeSort(arr[:mid],counter)
        small2 = self.mergeSort(arr[mid:],counter)
        

        return (self.merge(small1,small2,counter))
    # arr[]: Input Array
    # N : Size of the Array arr[]
    #Function to count inversions in the array.
    def inversionCount(self, arr, n):
        counter = [0]
        # print()
        self.mergeSort(arr,counter)
        return counter[0]
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

if __name__=='__main__':
    t = int(input())
    for tt in range(t):
        n = int(input())
        a = list(map(int, input().strip().split()))
        obj = Solution()
        print(obj.inversionCount(a,n))
# } Driver Code Ends