//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] arr) {
        // code here
         Stack<Integer> st=new Stack<>();
        for(int num:arr){
            if(num<0){
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(num)){
                    st.pop();
                }

                if(!st.isEmpty()){
                    if(st.peek()==Math.abs(num)){
                        st.pop();
                    }else if(st.peek()<0){
                        st.push(num);
                    }
                }else if(st.isEmpty()){
                    st.push(num);
                }
            }else{
                st.push(num);
            }
        }
        int[] ans =new int[st.size()];
        int i=st.size()-1;
        while(st.size()>0)ans[i--]=st.pop();
        return ans;
    }
}
