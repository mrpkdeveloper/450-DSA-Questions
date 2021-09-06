// Interleaved String
// https://practice.geeksforgeeks.org/problems/interleaved-strings/1

class Solution
{
public:
    /*You are required to complete this method */
    bool isInterleave(string a, string b, string c)
    {
        int m = a.size();
        int n = b.size();

        if (m + n != c.length())
        {
            return false;
        }

        bool dp[m + 1][n + 1];
        memset(dp, 0, sizeof(dp));

        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {

                // if both strings are empty
                if (i == 0 && j == 0)
                {
                    dp[i][j] = true;
                }

                // if a is empty
                else if (i == 0)
                {
                    if (b[j - 1] == c[i + j - 1])
                    {
                        dp[i][j] = dp[i][j - 1];
                    }
                }

                // if b is empty
                else if (j == 0)
                {
                    if (a[i - 1] == c[i + j - 1])
                    {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                else if (a[i - 1] == c[i + j - 1] && b[j - 1] != c[i + j - 1])
                {
                    dp[i][j] = dp[i - 1][j];
                }
                else if (a[i - 1] != c[i + j - 1] && b[j - 1] == c[i + j - 1])
                {
                    dp[i][j] = dp[i][j - 1];
                }
                else if (a[i - 1] == c[i + j - 1] && b[j - 1] == c[i + j - 1])
                {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
};