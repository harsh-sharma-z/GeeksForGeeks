//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
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

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long largesSumCycle(int n, int edge[]){
        int count[]=new int[n];
        for(int i:edge)
        {
            if(i==-1)
            continue;
            count[i]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[n];
        Arrays.fill(vis,false);
        for(int i=0;i<n;i++)
        {
            if(count[i]==0)
            {
                vis[i]=true;
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr=q.remove();
            int par=edge[curr];
            if(par==-1)
            continue;
            --count[par];
            if(count[par]==0)
            {
                q.add(par);
                vis[par]=true;
            }
        }
        int res=-1;
        for(int i=0;i<n;i++)
        {
            if(vis[i]) continue;
            int val=0;
            for(int st=i;vis[st]==false;st=edge[st])
            {
                val+=st;
                vis[st]=true;
            }
            res=Math.max(res,val);
        }
        return res;
    }
}
