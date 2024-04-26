//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
        String helper[] = new String[] {"East","South","West","North"};
        int directionidx = 0;
        String direction = "East";
        int i=0,j=0;
        while(i>=0 && i<matrix.length && j>=0 && j<matrix[0].length){
                if(matrix[i][j] == 1){
                    matrix[i][j] = 0;
                    directionidx=(directionidx+1)%(helper.length);
                    direction = helper[directionidx];
                }
                if(direction.equals("East")) j++;
                else if(direction.equals("West")) j--;
                else if(direction.equals("North")) i--;
                else if(direction.equals("South")) i++;
        }
        if(i<0) i++;
        else if(i>= matrix.length) i--;
        if(j<0) j++;
        else if(j>= matrix[0].length) j--;
        
        return new int[]{i,j};
    }
}
