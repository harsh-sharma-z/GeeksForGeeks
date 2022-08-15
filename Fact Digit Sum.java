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
            String s = br.readLine().trim();
            int N = Integer.parseInt(s);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.FactDigit(N);
            for (Integer val: ans) 
                System.out.print(val);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> FactDigit(int x)
    {
        // code here
        int fact[]={1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    ArrayList<Integer> ans=new ArrayList<Integer>();
if(x==1 || x==2){
ans.add(x);
return ans;
}
while (x > 0) {
int i = 0;
while (i<fact.length) 
{
    if(fact[i]> x) 
    {
        break;
    }
    i++;
}
x -= fact[i-1];
ans.add(i-1);
}
Collections.sort(ans);
return ans;
    }
}
