//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
        // Code here
        for(int i=0; i<arr.size(); i++){
            while(arr.get(i)!=-1 && arr.get(i)!=i){
                int correctIndex = arr.get(i);
                
                if(arr.get(correctIndex) == correctIndex){
                    break;
                }
                
                int temp = arr.get(i);
                arr.set(i, arr.get(correctIndex));
                arr.set(correctIndex, temp);
            }
        }
        
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i)!=i){
                arr.set(i, -1);
            }
        }
        
        return arr;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Solution solution = new Solution();

        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            List<Integer> arr = new ArrayList<>();
            for (String s : inputArr) {
                arr.add(Integer.parseInt(s));
            }

            List<Integer> ans = solution.rearrange(arr);

            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
// } Driver Code Ends
