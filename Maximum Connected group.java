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
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    static class DisjointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();

    List<Integer> size=new ArrayList<>();

    public DisjointSet(int n)
    {
        for(int i=0;i<=n;i++)
        {
            rank.add(0);
            parent.add(i); // sab apne parent
            size.add(1);//sabka size 1
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

    public void unionBySize(int u , int v) {
        int ult_u = findPar(u);
        int ult_v = findPar(v);
        if (ult_v == ult_u) // agar dono ke papa same hai to kuch nhi karne ka
            return;

        if(size.get(ult_u)<size.get(ult_v)) //jo chhota hai usko bade mein add kardo
        {
            parent.set(ult_u,ult_v);
            size.set(ult_v,size.get(ult_v)+size.get(ult_u));
        }
        else {
            parent.set(ult_v,ult_u);
            size.set(ult_u,size.get(ult_u)+size.get(ult_v));
        }
    }
}



    
    public int MaxConnection(int grid[][]) {
        //Your code here
        int n=grid.length;
        DisjointSet  ds= new DisjointSet(n*n);
        
        for(int row=0;row<n;row++)
        {
            for(int col=0;col<n;col++)
            {
                if(grid[row][col]==0)
                continue;
                
                int dr[]={-1,0,1,0};
                int dc[]={0,1,0,-1};
                
                for(int i=0;i<4;i++)
                {
                    int adjr=row+dr[i];
                    int adjc=col+dc[i];
                    
                    if(adjc>=0 && adjc<n && adjr>=0 && adjr<n && grid[adjr][adjc]==1)
                    {
                        int u=row*n+col;
                        int v=adjr*n+adjc;
                        ds.unionBySize(u,v);
                        
                        
                    }
                }
            }
        }
        
        int max=0;
        
        for(int row=0;row<n;row++)
        {
            for(int col=0;col<n;col++)
            {
                
                if(grid[row][col]==1)
                {
                    continue;
                }
                
                HashSet<Integer> uwu=new HashSet<>();
                int dr[]={-1,0,1,0};
                int dc[]={0,1,0,-1};
                
                for(int i=0;i<4;i++)
                {
                    int adjr=row+dr[i];
                    int adjc=col+dc[i];
                    
                    if(adjc>=0 && adjc<n && adjr>=0 && adjr<n && grid[adjr][adjc]==1)
                    {
                        uwu.add(ds.findPar(adjr*n+adjc));       
                    }
                }
                
                int total=0;
                
                
                for(Integer a: uwu)
                {
                    total+=ds.size.get(a);
                }
                
                max=Math.max(max, total+1);
                
            }
        }
        
        for(int i=0;i<n*n;i++)
        {
            max=Math.max(max,ds.size.get(ds.findPar(i)));
        }
        
        return max;
        
    }
    
}
