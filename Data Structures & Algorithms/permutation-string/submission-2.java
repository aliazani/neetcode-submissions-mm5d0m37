
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Edge case: If s1 is larger than s2, it can't be a substring
        if (s1.length() > s2.length()) return false;
        
        // Use int arrays to track character frequencies instead of booleans
        int k = s1.length();
        int[] countS1 = new int[26];
        int[] countWindow = new int[26];
        
        // Fill the frequency arrays for s1 and the VERY FIRST window of s2
        for (int i = 0; i < k; i++) {
            countS1[s1.charAt(i) - 'a']++;
            countWindow[s2.charAt(i) - 'a']++;
        }
        
        // Check if the first window is a match
        if (Arrays.equals(countS1, countWindow)) return true;
        
        // Slide the window across the rest of s2
        for (int i = k; i < s2.length(); i++) {
            // Add the new character entering the window on the right
            countWindow[s2.charAt(i) - 'a']++;
            
            // Remove the old character leaving the window on the left
            countWindow[s2.charAt(i - k) - 'a']--;
            
            // Compare the actual values of the arrays
            if (Arrays.equals(countS1, countWindow)) return true;
        }

        return false;
    }
}