class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        
        int n = mat.length;
        int count = 0;
        int celeb = -1;
        int in = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j]==1)
                    count++;
                if(j==n-1 && count==0)
                {
                        celeb = i;
                        in++;
                }
                else if(j==n-1 && count>0){
                    count=0;
                }
            }
        }
        int celebcount=0;
        if(in==1 && celeb>-1)
        {
           for(int i=0; i<n; i++)
        {
            if(i!=celeb && mat[i][celeb]==1)  celebcount++;
        } 
        }
        
        
        return (in==1 && celebcount==n-1)?celeb:-1;
    }
}
