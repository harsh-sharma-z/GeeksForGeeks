//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {

        // Your code here

        List<List<int[]>> al = new ArrayList<>();

        for(int i=0; i<n; i++) al.add(new ArrayList<int[]>());

        for(List<Integer> it : roads) {

            al.get(it.get(0)).add(new int[]{it.get(1), it.get(2)});

            al.get(it.get(1)).add(new int[]{it.get(0), it.get(2)});

        }

        

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        int[] ways = new int[n];

        

        dist[0] = 0;

        ways[0] = 1;

        

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);

        

        pq.add(new int[]{0, 0});

        

        while(!pq.isEmpty()) {

            int curr[] = pq.poll();

            int u = curr[0];

            int w = curr[1];

            

            if(dist[u]<w) continue;

            for(int it[] : al.get(u)) {

                if(dist[it[0]]>it[1]+dist[u]) {

                    dist[it[0]] = it[1]+dist[u];

                    ways[it[0]] = ways[u];

                    pq.add(new int[]{it[0], dist[it[0]]});

                }else if(dist[it[0]] == it[1]+dist[u]) {

                    ways[it[0]] = (ways[it[0]]+ways[u])%1000000007;

                }

            }

        }

        

        return ways[n-1];

    }

}
