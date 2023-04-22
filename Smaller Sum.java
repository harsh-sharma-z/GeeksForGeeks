//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long[] smallerSum(int n,int arr[])
    {
        int[] copy=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        copy[i]=arr[i];
        Arrays.sort(copy);
        // for(int i:copy)
        // System.out.print(i+" ");
        HashMap<Integer,Long> uwu=new HashMap<>();
        uwu.put(copy[0],(long)0);
        long prefix=copy[0];
        for(int i=1;i<copy.length;i++)
        {
            if(copy[i]==copy[i-1])
            {
                uwu.put(copy[i],uwu.get(copy[i-1]));
            }
            else
            {
                uwu.put(copy[i],prefix);
            }
            prefix+=copy[i];
        }
        long[] ans=new long[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            ans[i]=uwu.get(arr[i]);
        }
        return ans;
    }
}
