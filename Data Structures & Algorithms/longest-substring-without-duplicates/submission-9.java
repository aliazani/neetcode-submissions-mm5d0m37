class Solution {
    public int lengthOfLongestSubstring(String s) {
        // for checking window validity
        Set<Character> unique = new HashSet<>();

        int left = 0;
        int longest = 0;

        for (int right=0; right < s.length(); right++) {
            // while the window is invalid shrink left pointer
            while (unique.contains(s.charAt(right))) {
                unique.remove(s.charAt(left));
                left++;
            }

            unique.add(s.charAt(right));
            longest = Math.max(longest, right-left + 1);
        }
    return longest;
    }

}
