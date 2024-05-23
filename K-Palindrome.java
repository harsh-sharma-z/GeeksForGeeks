//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String input_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            int k = Integer.parseInt(input_line[1]);
            String str = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.kPalindrome(str, n, k));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kPalindrome(String str, int n, int k) {
        // code here
        int dp[][] = new int[n][n];
     for(int g =0;g<str.length();g++){
         for(int i =0,j = g;j<str.length();i++,j++){
             if(g==0){
                 dp[i][j] = 1;
                 
             }
             else if(g==1)
             {
                 if(str.charAt(i) == str.charAt(j)){
                 dp[i][j] = 2;
         }
         else{
             dp[i][j] = 1;
         }
             }
         else{
             
             if(str.charAt(i)==str.charAt(j)){
                 dp[i][j] = 2+dp[i+1][j-1];
             }
             else{
                 dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
             }
         }
     }
     }
     //System.out.println(dp[0][n-1]);
        return n-dp[0][n-1]>k  ? 0 :1;
    }
}
