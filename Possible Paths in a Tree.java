//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());

            int edges[][] = new int[n-1][3];
            for(int i = 0; i < (n-1); i++){
                String input_line[] = read.readLine().trim().split("\\s+");
                for(int j = 0; j < 3; j++){
                    edges[i][j] = Integer.parseInt(input_line[j]);
                }
            } 
            
            int q = Integer.parseInt(read.readLine());

            String input_line[] = read.readLine().trim().split("\\s+");
            int queries[]= new int[q];
            for(int i = 0; i < q; i++)
                queries[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.maximumWeight(n, edges, q, queries); 
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class DSU{
    
    int parent[], size[];
    
    DSU(int n){
        
        parent = new int[n + 1];
        size = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    int find(int x){
        
        if(parent[x] == x){
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    int union(int a, int b){
        
        int root_a = find(a);
        int root_b = find(b);
        
        int res = size[root_a] * size[root_b];
        
        if(root_a == root_b){
            return res;
        }
        
        
        if(size[root_a] < size[root_b]){
            
            parent[root_a] = root_b;
            size[root_b] += size[root_a];
            
        }else{
            
            parent[root_b] = root_a;
            size[root_a] += size[root_b];
            
        }
        
        return res;
    }
}

class Solution { 
    ArrayList<Integer> maximumWeight(int n, int edges[][], int q, int queries[]) {
        
        DSU dsu = new DSU(n);
        
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int prevPaths = 0;
        
        for(int[] edge: edges){
            
            int union = dsu.union(edge[0], edge[1]);
            int paths = prevPaths + union;
            
            map.put(edge[2], paths); 
            prevPaths = paths;
            
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < q; i++){
            
            int maxPaths = 0;
            Map.Entry<Integer, Integer> val = map.floorEntry(queries[i]);
            
            if(val == null) ans.add(0);
            else ans.add(val.getValue());
        }
        
        return ans;    
    }
}
