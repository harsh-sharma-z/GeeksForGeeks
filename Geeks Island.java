//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int [][] mat = new int[N][M];
			for(int i = 0; i < N; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < M; j++) {
					mat[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			out.println(obj.water_flow(mat, N, M));
		}
		out.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
	int water_flow(int [][] mat, int n, int m)  {

	    boolean[][] indian = new boolean[n][m];	    
	    for(int i=0; i<n; i++) dfs(mat, i, 0, -1, n, m, indian);
	    for(int i=0; i<m; i++) dfs(mat, 0, i, -1, n, m, indian);
	    
	    boolean[][] arabian = new boolean[n][m];	    
	    for(int i=0; i<n; i++) dfs(mat, i, m-1, -1, n, m, arabian);
	    for(int i=0; i<m; i++) dfs(mat, n-1, i, -1, n, m, arabian);
	    
	    int cnt = 0;	    
	    for(int i=0; i<n; i++) for(int j=0; j<m; j++)
	    {
	        if(indian[i][j] && arabian[i][j]) cnt++;
	    }
	    
	    return cnt;
	}
	
	private int[] dx = new int[] { 0, 0, -1, 1 };
	private int[] dy = new int[] { -1, 1, 0, 0 };
	
	void dfs(int[][] mat, int i, int j, int prev, int n, int m, boolean[][] canTravel)
	{
	    if(i<0 || j<0 || i>=n || j>=m || canTravel[i][j] || mat[i][j] < prev) return;
	    canTravel[i][j] = true;
	    for(int k=0; k<4; k++) dfs(mat, i+dx[k], j+dy[k], mat[i][j], n, m, canTravel);
	}}
