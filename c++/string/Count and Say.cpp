//Link : https://leetcode.com/problems/count-and-say/
/*
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.*/

class Solution {
public:
    string countAndSay(int n) {
        if(n==1) return "1";  //for n==1
        if(n==2) return "11";  //for n==2
        string s="11";   
        for(int i=3;i<=n;i++)
        {
            string str="";
            s+='&';
            int count=1;
            for(int j=1;j<s.length();j++)
            {
                if(s[j]==s[j-1]) count++;    
                else{
                    str+=to_string(count);
                    str+=s[j-1];
                    count=1;
                }
            }
            s=str;
        }
        return s;
    }
};