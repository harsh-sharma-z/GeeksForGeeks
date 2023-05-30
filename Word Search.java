//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    private int[] rowD={-1,0,1,0};
    private int[] colD={0,1,0,-1};
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        boolean[][] vis=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(dfs(board,i,j,0,word,vis))
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int row,int col, int index, String word,boolean[][] vis)
    {
        if(index==word.length())
        return true;
        if(row<0 || col<0 || row>=board.length || col>=board[0].length)
        return false;
        
        if(word.charAt(index)==board[row][col])
            {
                if(vis[row][col])
                return false;
                else
                vis[row][col]=true;
            }
            else
            return false;
            
        boolean isFound=false;
        for(int i=0;i<4;i++)
        isFound=isFound||(dfs(board,row+rowD[i],col+colD[i],index+1,word,vis));
        return isFound;
        
    }
}
