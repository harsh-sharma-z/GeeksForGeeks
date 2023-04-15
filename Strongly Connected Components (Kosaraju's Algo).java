//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    
    private void dfs(int i,ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> uwu)
    {
        vis[i]=1;
        
        for(int node: adj.get(i))
            if(vis[node]==0)
                dfs(node, adj, vis, uwu);
        
        uwu.push(i);
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int vis[]=new int[V];
        Stack<Integer> uwu=new Stack<>();
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,adj,vis,uwu);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjRev=new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<V;i++)
            adjRev.add(new ArrayList<>());
        
        for(int i=0;i<V;i++)
        {
            vis[i]=0;
            
            for(int it: adj.get(i))
                adjRev.get(it).add(i);
        }
        
        int ans=0;
        
        while(!uwu.isEmpty())
        {
            
            int node=uwu.pop();
            
            
            if(vis[node]==0)
            {
                ans++;
                dfs2(node,vis,adjRev);
            }
        }
        
        return ans;
        
    }
    
    private void dfs2(int node, int[] vis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node]=1;
        
        for(int i:adj.get(node))
            if(vis[i]==0)
                dfs2(i,vis,adj);
    }
}
