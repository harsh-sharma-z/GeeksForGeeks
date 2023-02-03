//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
        out.close();
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    static int [] endPoints(int [][]arr, int m, int n){
        //code here
        int i=0,j=0,inci=0,incj=1;
        while(i<m && j<n && i>=0 && j>=0)
        {
            if(arr[i][j]==1)
            {
                arr[i][j]=0;
                if(inci==-1)
                {
                    inci=0;
                    incj=1;
                }
                else
                if(incj==1)
                {
                    incj=0;
                    inci=1;
                }
                else
                if(inci==1)
                {
                    inci=0;
                    incj=-1;
                }
                else
                if(incj==-1)
                {
                    inci=-1;
                    incj=0;
                }
            }
            i+=inci;
            j+=incj;
        }
        int ans[]={(i+(-1*inci)),(j+(-1*incj))};
        return ans;
    }
}
