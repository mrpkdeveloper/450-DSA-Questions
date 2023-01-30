def fact(n):
    if(n<=0):
        return "Invalid Arguments"
    elif(n==1):
        return 1
    return n * fact(n-1) 


n=int(input())    
# fact(n)
print(fact(n))
