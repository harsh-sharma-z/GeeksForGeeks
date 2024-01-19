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
            
            String St[] = br.readLine().split(" ");
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
           
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.kTop(arr, N, K);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends



class Space{
	int val;
	int frequency;
	Space(int val,int frequency){
		this.val = val;
		this.frequency = frequency;
	}
}

class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int n, int k) {
        Map<Integer,Integer> map = new HashMap<>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> list ;
		
		PriorityQueue<Space> pq = new PriorityQueue<>(new Comparator<Space>() {
			@Override
			public int compare(Space a,Space b) {
				if(a.frequency == b.frequency) {
					return a.val-b.val;//if frequency is same then sort based on the value
				}else if(a.frequency<b.frequency) {
					return 1;//son't swap
				}else {
					return -1;//swap
				}
			}
		});
		
		int dist = 0;
		for(int i=0;i<n;i++) {
		    dist = k;
			list = new ArrayList<>();
			for(int j=0;j<=i;j++) {
				if(!map.containsKey(arr[j])) {
					map.put(arr[j], 1);
				}else {
					map.put(arr[j], map.get(arr[j])+1);
				}
			}
			map.forEach((e1,e2)->{
				pq.add(new Space(e1,e2));
			});
			map.clear();
			while(!pq.isEmpty()) {
				Space curr = pq.poll();
				if(dist>0){//consider the value for first k time
				    list.add(curr.val);
				}
				dist--;
			}
			ans.add(list);
		}
		return ans;
    }
}
        
