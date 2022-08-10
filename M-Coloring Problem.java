class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    private boolean dfs(Map<Integer,ArrayList<Integer>> map,int currentNode,int[] color,int n,int m){
        if(currentNode == n) {
            return true;
        }
        
        // Check for every color
        for(int currentColor = 1 ; currentColor <= m ; currentColor++) {
            if(safe(currentNode,currentColor,map,color)) {
                color[currentNode] = currentColor;
                
                // Check for the remaining vertices
                if(dfs(map,currentNode + 1,color,n,m)) {
                    return true;
                }
                
                // Backtrace if solution not possible
                color[currentNode] = 0;
            }
        }
        
        return false;
    }
    
    private boolean safe(int currentNode,int currentColor,Map<Integer,ArrayList<Integer>> map,int[] color){
        ArrayList<Integer> arr = map.get(currentNode);
        
        // Check if any neighbour has the current color
        for(int neighbours : arr) {
            if(color[neighbours] == currentColor) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        
        for(int i = 0 ; i < n ; i++) {
            map.put(i,new ArrayList<>());
            for(int j = 0 ; j < n ; j++) {
                if(graph[i][j]) {
                    map.get(i).add(j);
                }
            }
        }
        
        int[] color = new int[n];
        return dfs(map,0,color,n,m);
    }
}
