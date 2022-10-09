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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.NthTerm(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int NthTerm(int n)

    {

 if(n == 1 ) {

 return 1;

 }

 int minDiff =  Integer.MAX_VALUE;

 boolean visitedLower = false;

 boolean visitedHigher = false;

 for(int i = n,j = n+1;i>1;i--,j++) {

 if(isPrime(i)) {

 visitedLower = true;

 minDiff = Math.min(minDiff, Math.abs(n-i));

 }

 if(isPrime(j)) {

 visitedHigher = true;

 minDiff = Math.min(minDiff, Math.abs(n-j));

 }

 if(visitedLower && visitedHigher) {

 return minDiff;

 }

 }

 return -1;

    }

    private static boolean isPrime(int n) {

 if(n == 1 || n == 2) {

 return true;

 }

 for(int i = 2;i<=Math.sqrt(n);i++) {

 if(n%i == 0) {

 return false;

 }

 }

 return true;

 }
}
