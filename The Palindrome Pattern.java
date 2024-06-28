class Solution {
    public String pattern(int[][] arr) {
        // Code here
        int n = arr.length;
        
        for(int i = 0; i < n; i++)
        {
            if(isPalindrome(arr,i,0,n-1))
            {
                return i + " " + "R";
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            if(isPalindrome2(arr,i,0,n-1))
            {
                return i + " " + "C";
            }
        }
        
        return "-1";
    }
    public boolean isPalindrome(int[][] arr,int i, int si, int ei)
    {
        while(si <= ei)
        {
            if(arr[i][si] != arr[i][ei])
            {
                return false;
            }
            si++;
            ei--;
        }
        
        return true;
    }
    public boolean isPalindrome2(int[][] arr,int i, int si, int ei)
    {
        while(si <= ei)
        {
            if(arr[si][i] != arr[ei][i])
            {
                return false;
            }
            si++;
            ei--;
        }
        
        return true;
    }
}
