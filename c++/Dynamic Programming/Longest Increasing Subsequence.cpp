// method-1  Dynamic Programming 
// --> time complexity O(n*n)  space complexity O(n)

// one line recurrence
// -->  dp[i]=max{(a[i]>a[j]?(dp[j]+1):0),dp[i]} where   0<=j<i


    int lengthOfLIS(vector<int>& nums) {
        
        int n=nums.size();
        // dp[i] represents the length of LIS if we include ith element in LIS
        int dp[n];
        for(int i=0;i<n;i++)
            dp[i]=1;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j] && dp[i]<dp[j]+1)
                    dp[i]=dp[j]+1;
            }
        }
        int mx=0;
        for(int i=0;i<n;i++)
            mx=max(mx,dp[i]);
        return mx;
    }



// method-2 Binary Search+Dynamic Programming
// --> time complexity O(n*logn)  space complexity O(n)

/*

we use binary search function lower bound to get the first element which is not less.
suppose  array = 1,5,3,4
at second step v = 1,5
at third step v = 1,3  ( 5 is already increase the v.size() but we update 5 to 3 )
(we update value from 5 to 3 so that we can also include 4 in lis)

*/

    int longestSubsequence(int n, int a[])
    {
       // your code here
       vector<int> v;
       v.push_back(a[0]);
       for(int i=1;i<n;i++)
       {
           if(v.back()<a[i])
           {
           	   // element can be part of LIS so directly add to vector
               v.push_back(a[i]);
           }
           else
           {
           	   // update the vector to get maximum incresing sequence 
               int index=lower_bound(v.begin(),v.end(),a[i])-v.begin();
               v[index]=a[i];
           }
       }
       return v.size();
    }
