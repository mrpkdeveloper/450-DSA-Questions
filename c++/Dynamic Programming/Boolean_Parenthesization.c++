// Boolean Parenthesization
// https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1

class Solution
{
public:
    int dp[201][201][2];
    int solve(string s, int i, int j, bool istrue)
    {

        // base case(smallest valif input)
        if (i > j)
        {
            return 0;
        }

        if (i == j)
        {
            if (istrue)
            {
                return s[i] == 'T';
            }
            else
            {
                return s[i] == 'F';
            }
        }

        // searching table
        if (dp[i][j][istrue] != -1)
        {
            return dp[i][j][istrue] % 1003;
        }

        // recursive case
        int res = 0;
        for (int k = i + 1; k <= j - 1; k += 2)
        {
            int lefttrue, righttrue, leftfalse, rightfalse;

            // calculating lefttrue, righttrue, leftfalse, rightfalse
            // for left true
            if (dp[i][k - 1][1] != -1)
            {
                lefttrue = dp[i][k - 1][1];
            }
            else
            {
                lefttrue = solve(s, i, k - 1, true);
            }

            // for left false
            if (dp[i][k - 1][0] != -1)
            {
                leftfalse = dp[i][k - 1][0];
            }
            else
            {
                leftfalse = solve(s, i, k - 1, false);
            }

            // for right true
            if (dp[k + 1][j][1] != -1)
            {
                righttrue = dp[k + 1][j][1];
            }
            else
            {
                righttrue = solve(s, k + 1, j, true);
            }

            // for right false
            if (dp[k + 1][j][0] != -1)
            {
                rightfalse = dp[k + 1][j][0];
            }
            else
            {
                rightfalse = solve(s, k + 1, j, false);
            }

            // calculating the answer based on the operator i.e (k)
            if (s[k] == '&')
            {
                if (istrue)
                {
                    res += (lefttrue * righttrue);
                }
                else
                {
                    res += (lefttrue * rightfalse + leftfalse * righttrue + leftfalse * rightfalse);
                }
            }
            else if (s[k] == '|')
            {
                if (istrue)
                {
                    res += (lefttrue * rightfalse + leftfalse * righttrue + lefttrue * righttrue);
                }
                else
                {
                    res += (leftfalse * rightfalse);
                }
            }
            else if (s[k] == '^')
            {
                if (istrue)
                {
                    res += (lefttrue * rightfalse + leftfalse * righttrue);
                }
                else
                {
                    res += (lefttrue * righttrue + leftfalse * rightfalse);
                }
            }
            dp[i][j][istrue] = res % 1003;
        }
        return dp[i][j][istrue] % 1003;
    }

    int countWays(int n, string s)
    {
        memset(dp, -1, sizeof(dp));
        return solve(s, 0, s.length() - 1, true);
    }
};