class Solution(object):
    def get_next_number(self, nums, start_index):
        i = len(nums)-1
        while i > start_index:
            if(nums[i] > nums[start_index]):
                return i
            i-=1

    def reverse(self,nums,start_index):
        i= start_index
        j=len(nums)-1
        while i<j:
            nums[i],nums[j] = nums[j],nums[i]
            i+=1
            j-=1
        return nums
            
            
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        i = len(nums)-1
        while i > 0:
            if(nums[i-1] < nums[i]):
                next_index = self.get_next_number(nums, i-1)
                nums[i-1], nums[next_index] = nums[next_index], nums[i-1]
                return self.reverse(nums,i)
            i -= 1
            
        self.reverse(nums,0)
        return nums
