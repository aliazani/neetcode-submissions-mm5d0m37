class Solution {
    public boolean hasDuplicate(int[] nums) {
     Set uniqueNums = new HashSet<Integer>();
    
     for (int i: nums) {
        uniqueNums.add(i);
     }
    
    return (uniqueNums.size() != nums.length);
    }
}