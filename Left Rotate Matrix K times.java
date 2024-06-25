//{ Driver Code Starts
// Initial Template for java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(k, mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function template for java

class Solution {
    int[][] rotateMatrix(int k, int arr[][]) {
        // code here
        
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] ans = new int[rows][cols];
        k = k % cols;
        int j = 0;

        for (int[] ar : arr) {
            ans[j] = rotationarr(ar, k);
            j++;
        }
        return ans;
    }
    
    private static int[] rotationarr(int[] arr, int k) {
        int n = arr.length,j=0;
        int [] ans = new int[n];
//        if(n%k==0) return arr;
        k = k%n;
        for(int i=k;i<n && j<n;i++){
            ans[j++] = arr[i];
        }
        for(int i=0;i<k && j<n;i++){
            ans[j++] = arr[i];
        }
        return ans;
    }
}
