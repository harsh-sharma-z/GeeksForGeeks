//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair
{
    int source;
    int papa;
    public Pair(int source, int papa)
    {
        this.source=source;
        this.papa=papa;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean vis[]=new boolean[n];
        
        for(int i=0;i<n;i++)
        vis[i]=false;
        
        for(int i=0;i<n;i++)
        {
            if(vis[i]==false)
            if(cycleDekh(i,n,adj,vis)) return true;
        }
        return false;
    }
    
    private boolean cycleDekh(int src, int n, ArrayList<ArrayList<Integer>> adj, boolean[] vis)
    {
        vis[src]=true;
        Queue<Pair> uwu=new LinkedList<>();
        uwu.add(new Pair(src,-1));
        while(!uwu.isEmpty())
        {
            int node=uwu.peek().source;
            int daddy=uwu.peek().papa;
            
            uwu.remove();
            
            
            
            for(int i:adj.get(node))
            {
                if(vis[i]==false)
                {
                    vis[i]=true;
                    uwu.add(new Pair(i,node));
                }
                else
                {
                    if(i!=daddy)
                    return true;
                }
            }
        }
        return false;
    }
}
