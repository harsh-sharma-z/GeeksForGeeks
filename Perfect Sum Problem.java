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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    
    int mod = 1000000007;
    int[][] dp;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    dp = new int[n + 1][sum + 1];
	    for(int[] i : dp)
	        Arrays.fill(i , -1);
	    return solve(arr , sum , n , 0);
	} 
	private int solve(int[] arr , int sum , int n , int i){
	    if(sum < 0)
	        return 0;
	    if(i >= n){
	        if(sum == 0)
	            return 1;
	        else
	            return 0;
	    }
	    
	    if(dp[i][sum] != -1)
	        return dp[i][sum];
	    
	    int take = solve(arr , sum - arr[i] , n , i + 1) % mod;
	    int nottake = solve(arr , sum , n , i + 1) % mod;
	    
	    return dp[i][sum] = ((take + nottake) % mod);
	}
}
