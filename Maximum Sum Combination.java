//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair{
        int x;
        int y;
        int sum;
        public Pair(int sum , int x , int y){
            this.sum = sum;
            this.x = x;
            this.y = y;
        }
    }
    static List<Integer> maxCombinations(int n, int k, int a[], int b[]) {
        // code here
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        PriorityQueue<Pair>  uwu = new PriorityQueue<>((c , d) -> d.sum - c.sum);
        uwu.add(new Pair(a[n - 1] +  b[n - 1] , n - 1 , n - 1));
        
        Set<String> set = new HashSet<>();
        
        set.add((n - 1) + " " + (n - 1));
        
        while(!uwu.isEmpty()){
            Pair curr = uwu.poll();
            int x = curr.x;
            int y = curr.y;
            ans.add(curr.sum);
            
            if(ans.size() == k) break;
            
            if(x - 1 >= 0 && !set.contains((x - 1) + " " + y)){
                set.add((x - 1) + " " + y);
                uwu.add(new Pair(a[x - 1] + b[y] , x - 1 , y));
            }
            
            if(y - 1 >= 0 && !set.contains(x  + " " + (y - 1))){
                set.add(x + " " + (y - 1));
                uwu.add(new Pair(a[x] + b[y - 1] , x , y - 1));
            }
        }
        return ans;
    }
}
