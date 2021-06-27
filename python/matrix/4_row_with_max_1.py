class Solution:

    def rowWithMax1s(self,arr, n, m):
        leftmost_1 = m-1
        return_row = -1
        for i in range(m-1, -1, -1):
            if arr[0][i] == 0:
                break
            return_row = 0
            leftmost_1 = i

        # check for remaining rows if there is any 1 on left of this one
        for i in range(1, n):
            # print(return_row, leftmost_1, arr[i][leftmost_1])
            if (return_row == -1 and arr[i][leftmost_1] == 1) or (leftmost_1-1 >= 0 and arr[i][leftmost_1-1] == 1):
                # print(return_row, leftmost_1, arr[i][leftmost_1])
                for j in range(leftmost_1, -1, -1):
                    # print(i, j)
                    if arr[i][j] == 0:
                        break
                    # if j != leftmost_1 or return_row != -1:
                    return_row = i
                    leftmost_1 = j
        return return_row
        # code here

#{ 
#  Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        n, m = list(map(int, input().strip().split()))
        
        inputLine = list(map(int, input().strip().split()))
        arr = [[0 for j in range(m)] for i in range(n)]
        
        for i in range(n):
            for j in range(m):
                arr[i][j] = inputLine[i * m + j]
        ob = Solution()
        ans = ob.rowWithMax1s(arr, n, m)
        print(ans)
        tc -= 1

# } Driver Code Ends