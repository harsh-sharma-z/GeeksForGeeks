//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static class Pair{
        int node;
        int distance;
        public Pair(int distance, int node)
        {
            this.distance=distance;
            this.node=node;
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
	    
	    for(int i=0;i<V;i++)
	    {
	        adj.add(new ArrayList<Pair>());
	    }
	    
	    for(int i[]: edges)
	    {
	        int u=i[0];
	        int v=i[1];
	        int d=i[2];
	        adj.get(u).add(new Pair(d,v));
	        adj.get(v).add(new Pair(d,u));
	    }
	    PriorityQueue<Pair> uwu = new PriorityQueue<>((x,y)-> x.distance-y.distance);
	    int[] vis=new int[V];
	    uwu.add(new Pair(0,0));
	    int sum=0;
	   // vis[0]=1;
	    
	    while(!uwu.isEmpty())
	    {
	        int dis=uwu.peek().distance;
	        int node=uwu.peek().node;
	        uwu.poll();
	        if(vis[node]==1)
	        {
	            continue;
	        }
	        
	        sum+=dis;
	        vis[node]=1;
	        
	        for(Pair i: adj.get(node))
	        {
	            int newdis=i.distance;
	            int newnode=i.node;
	            if(vis[newnode]==0)
	            {
	                uwu.add(new Pair(newdis,newnode));
	            }
	        }
	    }
	    return sum;
	}
}












//_____________________________________________________________________________________________________________________________________________
//			KRUSKAL'S ALGO SOLUTION (DISJOINT SET)

class DisjointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    public DisjointSet(int n)
    {
        for(int i=0;i<=n;i++)
        {
            rank.add(0);
            parent.add(i); // sab apne parent
        }
    }

    public int findPar(int node)
    {
        if(node==parent.get(node)) //agar vo khudka parent hai
            return node;
        int ultpar=findPar(parent.get(node)); //recursively ultimate boss find karo
        parent.set(node,ultpar); // lage haath parent update kardo rast evalo ke bhi
        return parent.get(node); // return kardo updated list ki parent value
    }

    public void unionByRank(int u , int v)
    {
        int ult_u=findPar(u);
        int ult_v=findPar(v);
        if(ult_v==ult_u) // agar dono ke papa same hai to kuch nhi karne ka
            return ;
        if(rank.get(ult_u)<rank.get(ult_v)) // u chhota h v se attach
        {
            parent.set(ult_u,ult_v);
        }
        else if(rank.get(ult_v)<rank.get(ult_u)) // v chhota hai to u se attach
        {
            parent.set(ult_v,ult_u);
        }
        else {  // varna koi bhi kisi se bhi attach but rank badhana padega
            parent.set(ult_u,ult_v);
            int rankU=rank.get(ult_u);
            rank.set(ult_u,rankU+1);
        }
    }
}
class Edge implements Comparable<Edge>{
    int src, dest, w;
    public Edge(int src, int dest, int w)
    {
        this.src=src;
        this.dest=dest;
        this.w=w;
    }
    public int compareTo(Edge compareEdge)
    {
        return this.w-compareEdge.w;
    }
};
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    List<Edge> uwu=new ArrayList<>();
	    for(int[] i :edges)
	    {
	        int u=i[0];
	        int v=i[1];
	        int cost=i[2];
	        Edge temp= new Edge(u,v,cost);
	        uwu.add(temp);
	    }
	    DisjointSet ds=new DisjointSet(V);
	    Collections.sort(uwu);
	    int ans=0;
	    for(Edge e: uwu)
	    {
	        int w=e.w;
	        int u=e.src;
	        int v=e.dest;
	        
	        if(ds.findPar(u)!=ds.findPar(v))
	        {
	            ans+=w;
	            ds.unionByRank(u,v);
	        }
	    }
	    return ans;
	}
}
