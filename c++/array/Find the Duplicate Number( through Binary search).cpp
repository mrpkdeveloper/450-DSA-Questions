// Find the Duplicate Number
// Link : https://leetcode.com/problems/find-the-duplicate-number/
// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

// There is only one repeated number in nums, return this repeated number.

 

// Example 1:

// Input: nums = [1,3,4,2,2]
// Output: 2
// Example 2:

// Input: nums = [3,1,3,4,2]
// Output: 3
// Example 3:

// Input: nums = [1,1]
// Output: 1
// Example 4:

// Input: nums = [1,1,2]
// Output: 1
 

// Constraints:

// 2 <= n <= 105
// nums.length == n + 1
// 1 <= nums[i] <= n
// All the integers in nums appear only once except for precisely one integer which appears two or more times.


int findDuplicate(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int l=0,h=nums.size()-1,mid;
        while(l<h){
            mid=l+(h-l)/2;
            if(nums[mid]==nums[mid+1] or nums[mid]==nums[mid-1])return nums[mid];
            else if(nums[mid]<mid+1)h=mid-1;
            else l=mid+1;
        }
        return mid;
    }