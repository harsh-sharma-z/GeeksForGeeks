//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            
            int arr[] = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxGroupSize(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int maxGroupSize(int[] a, int N, int k) {
        // code here
        int[]dp=new int[k];
        for(int i:a){
            dp[i%k]++;
        }

        int maxSize=0;
        int i=1;
        int j=k-1;
        while(i<j){
            maxSize+=Math.max(dp[i],dp[j]);
            i++;
            j--;
        }
        if(dp[0]>0){
            maxSize++;
        }
        if(i==j && dp[i]>0){
            maxSize++;
        }
        return maxSize;
    }
};
