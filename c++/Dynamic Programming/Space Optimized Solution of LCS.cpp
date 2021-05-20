/*

as we can easily see that LCS[i,j] is depending on
(LCS[i-1][j-1],LCS[i-1][j],LCS[i][j-1]) 
all values are easily calculatedif we have i-1 rows and ith row
then we can just use 2 rows and done the same implementation.
so that space complexity reduces to O(X.length());

*/ 
int lcs(string &X, string &Y)
{
    int m = X.length(), n = Y.length();
  
    int L[2][n + 1];
  
    // Binary index, used to index current row and previous row
    bool bi;
  
    for (int i = 0; i <= m; i++)
    {
          
        // Compute current binary index
        bi = i & 1;
  
        for (int j = 0; j <= n; j++)
        {
            if (i == 0 || j == 0)
                L[bi][j] = 0;
  
            else if (X[i-1] == Y[j-1])
                 L[bi][j] = L[1 - bi][j - 1] + 1;
  
            else
                L[bi][j] = max(L[1 - bi][j], 
                               L[bi][j - 1]);
        }
    }
  
    // length of LCS
    // for X[0..n-1] and Y[0..m-1] 
    return L[bi][n];
}