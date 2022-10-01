//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

 

    public void DFS (int Crow, int Ccol, int row, int col, int [][] visited,int [][] Grid,  ArrayList<String> list, int n, int m ) {

        visited[row][col] = 1;

        // Node node = new Node(row-Crow, col-Ccol);

        list.add(toString(row-Crow, col-Ccol));

        int [] delRow= new int[]{-1, 0, 1, 0};

        int [] delCol= new int[]{0, -1, 0, 1};

        

        int NRow = 0, NCol = 0;

        for(int i=0; i<4; i++){

            NRow = delRow[i] + row;

            NCol = delCol[i] + col;

            if(NRow >=0 && NRow < n && NCol >=0 && NCol < m && visited[NRow][NCol] == 0 && Grid[NRow][NCol] == 1){

                DFS(Crow, Ccol, NRow, NCol, visited, Grid, list, n, m);

            }

        }

    }

    public String toString(int row, int col) {

        return Integer.toString(row) + " " + Integer.toString(col);

    }

    int countDistinctIslands(int[][] grid) {

        int n = grid.length; 

        int m= grid[0].length;

        HashSet<ArrayList<String> > hs= new HashSet<>();

        int [][] visited= new int[n][m];

        for(int i=0; i<n; i++){

            for(int j=0; j<m; j++){

                if(visited[i][j] == 0 && grid[i][j] == 1){

                    ArrayList<String> list = new ArrayList<>();

                    DFS(i, j, i, j, visited, grid, list, n, m );

                    hs.add(list);

                }

            }

        }

      

        return hs.size();

    }
}
