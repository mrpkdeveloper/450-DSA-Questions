class Solution:
    def countAndSay(self, n: int) -> str:
        # stro = "sadasdasdasd"
        # for ch in stro:
        #     print(ch)
        # return ""
        if n == 1:
            return "1"
        
        small = self.countAndSay(n-1)
        print(n,small)
        count = 1 
        new_number = ""
        for ch in small:
            print(ch,count,"n",new_number)
            if new_number == "" or new_number[-1] != ch:
                new_number+=str(count)
                new_number+=(ch)
                count = 1
            else:
                count+=1
        print(n,new_number)
        print()
        return new_number