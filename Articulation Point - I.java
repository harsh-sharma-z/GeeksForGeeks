//{ Driver Code Starts
// Initial Template for Java
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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution
{
    //Function to return Breadth First Traversal of given graph

 private void dfs(int node,int parent,boolean vis[],int tin[],int low[],
   ArrayList<ArrayList<Integer>> adj,int timer, ArrayList<Integer> a){
       vis[node]=true;
       tin[node]=low[node]=timer++;
       int child=0;
       for(Integer x:adj.get(node)){
           if(x==parent)
               continue;
           if(!vis[x]){
               dfs(x,node,vis,tin,low,adj,timer,a);
               low[node]=Math.min(low[node],low[x]);
               if(low[x]>=tin[node] && parent!=-1){
                   if(!a.contains(node))
                       a.add(node);
               }
               child++;//if there is dfs  call for multiple childs we take note of it
           }else if(vis[x] && x!=parent){
               low[node]=Math.min(low[node],tin[x]);
           }
       }
       if(parent ==-1 && child>1){//if the starting node has more than 1 components
       //that are not connceted to each other
           a.add(node);
       }
   }
   public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
   {
       // Code here
       boolean vis[]=new boolean[V];
       int low[]=new int[V];
       int tin[]=new int[V];
       int timer=0;
       ArrayList<Integer> a=new ArrayList<Integer>();
       for(int i=0;i<V;i++){
           if(!vis[i]){
               dfs(i,-1,vis,tin,low,adj,timer,a);
           }
       }
       if(a.size()==0)
           {
               a.add(-1);
               return a;
           }
       Collections.sort(a);
       //a.remove(a.get(0));
       return a;
   }
}

//_______________________________________________________________________________________________________________________________________________________
                            //TARJAN ALGO

//{ Driver Code Starts
// Initial Template for Java
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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    private int timer = 1;
    private void dfs(int node, int parent, int[] vis,
                     int tin[], int low[], int[] mark,
                     ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        for (Integer it : adj.get(node)) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(it, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);
                // node --- it
                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        if (child > 1 && parent == -1) {
            mark[node] = 1;
        }
    }
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int n,
            ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i] == 1) {
                ans.add(i);
            }
        }
        if (ans.size() == 0) {
            ans.add(-1);
        }
        return ans;
    }
}
