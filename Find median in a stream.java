//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        int n = arr.length;
        ArrayList<Double> res = new ArrayList<>();
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>
        (Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : arr) {
            maxHeap.add(num);
            
            if (!maxHeap.isEmpty() && !minHeap.isEmpty() 
            && maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
            }
            
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            
            if (maxHeap.size() > minHeap.size()) {
                res.add((double) maxHeap.peek());
            } else {
                res.add((maxHeap.peek() + 
                minHeap.peek()) / 2.0);
            }
        }
        
        return res;
    }

}
