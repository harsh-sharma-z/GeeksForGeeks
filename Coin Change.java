//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long[][] dp = new long[N + 1][sum + 1];
        for(long[] i : dp)
            Arrays.fill(i , -1);
        return solve(coins , 0 , N , sum , dp);
    }
    private long solve(int[] coins , int i , int n , int sum , long[][] dp){
        if(dp[i][sum] != -1)
            return dp[i][sum];
        if(sum == 0){
            return dp[i][sum] = 1;
        }
        if(i == n){
            return dp[i][sum] = 0;
        }
        if(sum < coins[i]){
            return dp[i][sum] = solve(coins , i + 1 , n , sum , dp);
        }
        long take = solve(coins , i , n , sum - coins[i] , dp);
        long nottake = solve(coins , i + 1 , n , sum , dp);
        
        return dp[i][sum] = take + nottake;
    }
}
