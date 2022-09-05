//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().smallestSumSubarray(arr, n)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static int smallestSumSubarray(int a[], int size)
    {
        // your code here
         if(size==1)
       {
           return a[0];
       }
       int dp[]=new int[size+1];
       dp[0]=1;
       for(int i=1;i<=size;i++)
       {
           dp[i]=Math.min(a[i-1]+dp[i-1],a[i-1]);
       }
       int min=dp[0];
       for(int i=0;i<=size;i++)
       {
           if(min>dp[i])
               min=dp[i];
       }
       return min;
    }
}
