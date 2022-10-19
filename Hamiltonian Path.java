//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 

    { 

        Set<Integer> set = new HashSet<>();

        Map<Integer,List<Integer>> m = new HashMap<>();

        for(int i = 0 ;i < Edges.size();i++){

            int source = Edges.get(i).get(0);

            int destination = Edges.get(i).get(1);

            m.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);

            m.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);

        }

        for(int i = 1 ; i <= N ; i++){

            if(dfsUtil(i,m,set,N)){

                return true;

            }   

        }

        return false;

    }

    

    private boolean dfsUtil(int source,Map<Integer,List<Integer>> m,Set<Integer> set,int totalVertices){

        set.add(source);

        if(set.size() == totalVertices){

            return true;

        }

        List<Integer> adj = m.get(source);

        for(int destination:adj){

            if(!set.contains(destination) && dfsUtil(destination,m,set,totalVertices)){

                return true;

            }

        }

        set.remove(source);

        return false;    

    }
} 
