
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Longest_subarray_less_than_k {

    public static void main(String[] args) 
    {
        template input=new template();
        int n=input.nextInt();
        int k=input.nextInt();
        int sub_a[]=new int[n];
        for(int i=0;i<n;i++)
            sub_a[i]=input.nextInt();
        int sum=0,ans=0,l=0,r=0;    //sum will store curr_sum,l will point to left boundary and r will point ot right boundary,ans will store length of longest segment.
        while(r<n)
        {
            sum+=sub_a[r];
            while(sum>k)            
            {
                sum-=sub_a[l];
                l++;
            }
            ans=Math.max(ans,r-l+1);
            r++;
        }
        System.out.println(ans);
    }
}
        /*   Explanation:-
            (Brutforce):  To find longest segment(subarray) we can just check for every segment and store the length.
                   Example:
                           4 2 1 5 2 3 9   k=10
                          Subarray starting with 4: 4 2 1 is a longest because adding 5 sum cross k so we cannot take( 4 2 1 5). length=3.
                          Subarray starting with 2: 2 1 5 2 is a longest. length=4. 
                          Subarray starting with 1: 1 5 2  is a longest.  length=3.
                          Subarray strating with 5,2,3 and 9 has length  2,2,1,1.
             Longest answer is 4 for segment(Subarray) : 2 1 5 2 
               Time complexity: O(n.n)



            (Sliding window): 
              In above example you can see that we are doing repeated work,
             For example : after checking for subarray 4 2 1 we are checking for subarray 2 1 5 2 here we are doing prefix sum again for  2  1 we can optimize it using sliding window.
           we maintain two pointer which will point to left boundary of current segment and right boundary of current segment 
              1) 4 2 1 5 2 3 9    This segment is valid because sum = 7<10 
                 l   r 
             2)  4 2 1 5 2 3 9   This segment is invalid becasue sum =12>10,so now ve move our left point and substract the value of l until we get valid sum 
                 l     r
             3)  4 2 1 5 2 3 9    Now, we have valid segment so we again move right pointer till our sum is valid.              
                   l   r    
             4)  4 2 1 5 2 3 9    This segment is valid. 
                   l     r
           Whenever we get invalid segment we try to make it valid by moving left pointer and when we have valid segment we move right pointer to get longest valid segment.
         Now you should able to check remaining segments.
 
                      */




  //This is just input template to take fast input.
       class template {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		public String next() {
			while (!st.hasMoreTokens())
				try { 
                                        st=new StringTokenizer(br.readLine());				               
                                } catch (IOException e) {}
			return st.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
