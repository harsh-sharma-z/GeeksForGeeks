//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int l; 
            l = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, l);
            
            Solution obj = new Solution();
            int res = obj.findMinTime(n, l, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int findMinTime(int n, int l, int[] arr) {
        // code here
        Arrays.sort(arr);
        
        int s = arr[0];
        int e = arr[arr.length-1] * n * (n+1) / 2;
        
        int time = 0;
        while(s <= e) {
            int mid = (s+e)/2;
            
            if(isPossible(arr, mid, n)) {
                time = mid;
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        
        return time;
    }
    
    public static boolean isPossible(int[] arr, int mid, int n) {
        int donuts = 0;
        
        for(int i=0;i<arr.length;i++) {
            int timeWeHave = mid;
            int timeWillTake = arr[i];
            while(timeWeHave >= timeWillTake) {
                timeWeHave -= timeWillTake;
                timeWillTake += arr[i];
                donuts++;
            }
        }
        
        return donuts >= n ? true : false;
    }
}
        
