# Program to merge two arrays without using extra space

# function to merge two arrays
def merge_array(arr1: list[int], arr2: list[int]) -> list[int]:
    arr1.extend(arr2)
    arr2.clear()
    arr1.sort()
    return arr1


# driver function
if __name__ == '__main__':
    number1 = int(input("Enter the number of elements of array 1: "))
    nums1 = list(map(int, input(f"Enter the {number1} elements: ").split()))
    number2 = int(input("Enter the number of elements of array 2: "))
    nums2 = list(map(int, input(f"Enter the {number2} elements: ").split()))
    print("Array 1: ", nums1)
    print("Array 2: ", nums2)
    print(f"Merged Array: {merge_array(nums1, nums2)}")

    
```
OUTPUT:
Enter the number of elements of array 1: 3
Enter the 3 elements: 1 2 3
Enter the number of elements of array 2: 3
Enter the 3 elements: 4 5 6
Array 1:  [1, 2, 3]
Array 2:  [4, 5, 6]
Merged Array: [1, 2, 3, 4, 5, 6]
```
