class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // o( 2 ^ (t/m) ) time 
        // o(t/m) space
        // t is given number
        // m is min value in array
        List<List<Integer>> result = new ArrayList();
        dfs(0, nums, new ArrayList(), 0, target, result);

        return result;
    }

    private void dfs(int i, int[] nums, List<Integer> curr, int total, int target, List<List<Integer>> result) {
        if (total == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        else if (i >= nums.length || total > target) return;

        curr.addLast(nums[i]);
        dfs(i, nums, curr, nums[i] + total, target, result);

        curr.removeLast();
        dfs(i+1, nums, curr, total, target, result);
    }
}
