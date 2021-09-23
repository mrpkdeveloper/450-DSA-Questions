// Search a 2D Matrix
// Link : https://leetcode.com/problems/search-a-2d-matrix/

// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.

// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true


bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n=matrix.size()-1,m=matrix[0].size()-1;
        int i=0,j=m;
        while(i>=0 and i<=n and j>=0 and j<=m){
            if(matrix[i][j]==target)return true;
            else if(matrix[i][j]>target)j--;
            else i++;
        }
        return false;
    }


//Using binary_search STL
bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        for(auto i : matrix) 
            if(binary_search(i.begin(),i.end(),target))
               return true;
            return false;
    }

//approach using binary search on whole matrix.
bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n=matrix.size();
        int m=matrix[0].size();
        int low=0;
        int high=m*n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(matrix[mid/m][mid%m]==target)
                return true;
            else if(matrix[mid/m][mid%m]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return false;
        
    }
