// unbounded knapsack problem

/*
for every item we have two possibilities
   1--> we do not choose ith item -->  dp[i-1][j]
   2--> we choose the ith item atleast once   -->  dp[i][j-wt[i-1]]+val[i-1]

   and dp[i][j] is maximum of these values
*/


// one line recurrence
// dp[i][j]=max(dp[i-1][j],((j-wt[i-1])>=0?dp[i][j-wt[i-1]]+val[i-1]:0))

    int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        // dp[i][j] represents the maximum total value if we have j capacity knapsack
        // and we can use first i items
        int dp[N+1][W+1];

        // if we have first 0 item || we have 0 capacity knapsack 
        //then maximum total value=0
        for(int i=0;i<=N;i++)
        dp[i][0]=0;
        for(int j=0;j<=W;j++)
        dp[0][j]=0;
        
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=W;j++)
            {
                if(wt[i-1]<=j)
                // max total will be maximum of(if not ith take item,take ith item atleast once)
                dp[i][j]=max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                else
                // if current weight is greater then available knapsack 
                //then we can not add that item
                dp[i][j]=dp[i-1][j];
            }
        }
        
        return dp[N][W];
    }

// --> time complexity O(n*W)  space complexity O(n*W)