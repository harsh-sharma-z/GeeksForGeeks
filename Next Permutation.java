//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    void nextPermutation(int[] arr) {
        int leftIndex = -1;
        for (int index = 1; index < arr.length; index++) {
            leftIndex = (arr[index] > arr[index - 1]) ? index - 1 : leftIndex;
        }
        
        if (leftIndex == -1) {
            Arrays.sort(arr);
            return;
        }
        
        PriorityQueue<Integer> numsQueue = new PriorityQueue<>();
        for (int index = leftIndex; index < arr.length; index++) {
            numsQueue.offer(arr[index]);
        }
        
        int targetIndex = leftIndex + 1;
        while (!numsQueue.isEmpty() && numsQueue.peek() != arr[leftIndex]) {
            arr[targetIndex++] = numsQueue.poll();
        }
        
        while (!numsQueue.isEmpty() && numsQueue.peek() == arr[leftIndex]) {
            arr[targetIndex++] = numsQueue.poll();
        }
        
        arr[leftIndex] = numsQueue.poll();
        while (!numsQueue.isEmpty()) {
            arr[targetIndex++] = numsQueue.poll();
        }
    }
}

//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
