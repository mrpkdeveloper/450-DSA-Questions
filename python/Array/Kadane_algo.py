def MaxSubarraySum(array ,n):
    max = array[0]
    sum = 0
    for i in range(len(array)-1):
        sum += array[i]
        if sum > max:
            max = sum
        if sum < 0:
            sum = 0
    return max