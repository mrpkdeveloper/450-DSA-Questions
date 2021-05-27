/*

this is also a variant of dynamic programming 
we just need to change th condition 
when s1[i]!=s2[j] then dp[i][j]=0
and find the max value in dp table

*/

//   One Line Recurrence-> 
//   dp[i][j]=((s1[i-1]!=s2[j-1])?0:(dp[i-1][j-1]+1));


    int longestCommonSubstr (string S1, string S2, int n, int m)
    {
        // your code here
        int dp[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0 || j==0)
                dp[i][j]=0;
                else if(S1[i-1]!=S2[j-1])
                dp[i][j]=0;     // we can not make any common substring further
                else
                dp[i][j]=1+dp[i-1][j-1];
            }
        }
        int mx=0;
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                mx=max(mx,dp[i][j]);
            }
        }
        return mx;
    }


// --> time complexity O(|s1|*|s2|)  space complexity O(|s1|*|s2|)