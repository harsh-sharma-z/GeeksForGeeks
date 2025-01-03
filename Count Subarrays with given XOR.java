//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int curXor=0;
        Map<Integer,Integer> map=new HashMap<>();
        
        int ans=0;
        for(int ele : arr){
            curXor^=ele;
            
            if(curXor==k)
                ans++;
            int z=curXor^k;
            if(map.containsKey(z))
                ans+=(map.get(z));
            
            
            int x=0;
            if(map.containsKey(curXor))
                x=map.get(curXor);
            
            map.put(curXor , x+1);
            // System.out.println((curXor) +" "+(x+1));
            
        }
        
        
        return ans;
    }
}
