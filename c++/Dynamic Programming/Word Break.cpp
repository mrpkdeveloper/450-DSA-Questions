int wordBreak(string A, vector<string> &B) {
    //code here
    int n=A.length();
    set<string>hash;
    for(auto it:B)
    hash.insert(it);
    // dp[i] represents the string from ith character till (n-1)th is word break string or not
    int dp[n+1];
    memset(dp,0,sizeof(dp));
    dp[n]=1;
    for(int i=n-1;i>=0;i--)
    {
        string tmp;
        for(int j=i;j<n;j++)
        {
            tmp.push_back(A[j]);
            if(hash.find(tmp)!=hash.end())   // from i to j string is present in dictionary
            {
                if(dp[j+1])        // check if j+1 to (n-1)th sring is wordbreak string
                dp[i]=1;
            }
        }
    }
    return dp[0];  // return if from 0th to (n-1)th , string is word break or not
}