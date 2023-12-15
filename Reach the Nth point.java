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
            int ans = ob.nthPoint(n);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int nthPoint(int n)
    {
        // Code here
        int mod = (int)1e9 + 7;
        int[] dp = new int[n + 1];
        
        if(n == 0 || n == 1 || n == 2)
            return n;
        
        dp[1] = 1;
        dp[2] = 2;
        
        int i = 3;
        while(i <= n){
            dp[i] = ((dp[i - 2] % mod) + (dp[i - 1] % mod)) % mod;
            i++;
        }
        
        return dp[n];
    }
}
