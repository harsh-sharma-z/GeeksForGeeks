//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        HashMap <Integer, Integer> map = new HashMap<>(); // to store frequency
 
        Set<Integer> set = new HashSet();  //to store unique elements whose majority is greater than n/3
        int flag = 0; //to ensure if there is atleast 1 majority
        //Frequency calculation
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
             if(map.get(i)>nums.size()/3){
                 flag++;
                 set.add(i);
            }
        }
        
         List<Integer> li = new ArrayList<>(set);//puting elements in a list
        
         if(flag == 0){
             li.add(-1);
             return li;
         }
           
         Collections.sort(li);//to sort the elements in increasing order
         return li;
    }
}
