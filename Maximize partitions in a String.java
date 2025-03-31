class Solution {
    public int maxPartitions(String s) {
        // code here
        int x[] = new int[26];
        for(int i=0;i<s.length();i++) {
            x[s.charAt(i)-'a'] = i;
        }
        
        int y = 0;
        int last = 0;
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            last = Math.max(last, x[ch - 'a']);
            if(last == i){
                y++;
            }
        }
        return y;
    }
}
