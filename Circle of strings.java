//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void dfs(int i, List<List<Integer>> graph, boolean[] visit) {
        visit[i] = true;
        for(int idx: graph.get(i))
            if(visit[idx] != true)
                dfs(idx,graph,visit);
    }

    public int isCircle(String arr[]) {
        
        int in[] = new int[26];
        int out[] = new int[26];
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<26; i++) adj.add(new ArrayList<>());
         
        for(String s: arr) {
            int n = s.length();
            in[s.charAt(0) - 'a']++;
            out[s.charAt(n-1)-'a']++;
            adj.get(s.charAt(0)-'a').add(s.charAt(n-1)-'a');
        }
        for(int i=0; i<26; i++) {
            if(in[i] != out[i]) return 0;
        }
        boolean visit[] = new boolean[26];
        
        dfs(arr[0].charAt(0)-'a',adj,visit);
        
        for(int i=0; i<26; i++) {
            if(in[i] > 0 && visit[i] != true)
                return 0;
        }
       
       return 1;
    }
}
