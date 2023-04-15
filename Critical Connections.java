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
            ArrayList<ArrayList<Integer>> ans = obj.criticalConnections(V, adj);
            for(int i=0;i<ans.size();i++)
                System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Sort implements Comparator<ArrayList<Integer>>

{

    public int compare(ArrayList<Integer> a, ArrayList<Integer> b)

    {

        int x=a.get(0)-b.get(0);

        int y=a.get(1)-b.get(1);

        return x==0?y:x;

    }

}


class Solution
{
    
    private int timer=1;

    private void dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj,int [] tin, int[] low,ArrayList<ArrayList<Integer>> bridges)
    {
        vis[node]=1;

        tin[node]=low[node]=timer;
        timer++;

        for(Integer i:adj.get(node))
        {
            if(i==parent) continue;
            if(vis[i]==0)
            {
                dfs(i,node, vis,adj,tin,low,bridges);

                low[node]=Math.min(low[node],low[i]);

                if(low[i]>tin[node])
                {
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(node);
                    Collections.sort(temp);
                    bridges.add(new ArrayList<>(temp));
                }
            }
            else
            {
                low[node]=Math.min(low[node],low[i]);
            }
        }
    }



    public ArrayList<ArrayList<Integer>> criticalConnections(int n, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int []vis=new int[n];

        int []tin=new int[n];

        int []low=new int[n];

        ArrayList<ArrayList<Integer>> bridges=new ArrayList<>();

        dfs(0,-1,vis,adj,tin,low,bridges);
       Collections.sort(bridges,new Sort());
        return bridges;
        
    }
}
