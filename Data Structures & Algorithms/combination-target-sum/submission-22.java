class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // o( 2 ^ (t/m) ) time 
        // o(t/m) space
        // t is given number
        // m is min value in array
        List<List<Integer>> result = new ArrayList<>();

        dfs(0, new ArrayList(), 0, nums, target, result);

        return result; 
    }

    private void dfs(int i, List<Integer> cur, int total, int[] nums, int target, List<List<Integer>> result) {
        if (total == target) {
            result.add(new ArrayList<>(cur));
            return;
        }
        else if (i >= nums.length || total > target) return;
        // recursively calling i 
        cur.addLast(nums[i]);
        dfs(i, cur, nums[i] + total, nums, target, result);
        // exclude i
        cur.removeLast();
        dfs(i+1, cur, total, nums, target, result);
    }

}
