//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


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
            
            int[] nm = IntArray.input(br, 2);
            
            
            int[][] a = IntMatrix.input(br, nm[0], nm[1]);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.sumZeroMatrix(a);
            
            if(res.size() == 0) {
                System.out.println(-1);
                
            } else {
            
                IntMatrix.print(res);
            }        
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int startCol = 0, endCol = 0, startRow = 0, endRow = 0, maxArea = -1001;

        for (int i = 0; i < numCols; i++) {
            int colSum[] = new int[numRows];
            for (int j = i; j < numCols; j++) {
                for (int k = 0; k < numRows; k++) {
                    colSum[k] += matrix[k][j];
                }

                int[] startIndices = { 0 };
                int[] endIndices = { 0 };
                int len = maxLength(colSum, startIndices, endIndices);

                int area = (endIndices[0] - startIndices[0] + 1) * (j - i + 1);

                if (len > 0 && area > maxArea) {
                    startRow = startIndices[0];
                    endRow =endIndices[0];
                    startCol = i;
                    endCol = j;
                    maxArea = area;
                }
            }
        }

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        for (int i = startRow; i <= endRow; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int j = startCol; j <= endCol; j++) {
                rowList.add(matrix[i][j]);
            }
            resultList.add(rowList);
        }
        return resultList;
    }

    static int maxLength(int array[], int[] startIndices, int[] endIndices) {
        int sum = 0, maxLength = 0;
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (array[i] == 0 && maxLength == 0) {
                startIndices[0] = i;
                endIndices[0] = i;
                maxLength = 1;
            }
            if (sum == 0) {
                if (maxLength < i + 1) {
                    startIndices[0] = 0;
                    endIndices[0] = i;
                }
                maxLength = i + 1;
            }
            if (sumIndexMap.containsKey(sum)) {
                int prevLength = maxLength;
                maxLength = Math.max(maxLength, i - sumIndexMap.get(sum));

                if (maxLength > prevLength) {
                     endIndices[0] = i;
                    startIndices[0] = sumIndexMap.get(sum) + 1;
                  
                }
            } else {
                sumIndexMap.put(sum, i);
            }
        }
        return maxLength;
    }
}
        
