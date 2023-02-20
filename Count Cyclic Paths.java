//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
	public static int countPaths(int N){
		//code here
		 long dp[]=new long[2];

 dp[0]=1;

 long mod=((long)1e9)+7;

 for(int i=1;i<=N;i++)

 {

     long dp0=(dp[1]*3)%mod;

     long dp1=(dp[0]+dp[1]*2)%mod;

     dp[0]=dp0;

     dp[1]=dp1;

 }

 return (int)dp[0];
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends
