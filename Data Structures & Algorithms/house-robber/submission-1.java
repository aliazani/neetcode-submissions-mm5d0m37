class Solution {
    public int rob(int[] nums) {
     int last = 0;
     int prevLast = 0;

    // [prevLast, last, i]
     for(int i=0; i < nums.length; i++) {
        int temp = Math.max(prevLast + nums[i], last);
        prevLast = last;
        last = temp; 
     }

     return last;
    }
}
