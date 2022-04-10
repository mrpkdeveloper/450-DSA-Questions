def Triple_sum(n,X,Array):

    # n - Number of array elements
    # X - The required sum of 3 elements (to be compared with our result)
    # Array - Input Array
    Array.sort()
    count = 0
    for i in range(len(Array)-1):
        j = i+1
        k = n-1
        while(j<k):
            sum = Array[i] + Array[j] + Array[k]
            if sum == X:
                count+=1
                break
            elif sum > X:
                k -= 1
            else:
                j += 1
    return count 
