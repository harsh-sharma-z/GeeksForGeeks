// Complete the function given below
class Solution
{
    public static int binarySearch(int arr[], int n, int element) {
        int low = 0, high = n - 1, count = 0;
        
        while(low <= high) {
            int mid = (low - high) / 2 + high;
            if(arr[mid] <= element) {
                count += mid - low + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }  
        }
        
        return count;
    }
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
       // add your code here
       ArrayList<Integer> uwu =new ArrayList<>();
       Arrays.sort(arr2);
       for(int i=0;i<m;i++)
       {
           uwu.add(binarySearch(arr2,n,arr1[i]));
           
       }
       
       return uwu;
    }
}
