//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());//testcases
        
        while(t-- > 0)
        {
            long n = Long.parseLong(read.readLine());//input n
            
            Solution ob= new Solution();
            System.out.println(ob.numberOfSquares(n));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long numberOfSquares(long base)
    {
        //code here
        if(base%2==0)
        {
            long c=(base-2)/2;
            return ((c*(c+1))/2);
        }
        long c= (base-3)/2;
        return ((c*(c+1))/2);
    }
}
