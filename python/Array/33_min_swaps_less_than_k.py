#User function Template for python3

def minSwap (arr, n, k) : 
    # n = len(arr)
    number_of_ele = 0
    
    for ele in (arr):
        if ele <= k:
            number_of_ele+=1
            
    if number_of_ele <=1:
        return 0
    
    left = 0
    right = number_of_ele-1 #0 based indexing
        
    i =0
    not_required = 0
    while i<=right:
        if arr[i] > k:
            not_required+=1
        i+=1
        
        
    min_swaps = not_required
    while (right+1) < n: 
        if arr[left] > k:
            not_required-=1
        left+=1
        right+=1
        if arr[right] > k:
            not_required+=1
        min_swaps= min(min_swaps,not_required)
    return min_swaps
    #Complete the function
    



#{ 
#  Driver Code Starts
#Initial Template for Python 3

for _ in range(0,int(input())):
    n = int(input())
    arr = list(map(int, input().strip().split()))
    k = int(input())
    ans = minSwap(arr, n, k)
    print(ans)
    





# } Driver Code Ends