    int longestSubsequence(int N, int A[])
    {
        // code here
        int dp[N];
        for(int i=0;i<N;i++)
        dp[i]=1;
        for(int i=1;i<N;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(abs(A[i]-A[j])==1 && dp[i]<dp[j]+1)
                dp[i]=dp[j]+1;
            }
        }
        int mx=0;
        for(int i=0;i<N;i++)
        mx=max(mx,dp[i]);
        return mx;
    }