#Approach 1
class Solution:
    def isPlaindrome(self, S):
	# code here
        if(S==S[::-1]):
            return 1
        else:
            return 0
    