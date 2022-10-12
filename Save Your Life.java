//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String maxSum(String w,char x[],int b[], int n){
        //code here
        HashMap<Character,Integer> uwu=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            uwu.put(x[i],b[i]);
        }
        
        StringBuilder temp=new StringBuilder();
        StringBuilder ans=new StringBuilder();
        
        
        int max=Integer.MIN_VALUE;
        int curr=0;
        for(char c:w.toCharArray())
        {
            curr+=uwu.containsKey(c)?uwu.get(c):c;
            temp.append(c);
            
            
            if(curr>max)
            {
                  max=curr;
                  ans=new StringBuilder(temp);
            }
          
            
            
            if(curr<0)
            {
                curr=0;
                temp=new StringBuilder();
            }
        }
        
        return ans.toString();
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends
