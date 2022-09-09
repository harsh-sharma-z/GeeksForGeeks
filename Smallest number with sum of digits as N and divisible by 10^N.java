//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            String ans = ob.digitsNum(n);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String digitsNum(int N)
    {
        // Code here
        int num=N;
        int c=0;
        
        while(num>9)
        {
            num-=9;
            c++;
        }
        String s=String.valueOf(num);
        
        for(int i=0;i<c;i++)
        {
            s=s+"9";
        }
        
        for(int i=0;i<N;i++)
        s=s+"0";
        
        return s;
    }
}
