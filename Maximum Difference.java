//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        int n=arr.length;
        int left[]=new int[n];
        int right[]=new int[n];
        Stack<Integer>st1=new Stack<>();
        left[0]=0;
        st1.add(arr[0]);
        Stack<Integer>st2=new Stack<>();
        right[n-1]=0;
        st2.add(arr[n-1]);
        
        
        for(int i=1;i<n;i++){
            while(!st1.isEmpty()&&st1.peek()>=arr[i]){
                st1.pop();
            }
            
            left[i]=st1.isEmpty()?0:st1.peek();
            st1.add(arr[i]);
        }
        for(int i=n-2;i>=0;i--){
            while(!st2.isEmpty()&&st2.peek()>=arr[i]){
                st2.pop();
            }
            
            right[i]=st2.isEmpty()?0:st2.peek();
            st2.add(arr[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,Math.abs(left[i]-right[i]));
        }
        return ans;
    }
}
