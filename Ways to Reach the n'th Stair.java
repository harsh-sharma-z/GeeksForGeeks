//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countWays(int n) {
        // your code here
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }
        
        int dp[] = new int[n];
        
        dp[0] = 1;
        dp[1] = 2;
        
        for(int i =2;i<n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n-1];
    }
}
