// 0-1 knapsack problem

/*
for every item we have two possibilities
   1--> we do not choose ith item -->  dp[i-1][j]
   2--> we choose the ith item    -->  dp[i-1][j-wt[i-1]]+val[i-1]

   and dp[i][j] is maximum of these values
*/


// one line recurrence
// dp[i][j]=max(dp[i-1][j],((j-wt[i-1])>=0?dp[i-1][j-wt[i-1]]+val[i-1]:0))

    int knapSack(int W, int wt[], int val[], int n) 
    { 
       // Your code here
    	// dp[i][j] represents the maximum total value if we have j capacity knapsack
    	// and we can use first i items
       int dp[n+1][W+1];

       for(int i=0;i<=n;i++)
       {
           for(int j=0;j<=W;j++)
           {
               //base case
               if(i==0 || j==0)
               {
               	// if we have first 0 item || we have 0 capacity knapsack 
               	//then maximum total value=0
                    dp[i][j]=0;   
               }
               else if(wt[i-1]>j)
               {
               	// if current weight is greater then available knapsack 
               	//then we can not add that item
                   dp[i][j]=dp[i-1][j];
               }
               else
               {
               	// max total will be maximum of(if not ith take item,take ith item)
                   dp[i][j]=max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);
               }
           }
       }

       //  return the maximum total value if we have W capacity knapsack
    	// and we can use first n items
       return dp[n][W]; 
    }

 // --> time complexity O(n*W)  space complexity O(n*W)