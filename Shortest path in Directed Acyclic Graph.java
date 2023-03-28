//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    class Pair{
        int first;
        int second;
        public Pair(int first, int second)
        {
            this.first=first;
            this.second=second;
        }
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		
		ArrayList<ArrayList<Pair>>  adj = new ArrayList<>();
		
		for(int i=0;i<N;i++)
		adj.add(new ArrayList<Pair>());
		
		for(int i=0;i<M;i++)
		{
		    int u=edges[i][0];
		    int v=edges[i][1];
		    int weight=edges[i][2];
		    adj.get(u).add(new Pair(v,weight));
		}
		
		
		int vis[]=new int[N];
		
		Stack<Integer> uwu=new Stack<>();
		for(int i=0;i<N;i++)
		if(vis[i]==0)
		topo(i,adj,vis,uwu);
		
		int[] dist=new int[N];
		
		
		Arrays.fill(dist,1000000007);
		
		dist[0]=0;
		
		
		while(!uwu.isEmpty())
		{
		    int node=uwu.pop();
		    
		    
		    for(Pair i: adj.get(node))
		    {
		        int v=i.first;
		        int weight=i.second;
		        
		        if(dist[node]+weight < dist[v])
		        dist[v]=weight + dist[node];
		    }
		}
		
		for(int i=0;i<N;i++)
		if(dist[i]==1000000007)
		dist[i]=-1;
		
		return dist;
		
	}
	
	private void topo(int node,ArrayList<ArrayList<Pair>>  adj, int[] vis, Stack<Integer> uwu )
	{
	    vis[node]=1;
	    
	    for(Pair i: adj.get(node))
	    {
	        int v=i.first;
	        if(vis[v]==0)
	        topo(v,adj,vis,uwu);
	    }
	    
	    uwu.add(node);
	}
}
