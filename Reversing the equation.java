//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseEqn(String s)
    {
        // your code here
        String temp="";
        int i=s.length()-1;
        while(i>=0)
        {
            if(Character.isDigit(s.charAt(i)) && Character.isDigit(s.charAt(i-1)))
            {
                temp+=s.charAt(i-1);
                temp+=s.charAt(i);
                i-=2;
            }
            else
            {
                temp+=s.charAt(i);
                i--;
            }
        }
        return temp;
    }
}
