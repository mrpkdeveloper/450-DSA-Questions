#User function Template for python3


class Solution:
    
    #Function to find largest rectangular area possible in a given histogram.
    def getMaxHistogramArea(self,row):
        stack = [0]
        row.append(0)
        
        res = 0
        for right in range(1,len(row)):
            while stack and row[stack[-1]] > row[right]:
                h = row[stack.pop()]
                left = -1 if not stack else stack[-1] # because pop operation, left = stack.pop() is not the left boundary
                w = right - left -1
                res = max(res,h*w)
            stack.append(right)
        return res

    def maxArea(self,M, n, m):
        # create a 2d array representing histogram row_wise
        row_wise_histogram = [[]]        
        for cell in M[0]:
            row_wise_histogram[0].append(int(cell))

        i=1
        while i < len(M):
            new_histogram_row = []

            j=0
            while j < len(M[0]):
                if int(M[i][j]) != 0: # if base is 0 height of histogram will be 0
                    new_histogram_row.append(int(M[i][j])+row_wise_histogram[i-1][j])
                else:
                    new_histogram_row.append(0)
                j+=1
            row_wise_histogram.append(new_histogram_row)
            i+=1
        max_area = 0
        # print(row_wise_histogram)
        for row in row_wise_histogram:
            max_area = max(max_area,self.getMaxHistogramArea(row))
        return max_area
        #code here

#{ 
#  Driver Code Starts
#Initial Template for Python 3

# by Jinay Shah 

if __name__ == '__main__':
    # t=int(input())
    t=1
    for _ in range(t):
        R,C = map(int, "4 5".strip().split())
        # A = []
        # for i in range(R):
        #     line = [int(x) for x in input().strip().split()]
        #     A.append(line)
        A = [["0","0","1"],["1","1","1"]]
        # print(A)
        print(Solution().maxArea(A, R, C)) 
# } Driver Code Ends