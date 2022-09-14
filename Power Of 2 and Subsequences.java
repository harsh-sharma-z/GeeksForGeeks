//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            ArrayList<Long> A = new ArrayList<Long>();
            String in[] = read.readLine().trim().split(" ");
            for(var i : in){
                Long x = Long.parseLong(i);
                A.add(x);
            }

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(N,A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static Long numberOfSubsequences(int N, ArrayList<Long> A){
        // code here
        int c=0;
        long mod=1000000007;
        for(Long i:A)
            if((i&(i-1))==0)
            c++;
        return (long)(Math.pow(2,c)%mod-1)%mod;
    }
}
