# Approach 1
def cyclic_rotate(arr):
    n = len(arr)
    x = arr[n - 1]
    for i in range(n-1, 0, -1):
        arr[i] = arr[i - 1]
    arr[0] = x
    return arr

# cyclic_rotate([1, 2, 3, 4, 5]) --> [5, 1, 2, 3, 4]