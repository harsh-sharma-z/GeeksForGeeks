//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        String[] ans = new String[2];
        int max = 0;
        TreeMap<String, Integer> map = new TreeMap<>();
        for(String i : arr)
            map.put(i , map.getOrDefault(i , 0) + 1);
            
            for(Map.Entry<String , Integer> m : map.entrySet()){
                if(m.getValue() > max){
                    ans[0] = m.getKey();
                    ans[1] = m.getValue().toString();
                    max = m.getValue();
                }
            }
            
            return ans;
    }
}

