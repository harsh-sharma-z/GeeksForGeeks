//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
        
        Integer nextInt(){
            return Integer.parseInt(next());
        }
    } 
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t>0)
        {
            int R = sc.nextInt();
            int C = sc.nextInt();
            
            char mat[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            String target  = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findOccurrence(mat,target));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{int ans=0;
    public int findOccurrence(char mat[][], String target)
    {
        // Write your code here
         int visited[][]=new int[mat.length][mat[0].length];
       int cnt=0;
       for(int i=0;i<mat.length;i++)
       {
           for(int j=0;j<mat[0].length;j++)
           {
               if(mat[i][j]==target.charAt(0))
               {
                   dfs(i,j,mat,target,visited,0);
                  // System.out.println(cnt);
               }
           }
       }
       return ans;
    }
     public void dfs(int i,int j,char mat[][],String target,int visited[][],int idx)
   {
    
    if(i>=mat.length||j>=mat[0].length||i<0||j<0||visited[i][j]==1||
    idx>=target.length()||mat[i][j]!=target.charAt(idx))
       return;
       
    if(idx==target.length()-1)
       {
           ans++;
           return;
       }
       
       
     visited[i][j]=1;
     String sub=target;
           dfs(i+1,j,mat,sub,visited,idx+1);
           dfs(i-1,j,mat,sub,visited,idx+1);
           dfs(i,j+1,mat,sub,visited,idx+1);
           dfs(i,j-1,mat,sub,visited,idx+1);
       visited[i][j]=0;
    
   }
}
