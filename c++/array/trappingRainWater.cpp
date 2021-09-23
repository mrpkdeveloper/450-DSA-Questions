#include <iostream>
using namespace std;

int trappingWater(int arr[], int n)
{

    // Your code here
    if (n == 1)
    {
        return 0;
    }
    int maxHeight = INT_MIN;
    for (int i = 1; i < n; i++)
    {
        if (arr[i] > maxHeight)
        {
            maxHeight = arr[i];
        }
    }
    maxHeight = min(arr[0], maxHeight);
    int i, ans = 0;
    for (i = 1; i < n; i++)
    {
        if (maxHeight - arr[i] <= 0)
        {
            break;
        }
        ans += maxHeight - arr[i];
    }
    ans += trappingWater(arr + i, n - i);
    return ans;
}

int main()
{
    int n;
    cin >> n;
    int *arr = new int[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    int ans = trappingWater(arr, n);
    cout << ans << endl;
    delete[] arr;
    return 0;
}

// using constant space

long long trappingWater(int arr[], int n){
        int lmax=INT_MIN;
        int rmax=INT_MIN;
        int i=0;
        int j=n-1;
        long long result=0;
        while(i<=j)
        {
            if(arr[i]<arr[j])
            {
                if(lmax<arr[i])
                lmax=arr[i];
                else
                result+=lmax-arr[i];
                i++;
            }
            else{
                if(rmax<arr[j])
                rmax=arr[j];
                else
                result+=rmax-arr[j];
                j--;
            }
        }
        return result;
    }
