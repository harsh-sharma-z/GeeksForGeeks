//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestSubstring(String s, int n) {
        // code here
        int[][] dp = new int[n + 1][n + 1];
        int max = 0 , end = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(s.charAt(i - 1) == s.charAt(j - 1) && dp[i - 1][j - 1] < (j - i))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    
                if(max < dp[i][j]){
                    max = dp[i][j];
                    end = i;
                }
            }
        }
        return (max > 0) ? s.substring(end - max , end) : "-1";
    }
};
