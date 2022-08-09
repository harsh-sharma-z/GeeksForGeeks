//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    static boolean isprime(long N){
       if(N<2){
           return false;
       }
       for(long i=2 ;i<=Math.sqrt(N) ;i++){
           if(N%i==0){
               return false;
           }
       }
       return true;
   }
   static long nineDivisors(long N){
        //Code Here
        if(N<36){
            return 0;
        }
        ArrayList<Long> prime =new ArrayList<>();
        for(long i=2;i<=Math.sqrt(N);i++){
            if(isprime(i))
                prime.add(i);
        }
        int n=prime.size(), count=0;
        for(int i=0 ;i<n;i++){
            long x=prime.get(i);
            if((Math.pow(x,8)<=N)){
                count++;
            }
            else{
                break;
            }
        }
        for(int i=0 ;i<n;i++){
            long x=prime.get(i);
            boolean flag=true;
            for(int j=i+1;j<n;j++){
                long y=prime.get(j);
                if((x*x*y*y)<=N){
                    flag=false;
                    count++;
                }
                else{
                    break;
                }
            }
            if(flag==true){
                break;
            }
        }
        return count;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.nineDivisors(N));
        }
    }
}
// } Driver Code Ends
