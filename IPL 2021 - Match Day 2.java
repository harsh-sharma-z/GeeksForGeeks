//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
         // Your code here
           ArrayList<Integer> list= new ArrayList<>();

        Queue<Integer> queue=new LinkedList<>();

 

        ArrayList<Integer> sublist= new ArrayList<>();

        for(int i=0; i<k; i++){

            

            while(sublist.size()> 0 && sublist.get(sublist.size()-1) < arr[i]){

                sublist.remove(sublist.size()-1);

            }

            sublist.add(arr[i]);

        }

        

        list.add(sublist.get(0));

        for(int i=k; i<n; i++){

            

            if(sublist.get(0) == arr[i-k]) sublist.remove(0);

            while(sublist.size()> 0 && sublist.get(sublist.size()-1) < arr[i]){

                sublist.remove(sublist.size()-1);

            }

            sublist.add(arr[i]);

            list.add(sublist.get(0));

        }

        return list;
    }
}  
