//{ Driver Code Starts
// Initial Template for Java

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
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findNumberOfGoodComponent(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         int ans=0;
        int vis[]=new int[V+1];
        
        for(int i=1;i<V+1;i++){
            if(vis[i]==0){
                boolean temp[]=new boolean[1];
                temp[0]=true;
                int vcount[]=new int[1];
                
                helper(i,adj,vis,temp,adj.get(i).size(),vcount);
                
                //System.out.println(adj.get(i).size()+" "+vcount[0]+" "+temp[0]);
                if(temp[0]==true && vcount[0] == adj.get(i).size()+1)
                    ans++;
            }
        }
        return ans;
    }
    public void helper(int curr, ArrayList<ArrayList<Integer>> adj, int vis[],boolean temp[],int size,int vcount[]){
        vis[curr]=1;
        vcount[0]++;
        if(size != adj.get(curr).size())
            temp[0]=false;  
        //System.out.println(curr);
        for(int neg : adj.get(curr)){
            if(vis[neg]==0){
                vis[neg]=1;
                helper(neg,adj,vis,temp,size,vcount);
            }
        }
    }
}
