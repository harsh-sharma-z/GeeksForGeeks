//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Solution {
    class Tuple{
        int node;
        int distance;
        int stops;
        public Tuple(int stops, int node, int distance)
        {
            this.stops=stops;
            this.node=node;
            this.distance=distance;
        }
    }
    
    class Pair{
        int first;
        int second;
        public Pair(int first, int second)
        {
            this.first=first;
             this.second=second;
        }
    }
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<Pair>());
        for(int[] i: flights)
            adj.get(i[0]).add(new Pair(i[1],i[2]));
        Queue<Tuple> uwu=new LinkedList<>();
        
        int[] dist=new int[n];
        Arrays.fill(dist,(int)(1e9));
        dist[src]=0;
        
        uwu.add(new Tuple(0,src,0));
        
        while(!uwu.isEmpty())
        {
            Tuple temp=uwu.poll();
            int stops=temp.stops;
            int node=temp.node;
            int distance=temp.distance;
            
            if(stops>k)
            continue;
            
            for(Pair i:adj.get(node))
            {
                int newnode=i.first;
                int newdis=i.second;
                
                if(distance+newdis<dist[newnode])
                {
                    dist[newnode]=distance+newdis;
                    uwu.add(new Tuple(stops+1, newnode, distance+newdis));
                }
            }
        }
        
        if(dist[dst]==(int)(1e9))
        return -1;
        return dist[dst];
    }
}
