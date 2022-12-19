//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
 class Pair{
        int node;
        int weight;
        Pair(int n,int w){
            node=n;
            weight=w;
        }
    }
    int minimumCost(int[][] flights, int n, int k) {
        // Your code here
        Map<Integer,ArrayList<Pair>> map=new HashMap<>();
        for(int[]i:flights){
            int u=i[0];
            int v=i[1];
            int w=i[2];
            map.putIfAbsent(u,new ArrayList<>());
            map.get(u).add(new Pair(v,w));
        }                    
        
        int[]dis=new int[n+1];
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(k,dis[k]));
        
        while(!q.isEmpty()){
            Pair curr=q.remove();
            int node=curr.node;
            int cost=curr.weight;
            if(!map.containsKey(node))continue;
            for(Pair p:map.get(node)){
                int neb=p.node;
                int nebCost=p.weight;
                if((dis[neb]==0 || dis[neb]>cost+nebCost) && neb!=k){
                    dis[neb]=cost+nebCost;
                    q.add(new Pair(neb,dis[neb]));
                }
            }
        }
        
        for(int i=1;i<dis.length;i++){
            if(dis[i]!=0){
                ans=Math.max(ans,dis[i]);
            }else if(i!=k){
                return -1;
            }
        }
        return ans;
    }
}
