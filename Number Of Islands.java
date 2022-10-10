//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    
       public void CountNumberOfIslands(int row, int col, int [][] visited, int [][] dp, int n, int m){

 

        visited[row][col] = 1;

 

        int[] Rows = new int[]{-1, 0 , 1, 0};

 

        int[] Cols = new int[]{0, 1, 0, -1};

 

        int NRow = 0, NCol =0;

 

        for(int i=0; i<4; i++){

 

            NRow = Rows[i] + row;

 

            NCol = Cols[i] + col;

 

            // System.out.println("NRow and NCol is "+ NRow + " "+ NCol);

 

            if(NRow >= 0 && NRow< n && NCol >= 0 && NCol < m && visited[NRow][NCol] == 0 && dp[NRow][NCol] == 1){

 

                CountNumberOfIslands(NRow, NCol, visited, dp, n, m);

 

            }

 

        }

 

    }

 

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {

 

        

 

        

 

        int [][] visited = new int[rows][cols];

 

        int [][] dp= new int[rows][cols];

 

        List<Integer> list= new ArrayList<>();

 

        int count=0;

 

        for(int i=0; i<operators.length; i++){

 

            dp[operators[i][0]][operators[i][1]] = 1;

 

            count=0;

 

            for(int j=0; j< rows ; j++){

 

                for(int k= 0; k<cols ; k++){

 

                    

 

                    if(visited[j][k] == 0 && dp[j][k] == 1){

 

                        CountNumberOfIslands(j, k, visited, dp, rows, cols );

 

                        count++;

 

                    }

 

                }

 

            }

 

            for(int j=0; j< rows ; j++){

 

                for(int k= 0; k<cols ; k++){

 

                    visited[j][k] = 0;

 

                }

 

            }

 

            list.add(count);

 

        }

 

 

 

        return list;

 

    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends
