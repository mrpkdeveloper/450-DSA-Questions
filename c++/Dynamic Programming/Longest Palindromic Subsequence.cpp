// Longest palindromic subsequence is the variant of LCS
// if s is string and t is reverse of s then  
// LCS of s and t gives us longest palindromic subsequence of s


class Solution {
public:
    string longestPalindrome(string s) {
        
        int n=s.size();
        string t=s;
        reverse(t.begin(),t.end());
        
        // finding length of LCS
        int dp[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(s[i-1]!=t[j-1])
                    dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
                else
                    dp[i][j]=dp[i-1][j-1]+1;
            }
        }


        // print LCS of s and t
        int i=n,j=n;
        string ans;
        while(i>0 && j>0)
        {
            if(s[i-1]!=t[j-1])
            {
                if(dp[i-1][j]<dp[i][j-1])
                    j--;
                else
                    i--;            
            }
            else
            {
                ans.push_back(s[i-1]);
                i--;
                j--;
            }
        }
        return ans;
    }
};
