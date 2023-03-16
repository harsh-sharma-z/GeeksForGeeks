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
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.secondSmallest(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String secondSmallest(int s, int D){
        // code here
        
        if(s>=D*9)
        return "-1";
        s--;
        char arr[]=new char[D];
        for(int i=D-1;i>0;i--)
        {
            if(s>9)
            {
                arr[i]=(char)(9+'0');
                s-=9;
            }
            else
            {
                arr[i]=(char)(s+'0');
                s=0;
            }
        }
        
        arr[0]=(char)(1+s+'0');
        
        int idx=D-1;
        
        for(int i=D-1;i>=0;i--)
        {
            if(arr[i]=='9')
            idx=i;
            else
            break;
        }
        
        arr[idx]--;
        arr[idx-1]++;
        
        return String.valueOf(arr);
    }
}
