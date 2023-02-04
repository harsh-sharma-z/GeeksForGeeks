//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    // int sum(int arr[],int n,int ind,int dp[])
    // {
    //     if(ind>=n)
    //     {
    //         return 0;
    //     }
    //     if(dp[ind]!=-1)
    //     {
    //         return dp[ind];
    //     }
    //     int pick=arr[ind]+sum(arr,n,ind+2,dp);
    //     int npick=sum(arr,n,ind+1,dp);
    //     return dp[ind]=Math.max(pick,npick);
    // }
    int findMaxSum(int arr[], int n) {
        //int dp[]=new int[n+2];
        //Arrays.fill(dp,-1);
        //return sum(arr,n,0,dp);
        //dp[n]=0;
        // for(int i=n-1;i>=0;i--)
        // {
        //     dp[i]=Math.max(dp[i+1],arr[i]+dp[i+2]);
        // }
        // dp[0]=arr[0];
        // dp[1]=arr[1];
        int curr=0;
        int prev=arr[0];
        for(int i=1;i<n;i++)
        {
            int currnow=Math.max(prev,arr[i]+curr);
            curr=prev;
            prev=currnow;
        }
        return prev;
    }
}
