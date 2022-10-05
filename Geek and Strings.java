//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String li[] = new String[N];
            for(int i=0; i<N; i++)
                li[i] = in.readLine();
            int Q = Integer.parseInt(in.readLine());
            String query[] = new String[Q];
            for(int i=0; i<Q; i++)
                query[i] = in.readLine();
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.prefixCount(N, Q, li, query);
            for(int i = 0;i < ans.size();i++)
                System.out.println(ans.get(i));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> prefixCount(int N, int Q, String li[], String query[])
    {
        // code here
        List<Integer> ans =new ArrayList<>();
        HashMap<String,Integer> map =new HashMap<>();
        for(String i : li){
            String s="";
            for(int j=0;j<i.length();j++){
                s+=i.charAt(j);
                map.put(s , map.getOrDefault(s,0)+1);
            }
        }
        for(String i : query){
            ans.add(map.getOrDefault(i ,0 ));
        }
        return ans;
    }
}
