/*
the only way to partitioned given array in two array so that both sum is equal,
is we find total sum and make two array of sum (totalsum/2)

so we want to find wheather there exist a subset of totalsum/2.

*/


// one line recurrence 
// -->  dp[i][j]=(arr[i-1]>j)?(dp[i-1][j]):(dp[i-1][j] || dp[i-1][j-arr[i-1]]);

int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<N;i++)
        sum+=arr[i];     // find total sum


        if(sum&1)       // if sum is odd then we can never divide thr sum in two arrays
        return 0;


        sum=sum/2;      // targeting sum to find whether exist a subset or not

        // dp[i][j] represents that can we find subset of sum j if we can use first i elements 
        bool dp[N+1][sum+1];
        for(int i=0;i<=N;i++)
        dp[i][0]=true;   // if sum=0 then subset always exist
        for(int i=1;i<=sum;i++)
        dp[0][i]=false;  // if sum!=0 and we can use first 0 elements then answer is false
        
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1]>j) // current element is greater then required subset sum
                dp[i][j]=dp[i-1][j];  // excluding current element
                else
                // (exclude element || include element )
                dp[i][j]= (dp[i-1][j] || dp[i-1][j-arr[i-1]]);
            }
        }
        // return there exist a subset of sum if we can use first N numbers
        return dp[N][sum];
    }


// time complexity-> O(N*sum)   space complexity-> O(N*sum)