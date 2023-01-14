//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
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

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();        
        PrintWriter out = new PrintWriter(System.out);
        int testcases = sc.nextInt();

        while (testcases-- > 0) {
            int N = sc.nextInt();
            int A[] = new int[N];
            for(int i = 0; i < N; i++) A[i] = sc.nextInt();
            int Q = sc.nextInt();
            ArrayList<Integer> Queries[] = new ArrayList[Q];
            for(int i = 0; i < Q; i++){
                Queries[i] = new ArrayList<>();
                int x = sc.nextInt(), y = sc.nextInt();
                Queries[i].add(x);
                Queries[i].add(y);
                for(int j = 0; j < Queries[i].get(1); j++){
                    x = sc.nextInt();
                    Queries[i].add(x);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.maximumToys(N, A, Q, Queries);
            for(int x : ans)
                out.print(x + " ");
            out.print("\n");
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Pair<K,V>{
    private K cost;
    private V index;
    public Pair(K a,V b){
        this.cost=a;
        this.index=b;
    }
    public K getCost(){
        return this.cost;
    }
    public V getIndex(){
        return this.index;
    }
}


class Solution {
    ArrayList<Integer> maximumToys(int N, int A[],
    int Q, ArrayList<Integer> Queries[]){
        ArrayList<Pair<Integer,Integer>> arr=new ArrayList<>(N);
        for(int i=0;i<N;i++){
            arr.add(new Pair<Integer,Integer>(A[i],i));
        }

        Collections.sort(arr,(a,b)->a.getCost()-b.getCost());//Nlogn

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++){
            map.put(arr.get(i).getIndex(),i);
        }

        long[]prefix=new long[N+1];
        for(int i=1;i<=N;i++){
            prefix[i]=prefix[i-1]+arr.get(i-1).getCost();
        }

        ArrayList<Integer> res=new ArrayList<>(Q);

        for(int i=0;i<Q;i++){//Q
            long c=Queries[i].get(0);
            int k=Queries[i].get(1);
            int l=0;
            int r=N;
            int ans=0;
            while(l<=r){//logn
                int mid=l + (r-l)/2;
                if(prefix[mid]<=c){
                    ans=mid;
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
            if(ans==0){
                res.add(0);
                continue;
            }
            int idx=ans-1;
            long rem = c-prefix[ans];
            HashSet<Integer> damaged=new HashSet<>();
            for(int j=0;j<k;j++){//k
                int damagedToyIndex=map.get(Queries[i].get(j+2)-1);
                if(damagedToyIndex<=idx){
                    ans--;
                    rem+=arr.get(damagedToyIndex).getCost();
                }else{
                    damaged.add(damagedToyIndex);
                }
            }
            int s=idx+1;
            while(s<N && rem>=arr.get(s).getCost()){
                if(!damaged.contains(s)){
                    ans++;
                    rem-=arr.get(s).getCost();
                }
                s++;
            }
            res.add(ans);
        }
        return res;
    }
}
