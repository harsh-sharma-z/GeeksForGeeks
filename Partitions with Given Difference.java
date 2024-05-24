//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    int mod = (int) 1e9 + 7;
    
    // Memoization + Recursion
    int solve(int ind, int[] arr, int k, int[][] dp) {
        if(ind == 0) {
            if(k == 0 && arr[0] == 0)
                return 2;
            if(k == 0 || arr[0] == k)
                return 1;
            return 0;
        }
        
        if(dp[ind][k] != -1)
            return dp[ind][k];
            
        int notTake = solve(ind - 1, arr, k, dp);
        int take = 0;
        
        if(arr[ind] <= k)
            take = solve(ind - 1, arr, k - arr[ind], dp);
            
        return dp[ind][k] = (take + notTake) % mod;
    }

    int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        for(int num: arr)
            sum += num;
        
        int k = sum - d;
        if(k < 0 || k % 2 == 1)
            return 0;
            
        k /= 2;
        int dp[][] = new int[n][k + 1];
        for(int i = 0; i < n; i++)
            for(int j = 0; j <= k; j++)
                dp[i][j] = -1;
        
        return solve(n - 1, arr,  k, dp);
    }
    
    // Tabulation
    int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        for(int num: arr)
            sum += num;
    
        int k = sum - d;
        if(k < 0 || k % 2 == 1)
            return 0;
            
        k /= 2;
        int dp[][] = new int[n][k + 1];
        
        for(int i = 0; i < n; i++)
            dp[i][0] = 1;
            
        if(arr[0] <= k)
            dp[0][arr[0]] = 1;
            
        if(arr[0] == 0)
            dp[0][0] = 2;
            
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                
                if(arr[i] <= j)
                    take = dp[i - 1][j - arr[i]];
                    
                dp[i][j] = (take + notTake) % mod;
            }
        }
        
        return dp[n - 1][k];
    }
    
    // Space Optimization
    int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        for(int num: arr)
            sum += num;
        
        int k = sum - d;
        if(k < 0 || k % 2 == 1)
            return 0;
            
        k /= 2;
        int curr[] = new int[k + 1], prev[] = new int[k + 1];
            
        if (arr[0] == 0)
            prev[0] = 2;
        else
            prev[0] = 1;
    
        if (arr[0] != 0 && arr[0] <= k)
            prev[arr[0]] = 1;
            
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                int notTake = prev[j];
                int take = 0;
                
                if(arr[i] <= j)
                    take = prev[j - arr[i]];
                    
                curr[j] = (take + notTake) % mod;
            }
            
            for(int j = 0; j <= k; j++)
                prev[j] = curr[j];
        }
        
        return prev[k];
    }
}
        
