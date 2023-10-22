//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // take testcases
        int t = sc.nextInt();
        while (t-- > 0) {
            // taking the number
            int n = sc.nextInt();
            Geeks obj = new Geeks();

            // caling isPrime method
            // with n as argument
            System.out.println(obj.isPrime(n));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Geeks {
    static String isPrime(int n) {
        if(n == 0 || n == 1)
            return "No";
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // Write your logic here
            // Return "Yes" if n is prime, else return "No"
            /*n is prime only if it is not divisible by any i.
            We will not reach till n and 1 is already discarded*/
                if(n % i == 0)
                    return "No";
            }
            return "Yes";
    }
}
