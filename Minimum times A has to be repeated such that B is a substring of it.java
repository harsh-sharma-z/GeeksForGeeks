 int ans =-1;

        for(int i=0; i< A.length(); i++){

            if(B.charAt(0) == A.charAt(i)) {

                ans = i;

                break;

            }

        }

        if(ans == -1) return -1;

        int N = A.length();

        int M = B.length();

        int total= M/N;

        int count = 0;

        String str = "";

        ans =total;

        while(total > 0){

            str= str+A;

            count++;

            if(str.contains(B)) return count;

            total--;

        }

        if(str.contains(B)) return ans;

        else if((str+A).contains(B)) return ans+1;

        else if((str+A+A).contains(B)) return ans+2;

        return -1;
