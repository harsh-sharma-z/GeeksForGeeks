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
            String[] S = br.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int ans = ob.Count(L, R);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int Count(int L, int R)
    {
        // code here
        int primes=0;
        int comp=0;
        boolean[]prime=new boolean[R+1];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i<=R;i++){
            if(prime[i]){
                for(int j=2*i;j<=R;j+=i){
                    prime[j]=false;
                }    
            }
        }
        
        for(int i=L;i<=R;i++){
            if(prime[i]){
                primes++;
            }else{
                comp++;
            }
        }
        if(L==1){
            comp--;
        }
        return comp-primes;
    }
}
