//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        // code here
        String s="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ') continue;
            else{s+=str.charAt(i);
            }
        }
        if(s.length()<26) return false;
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        if((set.size()+k)>=26){
            return true;
        }
        if(set.size()>=26){
            return true;
        }
        return false;
    }
}
