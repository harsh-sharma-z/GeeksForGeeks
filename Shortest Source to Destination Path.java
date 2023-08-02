//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Node{
        int r;
        int c;
        int d;
        Node(int r , int c , int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    int shortestDistance(int n, int m, int a[][], int x, int y) {
        // code here
        if(a[0][0] == 0)
            return -1;
            
        if(x == 0 && y == 0)
            return 0;
            
        Queue<Node> uwu = new LinkedList<>();
        
        int[][] vis = new int[n][m];
        
        uwu.offer(new Node(0 , 0 , 0));
        
        vis[0][0] = 1;
        
        int[] drow = {1 , 0 , -1 , 0};
        int[] dcol = {0 , 1 , 0 , -1};
        
        while(!uwu.isEmpty()){
            Node curr = uwu.poll();
            
            int r = curr.r;
            int c = curr.c;
            int d = curr.d;
            
            if(r == x && c == y)
                return d;
                
            for(int i = 0 ; i < 4 ; i++){
                int newr = r + drow[i];
                int newc = c + dcol[i];
                
                if(newr >= 0 && newr < n && newc >= 0 && newc < m && a[newr][newc] == 1 && vis[newr][newc] == 0){
                    uwu.offer(new Node(newr , newc , d+1));
                    vis[newr][newc] = 1;
                }
            }
        }
        return -1;
        
    }
};
