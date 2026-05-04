class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] canBreak = new boolean[n+1];
        canBreak[n] = true;
        for (int i=0; i<n;i++) canBreak[i] = false;


        for (int i=n;i >= 0; i--) {
            for (String word: wordDict) {
                int end = i + word.length();

                if (end <= n && s.substring(i, end).equals(word))
                    canBreak[i] = canBreak[end];
                if (canBreak[i]) break;
            }
        }
        return canBreak[0];
    }
}
