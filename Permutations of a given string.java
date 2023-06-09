//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        List<String> ans=new ArrayList<>();;
        Set<String> uwu=new HashSet<>();
        permutation(S,0,"",uwu);
        ans.addAll(uwu);
        Collections.sort(ans);
        return ans;
    }
    private void permutation(String s, int idx, String p, Set<String> uwu)
    {
        if(s.length()==0)
        {
            uwu.add(p);
            return;
        }
        
        for(int i=0;i<s.length();i++)
        {
            char cur=s.charAt(i);
            String newString=s.substring(0,i)+s.substring(i+1);
            permutation(newString,idx+1,p+cur,uwu);
        }
    }
}
