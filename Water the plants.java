class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        // code here
        int[][] range = new int[n][2];
        for(int i=0; i<n; i++){
            if(gallery[i] == -1){
                continue;
            }
            range[i][0] = i - gallery[i];
            if(range[i][0] < 0){
                range[i][0] = 0;
            }
            range[i][1] = i + gallery[i];
            if(range[i][1] >= n){
                range[i][1] = n;
            }
            //range[i][0] = Math.max(0, i-gallery[i]);
            //range[i][1] = Math.min(n-1, i+gallery[i]);
        }
        Arrays.sort(range, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        
        int start = 0, i = 0, res = 0;
        int currMax = -1;
        
        while(start < n){
            while(i < n){
                if(range[i][0]>start){
                    break;
                }
                currMax = Math.max(currMax, range[i][1]);
                i++;
            }
            if(currMax < start)
                return -1;
                
            res++;
            start = currMax+1;
        }
        return res;
    }
}

