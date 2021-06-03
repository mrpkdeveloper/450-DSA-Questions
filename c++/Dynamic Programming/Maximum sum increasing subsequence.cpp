// LIS variation
int maxSumIS(int arr[], int n)  
	{  
	    // Your code goes here
	    int sum[n];
	    for(int i=0;i<n;i++)
	    sum[i]=arr[i];
	    
	    for(int i=1;i<n;i++)
	    {
	        for(int j=0;j<i;j++)
	        {
	            if(arr[i]>arr[j] && sum[i]<sum[j]+arr[i])
	            sum[i]=sum[j]+arr[i];
	        }
	    }
	    int mx=0;
	    for(int i=0;i<n;i++)
	    mx=max(mx,sum[i]);
	    return mx;
	}  