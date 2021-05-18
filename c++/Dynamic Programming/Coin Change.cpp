/*  
    we can divide this problem in to two type of subproblems:
    if we take the ith coin atleast once  --> dp[i][money-s[i]] 
    if we not take ith coin               --> dp[i-1][money]

*/



//  one line recurrence 
//  dp[i][j]=(((j-S[i-1])>=0)?(dp[i][j-S[i-1]]):0)+(dp[i-1][j]);



// long long int used because count can exceed the range of int in some cases


    long long int count( int S[], int m, int n )
    {
        //code here.
        // dp[i][j] states the count to make 'j money' by using 'first i' coins
        long long int dp[m+1][n+1];
        for(int i=0;i<=n;i++)
        dp[0][i]=0;    // if we have first '0 coins' then we can't do anything
        for(int j=1;j<=m;j++)
        dp[j][0]=1;    // if we have to make '0 money' then one way is to not select any coin
        
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                // take that coin atleast once required money reduce to j-S[i-1]
                // j-S[i-1] can give negative values also
                // when money is less and coin value is large then we can not take coin
                long long int take=((j-S[i-1])>=0)?(dp[i][j-S[i-1]]):0;

                // not taking the coin and required money remains same
                long long int not_take=dp[i-1][j];

                // total
                dp[i][j]=take+not_take;
            }
        }
        return dp[m][n];   // count to make n money by using first m coins
    }

// --> time complexity O(m*n)  space complexity O(m*n)