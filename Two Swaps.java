//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        // Loop through each test case
        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            List<Integer> arr = new ArrayList<>();

            // Convert input to list of integers
            for (String str : inputArr) {
                arr.add(Integer.parseInt(str));
            }

            Solution ob = new Solution();
            boolean ans = ob.checkSorted(arr);

            // Output result
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {

    public boolean checkSorted(List<Integer> arr) {
        // code here
        int n = arr.size();
        int i = 0, c = 0;
        
        while(i < n) {
            int k = arr.get(i);
            
            if(arr.get(k - 1) == k) {
                i++;
            }
            else {
                int temp = arr.get(k - 1);
                arr.set((k - 1) , k);
                arr.set(i , temp);
                c++;
            }
        }
        
        return c == 2 || c == 0;
    }
}
