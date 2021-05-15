# Approach 1
def factorial(num):
    factorial = 1
    if num < 0:
       return "Factorial does not exist for negative numbers"
    elif num == 0:
       return "factorial of 0 is 1"
    else:
       for i in range(1,num + 1):
           factorial = factorial * i
       return factorial

# factorial(10) --> 3628800