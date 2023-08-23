//{ Driver Code Starts
//Initial Template for Java

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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        int row[] = {-1,-1,0,1,1,1,0,-1};
        int col[] = {0,1,1,1,0,-1,-1,-1};

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j]==word.charAt(0)){
                    int res = 0;
                    for(int k=0; k<8; k++){
                        int r = i+row[k];
                        int c = j+col[k];

                        int count = 0;
                        if(word.length()>1){
                            if(isSafe(r,c,1,grid,word,n,m)){
                                count = solve(r,c,2,grid,word,n,m,row[k],col[k]);
                                if(count==1){
                                    res = 1;
                                    break;
                                }
                            }
                        }
                        else res = 1;
                    }
                    if(res==1){
                        ArrayList<Integer> abc = new ArrayList<>();
                        abc.add(i);
                        abc.add(j);
                        list.add(abc);
                    }
                }
            }
        }
        int arr[][] = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            arr[i][0] = list.get(i).get(0);
            arr[i][1] = list.get(i).get(1);
        }

        return arr;
    }
     boolean isSafe(int i, int j, int k, char[][] grid, String word, int n, int m){
        if(i>=0 && i<n && j>=0 && j<m && grid[i][j]==word.charAt(k)) return true;
        return false;
    }

    int solve(int i, int j, int k, char[][] grid, String word, int n, int m, int row, int col){
        if(k==word.length()) return 1;
        if(isSafe(i+row,j+col,k,grid, word,n,m)){
            int count = solve(i+row,j+col,k+1,grid,word,n,m,row,col);
            if(count==1) return 1;
        }
        return 0;
        
    }
}
