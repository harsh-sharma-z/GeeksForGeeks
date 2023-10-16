//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int N, int[][] grid) {
        int maxIslandSize = 0;
        int index = 2; // 0 and 1 are already used in the grid
        int[] area = new int[N * N + 2];

        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                if (grid[r][c] == 1) {
                    area[index] = dfs(grid, r, c, index);
                    maxIslandSize = Math.max(maxIslandSize, area[index]);
                    index++;
                }
            }
        }

        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                if (grid[r][c] == 0) {
                    HashSet<Integer> seen = new HashSet<>();
                    for (int[] move : directions) {
                        int nr = r + move[0];
                        int nc = c + move[1];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                            if (grid[nr][nc] > 1) {
                                seen.add(grid[nr][nc]);
                            }
                        }
                    }

                    int bns = 1;
                    for (int i : seen) {
                        bns += area[i];
                    }
                    maxIslandSize = Math.max(maxIslandSize, bns);
                }
            }
        }

        return maxIslandSize;
    }

    private int dfs(int[][] grid, int r, int c, int index) {
        int N = grid.length;
        if (r < 0 || r >= N || c < 0 || c >= N || grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = index;
        int size = 1;
        for (int[] direction : directions) {
            int newRow = r + direction[0];
            int newCol = c + direction[1];
            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N) {
                size += dfs(grid, newRow, newCol, index);
            }
        }
        return size;
    }
}
