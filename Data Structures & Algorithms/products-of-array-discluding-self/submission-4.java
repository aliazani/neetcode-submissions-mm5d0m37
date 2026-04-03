class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i=0; i < nums.length; i++) {
            res[i] = 1;
        }

        int prefix = 1;

        for (int i=0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i=nums.length -1; i > -1; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }
}  
