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
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> uwu=new ArrayList<>();
        help(0,uwu,0,arr,N);
        Collections.sort(uwu);
        return uwu;
    }
    void help(int ind,ArrayList<Integer> uwu,int sum, ArrayList<Integer> arr,int n)
    {
        if(ind==n)
        {
            uwu.add(sum);
            return;
        }
        help(ind+1,uwu,sum+arr.get(ind),arr,n);
        help(ind+1,uwu,sum,arr,n);
    }
}
