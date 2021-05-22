/* 
s1= "abc" ,s2= "abd"
 ---> second character same then       LCS(ab,ab)=LCS(a,a)+1;
 ---> third character differ then      LCS(abc,abd)=maximum(LCS(ab,abd),LCS(abc,ab));
*/


//   One Line Recurrence-> 
//   dp[i][j]=((s1[i-1]!=s2[j-1])?(max(dp[i-1][j],dp[i][j-1])):(dp[i-1][j-1]+1));

//Function to find the length of longest common subsequence in two strings.
    int lcs(int x, int y, string s1, string s2)
    {
        // your code here
        /* dp[i][j] represents LCS of for first i characters 
        from string s and first j characters from string t  */
        int dp[x+1][y+1];

        for(int i=0;i<=x;i++)
        {
            for(int j=0;j<=y;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=0;  // if any string is empty LCS length is 0
                }
                else if(s1[i-1]!=s2[j-1])
                {
                    //strings characters not match
                    // go for dp[i-1][j] and dp[i][j-1]
                    // and select max;
                    dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
                }
                else
                {
                    // strings character are matched
                    // directly add 1 to ans of dp[i-1][j-1]
                    dp[i][j]=dp[i-1][j-1]+1;                   
                }
            }
        }
        // return LCS of first x characters of s1 and 
        // first y characters of s2
        return dp[x][y];
    }

// --> time complexity O(|s1|*|s2|)  space complexity O(|s1|*|s2|)