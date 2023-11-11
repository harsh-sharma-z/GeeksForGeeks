//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        // Your code here
        int len1 = str1.length();
        int len2 = str2.length();
        
        if(len1 !=  len2)
            return false;
        
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        
        Arrays.fill(arr1 , -1);
        Arrays.fill(arr2 , -1);
        
        for(int i = 0 ; i< len1 ; i++){
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            
            if(arr1[c1] == -1 && arr2[c2] == -1){
                arr1[c1] == c2;
                arr2[c2] == c1;
            }
            else if(arr1[c1] != c2 || arr2[c2] != c1){
                return false;
            }
        }
        
        return true;
        
    }
}
