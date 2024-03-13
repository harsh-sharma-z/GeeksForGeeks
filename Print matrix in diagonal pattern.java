//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        
        int n = row;
        
        int count = 0;
        int ans[] = new int[row*col];
        int ev = 0;
        
        for(int i=0;i<n;i++){
            if(ev%2==0){//down to up
                int pos = i;
                for(int j=0;j<=i;j++){
                    ans[count++] = mat[pos][j];
                    pos--;
                }
            }else{
                int pos = 0;
                for(int j=i;j>=0;j--){
                    ans[count++] = mat[pos][j];
                    pos++;
                }
            }
            ev++;
        }
        for(int i=1;i<n;i++){
            if(ev%2==0){
                int pos = n-1;
                for(int j=i;j<n;j++){
                    ans[count++] = mat[pos][j];
                    pos--;
                }
            }else{
                int pos = i;
                for(int j=n-1;j>=i;j--){
                    ans[count++] = mat[pos][j];
                    pos++;
                }
            }
            ev++;
        }
        return ans;
    }
}
