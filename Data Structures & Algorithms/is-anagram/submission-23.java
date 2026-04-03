class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> countChars = new HashMap<>();

        // Loop through s
        for (char c : s.toCharArray()) {
            countChars.put(c, countChars.getOrDefault(c, 0) + 1);
        }

        // Loop through t
        for (char c : t.toCharArray()) {
            if (!countChars.containsKey(c)) return false;
            countChars.put(c, countChars.get(c) - 1);
        }

        // Check counts
        for (int value : countChars.values()) {
            if (value != 0) return false;
        }

        return true;
    }
}