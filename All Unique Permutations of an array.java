//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static void unique(ArrayList<Integer> ds,ArrayList<Integer> arr,HashSet<ArrayList<Integer>> set,boolean feq[]){
        if(ds.size()==arr.size()){
            set.add(new ArrayList<>(ds));
            // System.out.println(ds);
            return;
        }
        for(int i=0;i<arr.size();i++){
            if(!feq[i]){
                feq[i]=true;
                ds.add(arr.get(i));
                unique(ds,arr,set,feq);
                ds.remove(ds.size()-1);
                feq[i]=false;
                
            }
        }
    }
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        Collections.sort(arr);
        ArrayList<Integer> ds=new ArrayList<>();
        HashSet<ArrayList<Integer>> set=new LinkedHashSet<>();
        boolean feq[]=new boolean[n];
        unique(ds,arr,set,feq);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(ArrayList<Integer> a:set){
            ans.add(new ArrayList<>(a));
        }
        return ans;
    }
};
