//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            int x=arr[i];
            if(mp.containsKey(x)){
                mp.put(x,mp.get(x)+1);
            }
            else{
                mp.put(x,1);
            }
        }
        ArrayList<Integer>list=new ArrayList<>(mp.keySet());
        Collections.sort(list,(a,b)->{
            if(mp.get(a)==mp.get(b)){
                return a-b;
            }
            else{
               return mp.get(b)-mp.get(a);
            }
        });
        ArrayList<Integer>ans=new ArrayList<>();
        
        for(int i=0;i<list.size();i++){
            int p=mp.get(list.get(i));
            while(p-->0){
                ans.add(list.get(i));
            }
        }
        
        return ans;
    }
}



//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends
