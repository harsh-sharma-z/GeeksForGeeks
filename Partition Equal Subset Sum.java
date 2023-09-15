//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0 ;
        for(int i : arr)
            sum += i;
        
        if(sum % 2 == 1)
            return 0;
        
        sum /= 2;
        
        boolean[] dp = new boolean[sum + 1];;
        
        return solve(arr , sum , N - 1 , dp) ? 1 : 0;
    }
    
    static boolean solve(int[] arr , int sum , int n , boolean[] dp){
        if(sum == 0)
            return true;
        if(n <= 0)
            return false;
        if(sum < 0)
            return false;
            
        if(dp[sum])
            return false;
        
        return dp[sum] = solve(arr , sum - arr[n - 1] , n - 1 , dp) || solve(arr , sum , n - 1 , dp);
    }
}
