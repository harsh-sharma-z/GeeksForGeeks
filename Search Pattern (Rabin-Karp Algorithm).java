//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pattern, String text)
    {
        // your code here
        ArrayList<Integer> ans=new ArrayList<>();
         int j=0;
        for(int i=0;i<text.length()-pattern.length()+1;i++){
            if(text.charAt(i)==pattern.charAt(0)){
                
                for(j=1;j<pattern.length();j++){
                    if(text.charAt(i+j)!=pattern.charAt(j)){
                       break; 
                    }
                }
                if(j==pattern.length()){
                   ans.add(i+1);                }
            }
        }
        return ans;
    }
}
