//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.makePalindrome(n, arr);
            
            String _result_val = (res) ? "YES" : "NO";
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    private static boolean palindrome(String str)
    {
        int low=0,high=str.length()-1;
        while(low<high)
            if(str.charAt(low++)!=str.charAt(high--))
            return false;
        return true;
    }
    public static boolean makePalindrome(int n, String[] arr) {
        // code here
        HashMap<String,Integer> uwu=new HashMap<>();
        HashMap<String, Integer> palin=new HashMap<>();
        
        for(String s:arr)
        uwu.put(s,uwu.getOrDefault(s,0)+1);
        
        int c=0;
        
        for(String s:arr)
        {
            if(!palindrome(s))
            {
                String rev=new StringBuffer(s).reverse().toString();
                if(!uwu.get(s).equals(uwu.get(rev)))
                return false;
            }
            else
            palin.put(s,palin.getOrDefault(s,0)+1);
        }
        for(var freq:palin.values())
        if(freq%2==1)
        c++;
        
        return c<=1;
    }
}
        
