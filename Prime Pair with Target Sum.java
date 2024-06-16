//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends


// import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> getPrimes(int n) {
       ArrayList<Integer> primePair = new ArrayList<>();
        int i = 2;
        int j = n-i;
        while( i <= j && i < n ){
            if(prime(j)){
                if(prime(i)){
                    primePair.add(i);
                    primePair.add(j);
                    break;
                }
            }
            i++;
            j--;
        }
        if(primePair.isEmpty()){
            primePair.add(-1);
            primePair.add(-1);
        }
        return primePair;
    }

    public static boolean prime(int N){

        boolean isPrime = true;

        for (int y = 2; y * y <= N; y++) {
            if (N % y == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
