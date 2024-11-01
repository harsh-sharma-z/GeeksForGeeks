//{ Driver Code Starts
import java.io.*;
import java.util.*;

// Driver class

// } Driver Code Ends
// User function Template for Java

class Solution {
    public long maxSum(Long[] arr) {
        // code here
        Arrays.sort(arr); 
        int right = arr.length - 1;
        long ans[] = new long[arr.length];
        ans[0] = arr[0]; 
        int n = arr.length;
        int xt = 1;
        for(int i = 1; i < n; i++) {
            if(i % 2 != 0) {
                ans[i] = arr[right]; 
                right--;
            }else{
                ans[i] = arr[i-xt];
                xt = xt+1;
            }    
        }

  
        int count = 1;
        int slow = 0;
        int fast = 1; long sum = 0;
        while(count!=arr.length){
            sum+=Math.abs(ans[slow]-ans[fast]);
            slow++;
            fast++;
            count = count+1;
        }
        sum+=Math.abs(ans[n-1]-ans[0]);
        return sum;
    }
}


//{ Driver Code Starts.
class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Long integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into Long integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            // Convert ArrayList to array
            Long[] arr = new Long[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call maxSum method and print result
            long ans = ob.maxSum(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
