//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    
       public void CountNumberOfIslands(int row, int col, int [][] visited, int [][] dp, int n, int m){

 

        visited[row][col] = 1;

 

        int[] Rows = new int[]{-1, 0 , 1, 0};

 

        int[] Cols = new int[]{0, 1, 0, -1};

 

        int NRow = 0, NCol =0;

 

        for(int i=0; i<4; i++){

 

            NRow = Rows[i] + row;

 

            NCol = Cols[i] + col;

 

            // System.out.println("NRow and NCol is "+ NRow + " "+ NCol);

 

            if(NRow >= 0 && NRow< n && NCol >= 0 && NCol < m && visited[NRow][NCol] == 0 && dp[NRow][NCol] == 1){

 

                CountNumberOfIslands(NRow, NCol, visited, dp, n, m);

 

            }

 

        }

 

    }

 

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {

 

        

 

        

 

        int [][] visited = new int[rows][cols];

 

        int [][] dp= new int[rows][cols];

 

        List<Integer> list= new ArrayList<>();

 

        int count=0;

 

        for(int i=0; i<operators.length; i++){

 

            dp[operators[i][0]][operators[i][1]] = 1;

 

            count=0;

 

            for(int j=0; j< rows ; j++){

 

                for(int k= 0; k<cols ; k++){

 

                    

 

                    if(visited[j][k] == 0 && dp[j][k] == 1){

 

                        CountNumberOfIslands(j, k, visited, dp, rows, cols );

 

                        count++;

 

                    }

 

                }

 

            }

 

            for(int j=0; j< rows ; j++){

 

                for(int k= 0; k<cols ; k++){

 

                    visited[j][k] = 0;

 

                }

 

            }

 

            list.add(count);

 

        }

 

 

 

        return list;

 

    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends
















//_________________________________________________________________________________________________________________________________________________


//                                          DSU based approach




//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

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


    
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        //Your code here
        
        DisjointSet ds=new DisjointSet(n*m);
        
        int[][] vis=new int[n][m];
        
        
        int cnt=0;
        
        List<Integer> ans =new ArrayList<>();
        
        
        for(int []i:operators)
        {
            int row=i[0];
            int col=i[1];
            if(vis[row][col]==1)
            {
            ans.add(cnt);
            continue;
            }
        
            vis[row][col]=1;
        
            cnt++;
        
        
            int dr[]={-1,0,1,0};
            int dc[]={0,1,0,-1};
        
            for(int ind=0;ind<4;ind++)
            {
                int adjr=row+dr[ind];
                int adjc=col+dc[ind];
                
                if(adjr<n && adjr>=0 && adjc<m && adjc>=0)
                {
                    if(vis[adjr][adjc]==1)
                    {
                        int u=row*m+col;
                        int v=adjr*m+adjc;
                        if(ds.findPar(u)!=ds.findPar(v))
                        {
                            cnt--;
                            ds.unionBySize(u,v);
                        }
                    }
                }
            }
            
            ans.add(cnt);
        }
        
        return ans;
    }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends
