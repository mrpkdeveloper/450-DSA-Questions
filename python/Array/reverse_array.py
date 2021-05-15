# Approach 1
def reverseList(A, start, end):
    while start < end:
        A[start], A[end] = A[end], A[start]
        start += 1
        end -= 1
# reverseList([1, 2, 3, 4, 5, 6], 0, 5) = [6 5 4 3 2 1]


# Approach 2
def reverseList(A, start, end):
    if start >= end:
        return
    A[start], A[end] = A[end], A[start]
    reverseList(A, start+1, end-1)
# reverseList([1, 2, 3, 4, 5, 6], 0, 5) = [6 5 4 3 2 1]


# Approach 3
def reverseList(A):
    return A[::-1]


# Approach 4
def reverseList(A):
    return list(reversed(A))


# Approach 5
def reverseList(A):
    return A.reverse()