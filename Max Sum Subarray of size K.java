//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int k , ArrayList<Integer> arr , int n){
        // code here
        if(k > n)
            return -1;
            
        long currSum = 0 , maxSum = 0;
        
        for(int i = 0 ; i < k ; i++)
            currSum += arr.get(i);
        
        maxSum  = currSum;
        
        for(int i = k ; i < n ; i++){
            currSum = currSum - arr.get(i - k) + arr.get(i);
            maxSum = Math.max(maxSum , currSum);
        }
        
        return maxSum;
    }
}
