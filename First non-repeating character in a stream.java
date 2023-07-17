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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        int[] freq = new int[26];
        
        Queue<Character> uwu = new LinkedList<>();
        
        StringBuilder res = new StringBuilder();
        
        for(char ch : A.toCharArray()){
            freq[ch - 'a'] ++;
            
            if(freq[ch - 'a'] == 1)
                uwu.offer(ch);
                
            while(!uwu.isEmpty() && freq[uwu.peek() - 'a'] > 1)
                uwu.poll();
                
            if(uwu.isEmpty())
                res.append('#');
            else
                res.append(uwu.peek());
                
        }
        
        return res.toString();
        
        
    }
}
