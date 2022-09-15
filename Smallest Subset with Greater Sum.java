//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.Collections;


class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int N = sc.nextInt();
            int[] Arr = new int[N];
            for (int i = 0; i < N; ++i){
                Arr[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            int ans = ob.minSubset(Arr,N);
            System.out.println(ans);
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution { 
    int minSubset(int[] a,int N) { 
        long sum=0;

        for(int i=0;i<N;i++){

            sum+=a[i];

        }

        Arrays.sort(a);

        long t=0;

        int ans=0;

        for(int i=N-1;i>=0;i--){

            t+=a[i];

            sum-=a[i];

            ans+=1;

            if(sum<t) return ans; 

        }

        return ans;
    }
}
