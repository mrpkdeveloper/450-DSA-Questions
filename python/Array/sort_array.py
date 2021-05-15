# Approach 1 - Bubble Sort
def sort_array(nums):
    swapped = True
    while swapped:
        swapped = False
        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                # Swap the elements
                nums[i], nums[i + 1] = nums[i + 1], nums[i]
                # Set the flag to True so it will loop again
                swapped = True
    return nums


# sort_array([0, 2, 1, 0, 1]) --> [0, 0, 1, 1, 2]
