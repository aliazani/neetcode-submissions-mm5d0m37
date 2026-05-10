class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (end > start) {
            
            while (end > start && !isAlphaNum(s.charAt(start))) start++;
            while (end > start && !isAlphaNum(s.charAt(end))) end--;
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
            start++;
            end--;
        }

        return true;
    }

    private boolean isAlphaNum(char c) {
        return 
                (int)c >= (int) 'a' && (int)c <= (int) 'z' ||
                (int)c >= (int) 'A' && (int)c <= (int) 'Z' ||
                (int)c >= (int) '0' && (int)c <= (int) '9'; 
    }
}
