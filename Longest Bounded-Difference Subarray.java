//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int n = arr.length, i = 0, j = 0, st = 0, en = 0;
        Deque<Integer> mn = new LinkedList<>(), mx = new LinkedList<>();
        
        while (j < n) {
            while (!mn.isEmpty() && mn.peekLast() > arr[j]) mn.pollLast();
            while (!mx.isEmpty() && mx.peekLast() < arr[j]) mx.pollLast();
            mx.addLast(arr[j]);
            mn.addLast(arr[j]);
            
            if (!mx.isEmpty() && !mn.isEmpty() && (mx.peekFirst() - mn.peekFirst() <= x)) {
                if ((en - st) < (j - i)) {
                    en = j;
                    st = i;
                }
                j++;
            } else if (i < j && !mx.isEmpty() && !mn.isEmpty() && (mx.peekFirst() - mn.peekFirst() > x)) {
                if (arr[i] == mn.peekFirst()) mn.pollFirst();
                if (arr[i] == mx.peekFirst()) mx.pollFirst();
                i++;
                j++;
            }
        }
        
        if (st == en) return new ArrayList<>(Collections.singletonList(arr[0]));
        ArrayList<Integer> res = new ArrayList<>();
        for (int k = st; k <= en; k++) res.add(arr[k]);
        return res;
        
    }
}




//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
