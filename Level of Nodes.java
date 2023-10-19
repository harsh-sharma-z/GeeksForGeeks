//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int v, ArrayList<ArrayList<Integer>> adj, int x)
    {
        // code here
        boolean vis[] = new boolean[v];
        Queue<Integer> uwu =  new LinkedList<>();
        HashMap<Integer , Integer> map = new HashMap<>();
        
        uwu.add(0);
        
        vis[0] = true;
        
        while(!uwu.isEmpty()){
            int node = uwu.poll();
            
            for(int i : adj.get(node)){
                if(!vis[i]){
                    uwu.add(i);
                    vis[i] = true;
                    map.put(i , map.getOrDefault(node , 0) + 1);
                }
            }
            
        }
        
        if(map.containsKey(x))
            return map.get(x);
        return -1;
    }
}
