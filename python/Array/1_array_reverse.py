class Solution:
    def reverseWord(s):
        # for reversing the array we will traverse it from 0th index to the mid index
        # and keep swapping the ith index value with (len(s)-i)th index value
        l=len(s)
        
        for i in range(len(s)//2):
            s[i],s[l-i-1] = s[l-i-1],s[i]
            
        return(s)
