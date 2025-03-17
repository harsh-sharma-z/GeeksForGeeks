//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {

    public static boolean fun(int arr[],int n,int sum,Boolean dp[][])
    {
        if(sum==0)
        {
            return true;
        }
        if(n==0)
        {
            return false;
        }
        if(dp[n][sum]!=null)
        {
            return dp[n][sum];
        }
        if(arr[n-1]>sum)
        {
            return dp[n][sum]=fun(arr,n-1,sum,dp);
        }
        return dp[n][sum] = fun(arr,n-1,sum,dp) || fun(arr,n-1,sum-arr[n-1],dp);
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        Boolean dp[][]=new Boolean[n+1][sum+1];
        return fun(arr,n,sum,dp);
        
    }
}
