class Solution {

    class pair{

        int parent,value;

        pair(int p,int v){

            parent=p;

            value=v;

        }

    }

    long max=Long.MIN_VALUE;

    void dfs(int v,int val,HashMap<Integer,ArrayList<pair>> adj,int[] vis,int sum,int level){

        vis[v]=1;

        //System.out.println(sum);

        if(adj.get(v)==null){

            max=Math.max(max,sum);

            max=Math.max(max,val);

            return;

        }

        for(pair i:adj.get(v)){

            if(vis[i.parent]==0){

                dfs(i.parent,i.value,adj,vis,sum+i.value*(int)Math.pow(-1,level-1),level+1);

            }

        }

    }

    public long bestNode(int N, int[] A, int[] P) {

          HashMap<Integer,ArrayList<pair>> adj= new HashMap<>();

          for(int i=0;i<P.length;i++){

              if(adj.containsKey(P[i])){

                  adj.get(P[i]).add(new pair(i+1,A[i]));

              }

              else{

              adj.put(P[i],new ArrayList<>());

              adj.get(P[i]).add(new pair(i+1,A[i]));

              }

          }

          for(int i=1;i<=P.length;i++){

              int vis[]= new int[P.length+1];

              dfs(i,A[i-1],adj,vis,A[i-1],0);

              //System.out.println(max);

          }

          

          return max;

    }

}
