//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<String> ans = ob.pattern(n);
            for(int i = 0;i < n;i++)
                System.out.println(ans.get(i));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<String> pattern(int n){
       
       List<String> ans = new ArrayList<String>();
 
       int c=(n*2);
 int cc=c-1;
 c=c+cc;
 int tt=c/2;
 int left=1;
 int right=(n*(n+1))/2;
 
 for(int i=0;i<n;i++)
 {
  
  int m=n-1-i;
  int rightrow=(m*(m+1))/2;
  int r=right+rightrow+1;
  String s="";
  for(int j=0;j<c;j++)
  { 
  if(j<(2*i))
  {
   s=s+"-";
  }
  else if(j>((2*(tt)-(2*i))))
  {
   
  }
  else
  {
   if(j%2!=0)
   {
     s=s+"*";
   }
   else 
   {
    if(j<tt)
    {
      s=s+Integer.toString(left);
     left++;
    }
    else
    {
      s=s+Integer.toString(r);
     r++;
    }
   }
  }
  }
  ans.add(s);
 }
       return ans;
   }
}
