//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution
{
    int[] prime;
    final int MAX = 9999;
    Solution()
    {
        // Every index of prime stores zero or one
        // If prime[i] is zero means i is not a prime
        // If prime[i] is one means i is a prime
        prime = new int [MAX + 1];
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;
        for (int i = 2; i * i < MAX + 1; i++) {
            if (prime[i] == 1) {
                for (int j = i; j * i < MAX + 1; j++) {
                    prime[i * j] = 0;
                }
            }
        }
    }
    
    public int shortestPath(int num1,int num2){
        // Complete this function using prime array
        if (num1 == num2) {
            return 0;
        }
        return bfs(num1, num2);
    }
    
    private int bfs(int n1, int n2) {
        Queue<Integer> queue = new LinkedList<>();
        int shortestDistance = 0;
        queue.offer(n1);
        Set<Integer> visited = new HashSet<>();
        visited.add(n1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int top = queue.poll();
                if (top == n2) {
                    return shortestDistance;
                }
                // we have 4 digit numbers only
                for (int digit = 0; digit < 4; digit++) {
                    for (int num = 0; num < 10; num++) {
                        int nextNumber = top;
                        nextNumber -= (nextNumber / (int)(Math.pow(10, digit))) % 10 * (int)(Math.pow(10, digit));
                        nextNumber += num * (int)(Math.pow(10, digit));
                        if (nextNumber >= 1000 && nextNumber <= 9999 && !visited.contains(nextNumber)
                        && prime[nextNumber] == 1) {
                            queue.offer(nextNumber);
                            visited.add(nextNumber);
                        }
                    }
                }
            }
            shortestDistance++;
        }
        return -1;
    }
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        Solution ob = new Solution();
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int Num1=Integer.parseInt(input_line[0]);
            int Num2=Integer.parseInt(input_line[1]);
            System.out.println(ob.shortestPath(Num1,Num2));
        }
    }
}
// } Driver Code Ends
