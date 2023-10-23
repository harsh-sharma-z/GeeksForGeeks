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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int[][] dp;
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    dp = new int[n + 1][n];
	    for(int[] i : dp)
	        Arrays.fill(i , -1);
	    return solve(arr , n , -1 , 0);
	}  
	private int solve(int[] arr , int n , int prev , int curr){
	    if(curr >= n){
	        return 0;
	    }
	    
	    if(dp[prev + 1][curr] != -1){
	        return dp[prev + 1][curr];
	    }
	    
	    int take = 0;
	    int nottake = 0;
	    if(prev == -1){
	        take = arr[curr] + solve(arr , n , curr , curr + 1);
	        nottake = solve(arr , n , prev , curr + 1);
	    }
	    else{
	        if(arr[prev] < arr[curr]){
	            take = arr[curr] + solve(arr , n , curr , curr + 1);
	            nottake = solve(arr , n , prev , curr + 1);
	        }
	        else{
	            nottake = solve(arr , n , prev , curr + 1);
	        }
	    }
	    
	    return dp[prev + 1][curr] = Math.max(take , nottake);
	}
}
