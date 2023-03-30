//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static class Pair{

        int dist;
        int node;

        public Pair( int node, int dist){
            this.dist=dist;
            this.node=node;
        }
    }
    
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        adj.add(new ArrayList<Pair>());
        
        for(int i[]:edges)
        {
            int u=i[0];
            int v=i[1];
            int w=i[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        int[] dis = new int[n+1];
        int[] parent=new int[n+1];
        PriorityQueue<Pair> uwu=new PriorityQueue<Pair>((x,y)-> x.dist-y.dist);
        for(int i=1;i<=n;i++)
        {
            dis[i]=(int)(1e9);
            parent[i]=i;
        }
        
        dis[1]=0;
        
        uwu.add(new Pair(1,0));
        
        while(!uwu.isEmpty())
        {
            int node=uwu.peek().node;
            int d=uwu.peek().dist;
            uwu.poll();
            
            for(Pair i:  adj.get(node))
            {
                int newnode=i.node;
                int newd=i.dist;
                if(newd+d<dis[newnode])
                {
                    dis[newnode]=newd+d;
                    uwu.add(new Pair(newnode, d+newd));
                    parent[newnode]=node;
                }
            }
        }
        
        List<Integer> ans=new ArrayList<>();
        
        if(dis[n]==1e9)
        {
            ans.add(-1);
            return ans;
        }
        
        int node=n;
        
        
        while(parent[node]!=node)
        {
            ans.add(node);
            node=parent[node];
        }
        
        ans.add(1);
        
        Collections.reverse(ans);
        return ans;
        
    }
}
