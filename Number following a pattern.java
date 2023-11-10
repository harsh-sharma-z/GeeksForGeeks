//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        int arr[]=new int[8];
        int count=0,min=1;;
        String ans="";
        if(S.charAt(0)=='I'){ 
            ans+='1';
            min++;
        }
        for(int i=S.length()-1;i>=0;i--){
           if(S.charAt(i)=='D'){
                count++;
                arr[i]=count;
            }
            else count=0;
        }
       if(S.charAt(0)=='D'){
            ans+=min+arr[0];
        }   
        for(int i=0;i<S.length();i++){
             if(i+1==S.length()){ ans+=min; break;}
            if(S.charAt(i)=='I'){
                if(arr[i+1]<1){
                    ans+=min;
                    min++;
                }
                else{
                    min+=arr[i+1];
                    int value=min;
                    int temp=arr[i+1];
                    ans+=value;
                    value--;
                    while(temp>0){
                       ans+=value;
                       i++;
                       value--;
                       temp--;
                    }
                    min++;
                }
            }
            else if(S.charAt(i)=='D') {
               min+=arr[i];
                    int value=min;
                    int temp=arr[i];
                    value--;
                    while(temp>0){
                       ans+=value;
                       i++;
                       value--;
                       temp--;
                    }  
                    i--;
                    min++;
            }
        }
        return ans;
    }
    
   
}
