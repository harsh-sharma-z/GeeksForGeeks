//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String s) {
        //your code here
        if(s == null || s.length() == 0)
            return 0;
        int[][] dp = new int[s.length()][s.length()];
        for(int[] i : dp)
            Arrays.fill(i , -1);  
        return s.length() - palindrome(s , 0 , s.length() - 1 , dp);
    }
    static int palindrome(String s , int start , int end , int[][] dp){
        if(start > end)
            return 0;
        if(start == end)
            return 1;
        if(dp[start][end] == -1){
            if(s.charAt(start) == s.charAt(end)){
                dp[start][end] = 2 + palindrome(s , start + 1 , end - 1 , dp);
            }
            else{
                dp[start][end]  = Math.max(palindrome(s , start + 1 , end , dp) , palindrome(s , start , end - 1 , dp));
            }
        }
        return dp[start][end];
    }
}
