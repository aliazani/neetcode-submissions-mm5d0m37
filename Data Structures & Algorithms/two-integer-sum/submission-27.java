class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIdx = new HashMap<>();
        int[] res = new int[2];
        for (int i=0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numIdx.get(diff) != null) {
                res[0] = numIdx.get(diff);
                res[1] = i;

                return res;
            } 
            numIdx.put(nums[i], i);    
        }
        return res;
    }

}