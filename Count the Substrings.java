//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countSubstring(String S) 
    { 
        // code here
        HashMap<Integer,Integer> uwu=new HashMap<>();
        
        uwu.put(0,1);
        int ans=0;
        int sum=0;
        for(char ch: S.toCharArray())
        {
            int val;
            if(Character.isUpperCase(ch))
            val=1;
            else
            val=-1;
            
            sum+=val;
            
            if(uwu.containsKey(sum))
            ans+=uwu.get(sum);
            
            uwu.put(sum,uwu.getOrDefault(sum,0)+1);
        }
        return ans;
    }
} 
