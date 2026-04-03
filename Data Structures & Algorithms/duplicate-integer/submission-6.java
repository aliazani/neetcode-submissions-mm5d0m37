class Solution {
    public boolean hasDuplicate(int[] nums) {
     Set uniqueNums = new HashSet<Integer>();
     for (int i: nums) {
        uniqueNums.add(i);
     }
    
    System.out.println("unique size: " + uniqueNums.size());
    System.out.println("Array len: " + nums.length);
     return (uniqueNums.size() != nums.length);
    }
}