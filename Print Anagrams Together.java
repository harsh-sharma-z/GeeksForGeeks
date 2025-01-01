//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        Map<String,ArrayList<String>> m=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            int[] f=new int [26];
            char[] c=arr[i].toCharArray();
            for(int j=0;j<c.length;j++){
                char ct=c[j];
                f[ct-'a']++;
            }
            
            String k=Arrays.toString(f);
            if(!m.containsKey(k)){
                m.put(k,new ArrayList<>());
                
            }
            m.get(k).add(arr[i]);
            
        }
        return new ArrayList<>(m.values());
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends
