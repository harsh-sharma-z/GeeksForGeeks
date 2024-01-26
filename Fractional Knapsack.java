//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Frac{
    int profit;
    int weig;
    double pByW;
    Frac(int profit,int weig){
        this.profit = profit;
        this.weig = weig;
        this.pByW = ((double)profit/(double)weig);
    }
}

class Solution
{
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        PriorityQueue<Frac> pq = new PriorityQueue<>(new Comparator<Frac>(){
            @Override
            public int compare(Frac a,Frac b){
                if(a.pByW==b.pByW){
                    return 0;
                }else if(a.pByW>b.pByW){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        for(int i=0;i<n;i++){
            pq.add(new Frac(arr[i].value,arr[i].weight));
        }
        
        double TotalProfit = 0;//contain ans;
        while(!pq.isEmpty()){
            Frac val = pq.poll();
            if(W==0){
                break;
            }
            if(val.weig<=W){
                TotalProfit += val.profit;
                W = W-val.weig;
            }else{
                // double a = (double) W/val.weig;
                TotalProfit += (double) ((double)val.profit*(double)W/val.weig);
                W = 0;
            }
        }
        return TotalProfit;
        
    }
}
