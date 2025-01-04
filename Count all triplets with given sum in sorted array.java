//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;
        
        for (int i = 0; i < n - 2; i++) {
            int p1 = i+1; 
            int p2 = n - 1; 
            
            while (p1 < p2) {
                int sum = arr[i] + arr[p1] + arr[p2];
                
                if (sum == target) {
                    count++;
                    int tp1 = p1+1;
                    int tp2 = p2-1;
                    while (tp1<p2 && arr[tp1] == arr[p1]){ count++;tp1++;}
                    while (tp2>p1 && arr[tp2] == arr[p2]){ count++;tp2--;}
                    p1++;
                    p2--;

                } else if (sum < target) {
                    p1++; 
                } else {
                    p2--; 
                }
            }
        }
        
        return count;
    }
}
