//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        // Add your code here.
        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1);
        return solve(n , dp);
    }
    private int solve(int n , int[] dp){
        if(n == 0)
            return 1;
        if(n < 0)
            return 0;
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = solve(n - 3 , dp) + solve(n - 5 , dp) + solve(n - 10 , dp)-(solve(n-8,dp)+solve(n-15,dp)+solve(n-13,dp))+solve(n-18,dp);
    }
}
