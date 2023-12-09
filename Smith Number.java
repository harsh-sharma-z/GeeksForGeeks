//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.smithNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int smithNum(int n) {
        // code here
        if(isPrime(n))
            return 0;
            
        int sum = 0;
        int temp = n;
        
        int num = 2;
        
        while(temp != 1){
            if(temp % num == 0){
                sum += sumdig(num);
                temp /= num;
            }
            else{
                num++;
            }
        }
        
        if(sum == sumdig(n))
            return 1;
        return 0;
    }
    
    static int sumdig(int n){
        int sum = 0;
        while(n > 0){
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
    
    
    static boolean isPrime(int n){
        for(int i = 2; i <= n / 2 ; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
};
