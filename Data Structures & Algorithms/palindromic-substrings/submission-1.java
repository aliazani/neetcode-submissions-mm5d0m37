class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for (int i =0; i < s.length(); i++) {
            res += count(s, i, i);
            res += count(s, i, i+1);
        }

        return res;
    }

    private int count(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == (s.charAt(right))) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
