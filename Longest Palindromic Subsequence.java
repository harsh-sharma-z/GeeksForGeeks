//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    
    // //Memoization
    // public int longestPalinSubseq(String s)
    // {
    //     //code here
    //     int n = s.length();
    //     StringBuilder a = new StringBuilder();
    //     a.append(s);
    //     StringBuilder b = new StringBuilder();
    //     b.append(s);
    //     b.reverse();
    //     int[][] dp = new int[n][n];
    //     for(int i[]: dp)
    //     Arrays.fill(i,-1);
    //     return help(n-1 , n-1 , a , b , dp);
    // }
    // private int help(int i , int j , StringBuilder a , StringBuilder b , int[][] dp){
    //     if(i < 0 || j < 0)
    //         return 0;
            
    //     if(dp[i][j] != -1)
    //         return dp[i][j];
            
    //     if(a.charAt(i) == b.charAt(j))
    //         return dp[i][j] = 1 + help(i-1 , j-1 , a , b , dp);
        
    //     return dp[i][j] = Math.max(help(i , j-1 , a , b , dp) , help(i-1 , j , a , b , dp));
    // }
    
    
    
    //Tabulation
    public int longestPalinSubseq(String s)
    {
        //code here
        int n = s.length();
        StringBuilder a = new StringBuilder();
        a.append(s);
        StringBuilder b = new StringBuilder();
        b.append(s);
        b.reverse();
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0 + Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        
        return dp[n][n];
    }
}
