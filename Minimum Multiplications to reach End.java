//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Pair{
        int steps;
        int node;
        public Pair (int steps, int node){
            this.steps=steps;
            this.node=node;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        Queue<Pair> uwu=new LinkedList<>();
        
        uwu.add(new Pair(0,start));
        
        int[] dist=new int[100000];
        Arrays.fill(dist,(int)(1e9));
        
        dist[start]=0;
        
        
        while(!uwu.isEmpty())
        {
            int node=uwu.peek().node;
            int steps=uwu.peek().steps;
            uwu.poll();
            for(int i:arr)
            {
                int newnode=node*i;
                newnode%=100000;
                if(dist[newnode]>steps+1)
                {
                    if(newnode==end)
                    return steps+1;
                    
                    uwu.add(new Pair(steps+1, newnode));
                    
                    dist[newnode]=steps+1;
                }
            }
        }
        
        return -1;
        
    }
}
