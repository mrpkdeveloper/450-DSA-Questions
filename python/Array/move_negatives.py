# Approach 1
def rearrange(arr) :
    j = 0
    for i in range(len(arr)) :
        if (arr[i] < 0) :
            temp = arr[i]
            arr[i] = arr[j]
            arr[j]= temp
            j = j + 1
    return arr
 
# rearrange([-1, 2, -3, 4, 5, 6, -7, 8, 9]) --> [-1, -3, -7, 4, 5, 6, 2, 8, 9]