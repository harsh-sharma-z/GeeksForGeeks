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
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int distinctSubsequences(String s) {
        // code here
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        int mod = 1000_000_007;
        HashMap<Character , Integer> uwu = new HashMap<>();
        for(int i = 1 ; i <= n ; i++){
            char ch = s.charAt(i - 1);
            dp[i] = (2 * dp[i - 1] % mod) % mod;
            if(uwu.containsKey(ch)){
                int j = uwu.get(ch);
                dp[i] = (dp[i] % mod - dp[j - 1] + mod) % mod;
            }
            uwu.put(ch , i);
        }
        
        return (int)(dp[n] % mod);
    }
}
