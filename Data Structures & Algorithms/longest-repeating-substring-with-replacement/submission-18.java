class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> charSet = new HashSet<>();
        s.chars().forEach(c-> charSet.add((char) c));
        int res = 0;

        for (char c: charSet) {
            // now flexible window
            int left = 0;
            int count = 0;
            for (int right = 0; right < s.length(); right++) {
                if (s.charAt(right) == c) count++;
                // invalidity of the window => shrink left
                while((right-left+1) - count > k) {
                    if (s.charAt(left) == c) count--;
                    left++;
                }
                
                res = Math.max(res, right-left+1);
            }

        }
        return res;
            
    }
}
