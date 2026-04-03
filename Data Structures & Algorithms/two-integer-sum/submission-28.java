class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer idx = numIdx.get(diff);

            if (idx != null) {
                return new int[]{idx, i};
            }

            numIdx.put(nums[i], i);
        }

        return new int[0];
    }
}