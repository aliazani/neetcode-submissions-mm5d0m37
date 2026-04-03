class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        // 1) Count frequencies
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // 2) Buckets: index = frequency, value = list of numbers with that frequency
        List<List<Integer>> freq = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) {
            freq.add(new ArrayList<>());
        }

        // 3) Fill buckets
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int c = entry.getValue();
            freq.get(c).add(num);
        }

        // 4) Collect from highest frequency down
        int[] res = new int[k];
        int idx = 0;

        for (int i = nums.length; i >= 1 && idx < k; i--) {
            for (int num : freq.get(i)) {
                res[idx++] = num;
                if (idx == k) break;
            }
        }

        return res;
    }
}