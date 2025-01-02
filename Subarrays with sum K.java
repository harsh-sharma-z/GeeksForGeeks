class Solution {
    public int countSubarrays(int arr[], int k) {
          int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 0; i<arr.length; i++) {
            sum += arr[i];
            int rem = sum - k;

            if(map.containsKey(rem)) {
                count += map.get(rem);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
