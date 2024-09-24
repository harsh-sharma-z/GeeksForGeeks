//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "-1";

        Map<Character, Integer> pMap = new HashMap<>();
        for (char ch : p.toCharArray()) pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);

        int left = 0, minLength = Integer.MAX_VALUE, minStart = 0, count = 0;
        Map<Character, Integer> windowMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (pMap.containsKey(rightChar)) {
                windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);
                if (windowMap.get(rightChar) <= pMap.get(rightChar)) count++;
            }

            while (count == p.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                if (pMap.containsKey(leftChar)) {
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                    if (windowMap.get(leftChar) < pMap.get(leftChar)) count--;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "-1" : s.substring(minStart, minStart + minLength);
    }
}

