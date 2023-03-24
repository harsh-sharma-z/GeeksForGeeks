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
            String ans = ob.removeReverse(S); 
            System.out.println(ans);
        }
    } 
} 

// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    String removeReverse(String s) 
    { 
        // code here
        HashMap<Character, Integer> uwu=new HashMap<>();
        int i=0, j=s.length()-1;
        boolean rev=false;
        HashSet<Integer> del=new HashSet<>();
        for(char ch: s.toCharArray())
        uwu.put(ch,uwu.getOrDefault(ch,0)+1);
        while(i<j)
        {
            char aage=s.charAt(i);
            char peeche= s.charAt(j);
            if(!rev)
            {
                if(uwu.get(aage)>1){
                    uwu.put(aage,uwu.get(aage)-1);
                    del.add(i);
                      rev=!rev;
                }
                i++;
            }
            else
            {
                if(uwu.get(peeche)>1)
                {
                    uwu.put(peeche,uwu.get(peeche)-1);
                    del.add(j);
                      rev=!rev;
                }
                j--;
            }
        }
        StringBuilder ans= new StringBuilder();
        for(i=0;i<s.length();i++)
            if(!del.contains(i))
            ans.append(s.charAt(i));
            if(rev)
            return ans.reverse().toString();
            return ans.toString();
    }
} 

//{ Driver Code Starts.

// } Driver Code Ends
