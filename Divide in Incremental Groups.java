//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int MOD=1000000007;
    int[][][] dp;
    public int countWaystoDivide(int N, int K) {
        // Code here
        dp=new int[N+1][K+1][N+1];
        for(int [][]x: dp)
        {
            for(int[] y:x)
            {
                Arrays.fill(y,-1);
            }
        }
        return solve(N,K,N);
    }
    int solve(int n,int k,int last)
    {
        if(k==0)
        return (n==0)?1:0;
        if(dp[n][k][last]!=-1)
        return dp[n][k][last];
        int ans=0;
        for(int s=1; s<=Math.min(n,last);s++)
        {
            ans+=solve(n-s,k-1,s);
            ans=ans%MOD;
        }
        
        return dp[n][k][last]=ans;
    }
}
