
// One Line Recurrence->
// dp[i][j]=((s[i-1]!=t[j-1])?(min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]))+1:(dp[i-1][j-1]));


int editDistance(string s, string t) {
        // Code here
        int rows=s.size();
        int cols=t.size();
        /* dp[i][j] represents minimum edit distance for first i 
        characters from string s and first j characters from string t  */
        int dp[rows+1][cols+1];
        //base cases
        dp[0][0]=0;         // if both strings are empty
        for(int i=1;i<=cols;i++)
        dp[0][i]=i;         // if(s.length==0) then we need t.length() insertions 
        for(int j=1;j<=rows;j++)
        dp[j][0]=j;         // if(t.length==0) then we need s.length() deletions
        
        //build dp table
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=cols;j++)
            {
                if(s[i-1]!=t[j-1])
                {
                    // dp[i][j]=min(Replace,Insert,Delete)+1;
                    dp[i][j]=min(dp[i-1][j-1],min(dp[i][j-1],dp[i-1][j]))+1;
                }
                else
                {
                    // both strings character are same 
                    // we don't need to perform any operations
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }

        // return minimum edit distance for first rows(=s.length) characters of s and
        // first cols characters of t;
        return dp[rows][cols];
        
    }

// --> time complexity O(|s|*|t|)  space complexity O(|s|*|t|)