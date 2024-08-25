//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int x[], int y[], int M, int N) {
        // code here
        double[] yy = new double[N];
        
        for(int i=0; i<N; i++) {
            yy[i] = getNewVal(y[i]);
        }
        
        Arrays.sort(yy);
        long ans = 0l;
        
        for(int num : x) {
            ans += binarySearch(yy, getNewVal(num));
        }
        
        return ans;
    }
    
    private static double getNewVal(int n) {
        return n / (Math.log(n) / Math.log(2));
    }
    
    private static int binarySearch(double[] y, double num) {
        int low = 0, high = y.length - 1; 
        
        while (low <= high) { 
            int mid = low + (high - low) / 2;
            
            if (y[mid] > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return y.length - low;
    }
}
