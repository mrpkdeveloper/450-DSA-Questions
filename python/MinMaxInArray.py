def min_ele(arr,n):
  min = 10**9
  for i in range(n):
    if arr[i] < min:
      min=arr[i]
  return min

def max_ele(arr,n):
  max = 0
  for i in range(n):
    if arr[i] > max:
      max=arr[i]
  return max

N=int(input("Enter number of elements:"))
A=[]
for i in range(N):
      k=int(input("Enter " + str(i+1) +" Element Into Array:"))
      A.append(k)
print("Original Array is ",A)
print("Max Number In Array is",max_ele(A,N)) 
print("Min Number In Array is",min_ele(A,N)) 
