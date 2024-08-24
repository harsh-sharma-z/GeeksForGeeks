//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        int dp[][]=new int[wt.length+1][W+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        return recurse(wt,val,dp,0,W);
    }
    
  static  int recurse(int wt[],int val[],int dp[][],int i,int w){
        if(w<0) return 0;
        if(i>=wt.length) return 0;
        if(dp[i][w]!=-1) return dp[i][w];
       int a= recurse(wt,val,dp,i+1,w-wt[i]);
       int b= recurse(wt,val,dp,i+1,w);
       if(wt[i]<=w) a+=val[i];
      return dp[i][w]=Math.max(a,b);
    }
}
