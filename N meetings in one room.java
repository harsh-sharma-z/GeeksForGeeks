//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        ArrayList<int[]>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new int[]{start[i],end[i]});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // Compare by second element (ascending)
                int compareEnd = Integer.compare(a[1], b[1]);
                if (compareEnd != 0) {
                    return compareEnd;
                }
                // If second elements are equal, compare by first element (descending)
                return Integer.compare(b[0], a[0]);
            }
        });
        int cnt=0;
        for(int i=0;i<n;){
            int limit=list.get(i)[1];
            cnt++;
            while(i<n&&list.get(i)[0]<=limit){
                i++;
            }
            
        }
        return cnt;
    }
}
