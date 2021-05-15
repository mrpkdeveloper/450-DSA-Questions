n=int(input("Enter Number Of Elements:"))
OriginalArray = []
for i in range(n):
  OriginalArray.append(int(input()))
ReversedArray=OriginalArray[::-1]
print("Origanal Array is ",OriginalArray)
print("Reversed Array is ",ReversedArray)
