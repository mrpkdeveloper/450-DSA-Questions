
#Approach 1  - list reverse slicing 
def isPlaindrome(S):
	    if(S==S[::-1]):
	        return 1 
	    return 0
    
    
#Approach 2      
def isPlaindrome(self, S):
      if(len(S)==1):
        return 1
	    start=0
	    end=len(S)-1
	    while(start<=end):
	        if(S[start]!=S[end]):
	            return 0 
	        start+=1
	        end-=1
	    return 1
    

