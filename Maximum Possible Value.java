//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            input_line = read.readLine().trim().split("\\s+");
            int B[]= new int[N];
            for(int i = 0; i < N; i++)
                B[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.maxPossibleValue(N, A, B); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long maxPossibleValue(int n, int a[] ,int b[]) { 
        // code here
      
        long min=Integer.MAX_VALUE;
        long peri=0;
        long tot=0;
        for(int i=0;i<n;i++)
        {
            if(b[i]%2!=0)
            b[i]--;
            if(b[i]>=2)
                min=Math.min(min,a[i]);
            
            peri+=(a[i]*b[i]);
            tot+=b[i];
            
        }
        if(tot%4!=0)
        peri-=(2*min);
        return peri;
    }
    
} 
