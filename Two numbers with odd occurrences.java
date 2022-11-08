//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int arr[], int N)
    {
        // code here
        int xor=0;
        for(int i:arr){
            xor^=i;
        }
        int setBit=0;
        for(int i=0;i<32;i++){
            int curr= 1<<i;
            if((xor&curr)!=0){
                setBit=curr;
                break;
            }
        }
        int first=0;
        int second=0;
        for(int i=0;i<N;i++){
            if((arr[i]&setBit)!=0){
                first^=arr[i];
            }else{
                second^=arr[i];
            }
        }
        int[]ans=new int[2];
        if(first<second){
            ans[0]=second;
            ans[1]=first;
        }else{
            ans[0]=first;
            ans[1]=second;
        }
        return ans;
    }
}
