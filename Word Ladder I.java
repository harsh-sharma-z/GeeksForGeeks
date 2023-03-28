//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    class Pair
    {
        String first;
        int second;
        public Pair(String first, int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Queue<Pair> uwu=new LinkedList<>();
        
        uwu.add(new Pair(startWord, 1));
        
        Set<String> st=new HashSet<>();
        
        for(String w:wordList)
        st.add(w);
        
        st.remove(startWord);
        
        while(!uwu.isEmpty())
        {
            String word=uwu.peek().first;
            int steps=uwu.peek().second;
            uwu.remove();
            
            if(word.equals(targetWord))
            return steps;
            
            for(int i=0;i<word.length();i++)
            {
                for(char c='a'; c<='z';c++)
                {
                    char[] replace= word.toCharArray();
                    replace[i]=c;
                    
                    String rep=new String(replace);
                    
                    if(st.contains(rep))
                    {
                        st.remove(rep);
                        uwu.add(new Pair(rep,steps+1));
                    }
                }
            }
            
            
        }
        
        return 0;
    }
}
