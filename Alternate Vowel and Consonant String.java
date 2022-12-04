//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static final int  MAX_CHARS = 26;
    public String rearrange(String S, int N){
        if(N == 1){
            return S;
        }
        int vowelsCount = 0;
        int consonantsCount = 0;
        int[] vowels = new int[MAX_CHARS];
        int[] consonants = new int[MAX_CHARS];
        for(char ch : S.toCharArray()){
            if(isVowel(ch)){
                vowelsCount++;
                vowels[ch-'a']++;
            }
            else{
                consonantsCount++;
                consonants[ch-'a']++;
            }
        }
        if(Math.abs(vowelsCount - consonantsCount) > 1){
            return "-1";
        }
        if(vowelsCount > consonantsCount){
            return arrangeVowelsFirst(vowels,consonants,N);
        }
        else if(consonantsCount > vowelsCount){
            return arrangeVowelsLast(vowels,consonants,N);
        }
        else{
            String first = arrangeVowelsFirst(vowels,consonants,N);
            String second = arrangeVowelsLast(vowels,consonants,N);
            if(first.compareTo(second) < 0){
                return first;
            }
            else{
                return second;
            }
        }
    }
    boolean isVowel(char ch){
        return (ch == 'a' | ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
    String arrangeVowelsFirst(int[] vowelsCount,int[] consonantsCount,int n){
        char[] charsArray = new char[n];
        int k = 0;
        for(int index = 0;index < MAX_CHARS;index++){
            int frequency = vowelsCount[index];
            while(frequency > 0){
                charsArray[k] = (char)('a'+index);
                k+=2;
                frequency--;
            }
        }
        k=1;
        for(int index = 0;index<MAX_CHARS;index++){
            int frequency = consonantsCount[index];
            while(frequency > 0){
                charsArray[k] = (char)('a'+index);
                k+=2;
                frequency--;
            }
        }
        String ans = new String(charsArray);
        return ans;
    }
    String arrangeVowelsLast(int[] vowelsCount,int[] consonantsCount,int n){
        char[] charsArray = new char[n];
        int k = 0;
        for(int index = 0;index<MAX_CHARS;index++){
            int frequency = consonantsCount[index];
            while(frequency > 0){
                charsArray[k] = (char)('a'+index);
                k+=2;
                frequency--;
            }
        }
        k=1;
         for(int index = 0;index < MAX_CHARS;index++){
            int frequency = vowelsCount[index];
            while(frequency > 0){
                charsArray[k] = (char)('a'+index);
                k+=2;
                frequency--;
            }
        }
        String ans = new String(charsArray);
        return ans;
    }
    
}
