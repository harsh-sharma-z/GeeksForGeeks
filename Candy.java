//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minCandy(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minCandy(int N, int ratings[]) {
        // code here
        int[] leftToRight = new int[N];
        int[] rightToLeft = new int[N];
        leftToRight[0] = 1;
        rightToLeft[N-1] = 1;
        int j = N-1;
        for(int i = 1; i < N; i++) {
            if(ratings[i] > ratings[i-1]) leftToRight[i] = leftToRight[i-1]+1;
            else leftToRight[i] = 1;
        }
        for(int i = N-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) rightToLeft[i] = rightToLeft[i+1]+1;
            else rightToLeft[i] = 1;
        }
        int cnt = 0;
        for(int i = 0; i < N; i++) 
            cnt += Math.max(leftToRight[i], rightToLeft[i]);
        
        return cnt;
    }
}
