//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countSubarray(N, A, M); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long countSubarray(int N, int A[], int M) 
    { 
       long a = helpFunction(N,A,M);
        long b = helpFunction(N,A,M+1);
        return a-b;
    }
    long helpFunction(int n,int arr[],int m){
        int mm[] = new int[2*n+1];
        Arrays.fill(mm,0);
        long ans=0,currElement=0;
        int sum=n;
        mm[n]++;
        for(int i=0;i<n;i++){
            if(arr[i]<m){
                sum--;
                currElement-=mm[sum];
            }
            else{
                currElement+=mm[sum];
                sum++;
            }
            ans+=currElement;
            mm[sum]++;
        }
        return ans;
    }
} 
