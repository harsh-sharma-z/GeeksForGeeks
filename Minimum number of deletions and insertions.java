//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    //this seems to be based on LCS
	    //1. Find the LCS
	    //2. No. of deletion req = str1.length() - lcs.length()
	    //3. No. of insertion req = str2.lemgth() - lcs.length()
	    int m=str1.length(), n=str2.length();
	    int[][] c= new int[m+1][n+1];
	    for(int i=0;i<=m;i++)
        c[i][0]=0;
        for(int j=0;j<=n;j++)
        c[0][j]=0;
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                c[i][j]=c[i-1][j-1]+1;
                else
                c[i][j]=Math.max(c[i-1][j],c[i][j-1]);
            }
        }
	    int lcsL= c[m][n];
	    return (n-lcsL)+(m-lcsL);
	} 
	
}
