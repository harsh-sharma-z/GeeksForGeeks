//{ Driver Code Starts
//Initial Template for Java
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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    static int mod=1000000007;
    static int numOfWays(int n, int x)
    {
        // code here
        ArrayList<Integer> num=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            int curr=(int)Math.pow(i,x);
            if(curr<=n)
            num.add(curr);
            else
            break;
        }
        int dp[][]=new int[n+1][n+1];
        for(int a[]:dp)
        Arrays.fill(a,-1);
        return help(num,0,n,num.size(),dp);
    }
    static int help(ArrayList<Integer> num, int i, int n, int size,int[][] dp)
    {
        if(n<0)
        return 0;
        if(i==size)
        {
            if(n==0)
            return dp[i][n]=1;
            else
            return dp[i][n]=0;
        }
        if(dp[i][n]!=-1)
        return dp[i][n];
        return dp[i][n]=((help(num,i+1,n,size,dp)%mod)+(help(num,i+1,n-num.get(i),size,dp)%mod))%mod;
    }
}
