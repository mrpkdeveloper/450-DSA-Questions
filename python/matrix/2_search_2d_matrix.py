class Solution:
    def findRow(self,matrix,target):
        n = len(matrix[0])
        exist = False
        
        for row_index,row in enumerate(matrix):
            
            if target >= row[0] and target<=row[n-1]:
                exist=True
                break    
                
        return exist,row_index
    def searchMatrix(self, matrix, target) :
        size = len(matrix)
        n = len(matrix[0])
        print(n, "n")
        if size == 0:
            print("zero size")
            return False
        if target < matrix[0][0] or target > matrix[size-1][n-1]:
            print("not in matrix")
            return False
        
        exist,row_index = self.findRow(matrix,target)
        if exist == True:
            for i in range(n):
                print(matrix[row_index][i])
                if matrix[row_index][i] == target:
                    return True
        print(row_index)
        return False