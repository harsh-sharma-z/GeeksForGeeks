class Solution {
    int count = 0;
    
    public int minimumEdgeRemove(int n, int[][] edges) {
        
        int visited[] = new int[n + 1];
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        dfs(adj, visited, 1);
        
        return count;
    }
    
    public int dfs(ArrayList<ArrayList<Integer>> adj, int visited[], int u){
        
        visited[u] = 1;
        int size = 1;
        
        for(int v: adj.get(u)){
            
            if(visited[v] == 0){
                int sizeNeighbour = dfs(adj, visited, v);
                size += sizeNeighbour;
                
                if((sizeNeighbour % 2) == 0){
                    count++;
                }
            }
            
        }
        
        return size;
    }
}
