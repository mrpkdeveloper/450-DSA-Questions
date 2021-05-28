/*
  if there are i friends then for ith friend two options :
    ->> can go alone --> ans= no of ways to pair i-1 friends
    -->> can pair up --> ans= (n-1)C(1) * no of ways to pair i-2 friends

*/

// One Line Recurrence
// ->> dp[i]=dp[i-1]+((i-1)*dp[i-2]);

method->1  time complexity-> O(N)  space complexity-> O(N)

    int countFriendsPairings(int n) 
    { 
        // code here
        // dp[i] represents the ways to pair i friends
        long long dp[n+1];
        for(int i=1;i<=n;i++)
        {
            if(i<3)
            dp[i]=i;
            else
            dp[i]=(dp[i-1]%1000000007+((i-1)*dp[i-2])%1000000007)%1000000007;
        }
        return dp[n];
    }



method->2  time complexity-> O(N)  space complexity-> O(1)

    int countFriendsPairings(int n) 
    { 
        // code here
        if(n<3)
        return n;

        // using two variable because dp[i] depend on previous two varibale(i-1,i-2)
        long long a=1;   // for i-2 th
        long long b=2;   // for i-1 th
        long long c;     // for i th
        for(int i=3;i<=n;i++)
        {
            c=(b%1000000007+((i-1)*a)%1000000007)%1000000007;
            // using modulo property 
            //   (a+b)%mod=((a%mod)+(b%mod))%mod
            //   (a*b)%mod=((a%mod)*(b%mod))%mod

            
            a=b;  // change values for next iteration
            b=c;
        }
        return c;    //return nth
    }