//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    ArrayList<String> ans = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    public ArrayList<String> findPermutation(String s) {
        // Code here
        boolean arr[] = new boolean[s.length()];
        fun("",s,arr);
        return ans;
        
    }
    public void fun(String sub , String s , boolean[] visited){
        if(sub.length() == s.length()){
            if(!set.contains(sub)){
                set.add(sub);
                ans.add(new String(sub));
                
            }
            return;
        }
        
        
        for(int i = 0; i < s.length(); i++){
            if(visited[i] == false)
            {sub += s.charAt(i);
            visited[i] = true;
            fun(sub,s,visited);
            visited[i] = false;
            sub = sub.substring(0,sub.length()-1);}
            
        }
    }
}
