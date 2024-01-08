//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long sumOfPowers(long a, long b) {
        // code here
        int[] smallestPrimeFactor = new int[(int) b + 1];
        for (int i = 2; i <= b; i++) {
            smallestPrimeFactor[i] = i;
        }
    
        for (int p = 2; p * p <= b; p++) {
            if (smallestPrimeFactor[p] == p) {
                for (int i = p * p; i <= b; i += p) {
                    if (smallestPrimeFactor[i] == i) {
                        smallestPrimeFactor[i] = p;
                    }
                }
            }
        }
    
        long sum = 0;
        for (long i = a; i <= b; i++) {
            sum += sumOfPowersOfPrimeFactors(i, smallestPrimeFactor);
        }
    
        return sum;
    }

    private static int sumOfPowersOfPrimeFactors(long n, int[] smallestPrimeFactor) {
        int sum = 0;
        while (n > 1) {
            int primeFactor = smallestPrimeFactor[(int) n];
            int count = 0;
            while (n % primeFactor == 0) {
                n /= primeFactor;
                count++;
            }
            sum += count;
        }
        return sum;
    }
    
}
        
