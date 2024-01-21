//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int vertexCover(int n, int m, int[][] edges) {
        
        // to keep track of min vertex cover
        int ans = Integer.MAX_VALUE;
        
        // total combinations of vertices that can be formed = 2 ^ n
        // Here i reperesents a counter where every set bits j, (2 ^ j)th vertex is taken
        // into consideration for vertex cover
        for(int i = 0; i < (1 << n); i++){
            
            int totalEdge = m;
            
            // checking for every edge endpoints if any of those endpoints are present in
            // current vertex cover set then remove that edge
            // and after checking if no edge remains then it will be valid 
            // canditate for vertex cover and if it is min include it in ans
            for(int edg = 0; edg < m; edg++){
                
                int u = edges[edg][0] - 1;
                int v = edges[edg][1] - 1;
                
                // i is current vertex cover set so if uth or vth position are set bits 
                // then this edge is covered by current vertex cover
                if(((i >> u) & 1) == 1 || ((i >> v) & 1) == 1){
                    totalEdge--;
                }
                
            }
            
            if(totalEdge == 0){
                
                // finding set bits to count no of vetices in current vertex cover
                int vertices = findSetBits(i);
                ans = Math.min(ans, vertices);
                
            }
            
        }
        
        return ans;
    }
    
    public static int findSetBits(int n){
        
        int result = 0;
        
        while(n != 0){
            n = n & (n - 1);
            result++;
        }
        
        return result;
    }
}
