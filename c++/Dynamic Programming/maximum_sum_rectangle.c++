// Maximum sum Rectangle
// https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1

class Solution
{
public:
    long long int kadane(vector<long long int> temp, int r)
    {
        long long int maxSum = INT_MIN, currSum = 0;
        for (int i = 0; i < r; i++)
        {
            currSum += temp[i];
            maxSum = max(maxSum, currSum);
            currSum = (currSum < 0) ? 0 : currSum;
        }
        return maxSum;
    }

    int maximumSumRectangle(int r, int c, vector<vector<int>> mat)
    {

        long long int max_sum = INT_MIN;
        for (int i = 0; i < c; i++)
        {
            vector<long long int> temp(r, 0);

            // for adding more columns
            for (int j = i; j < c; j++)
            {

                // compress 2 columns into single column
                for (int k = 0; k < r; k++)
                {
                    temp[k] += mat[k][j];
                }
                long long int sum = kadane(temp, r);
                if (max_sum < sum)
                {
                    max_sum = sum;
                }
            }
        }
        return max_sum;
    }
};