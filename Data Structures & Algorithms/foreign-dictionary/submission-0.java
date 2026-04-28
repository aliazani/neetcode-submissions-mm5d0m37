class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();

        // Add every unique character as a node
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adj.putIfAbsent(ch, new HashSet<>());
            }
        }

        // Build edges from adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int minLength = Math.min(word1.length(), word2.length());

            // Invalid case: "abc" before "ab"
            if (word1.length() > word2.length() &&
                word1.substring(0, minLength).equals(word2.substring(0, minLength))) {
                return "";
            }

            for (int j = 0; j < minLength; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    adj.get(c1).add(c2);
                    break;
                }
            }
        }

        Map<Character, Boolean> visit = new HashMap<>();
        List<Character> res = new ArrayList<>();

        for (char ch : adj.keySet()) {
            if (dfs(ch, adj, visit, res)) {
                return "";
            }
        }

        Collections.reverse(res);

        StringBuilder sb = new StringBuilder();
        for (char ch : res) {
            sb.append(ch);
        }

        return sb.toString();
    }

    private boolean dfs(
        char ch,
        Map<Character, Set<Character>> adj,
        Map<Character, Boolean> visit,
        List<Character> res
    ) {
        if (visit.containsKey(ch)) {
            return visit.get(ch); 
        }

        visit.put(ch, true); // currently visiting

        for (char neigh : adj.get(ch)) {
            if (dfs(neigh, adj, visit, res)) {
                return true;
            }
        }

        visit.put(ch, false); // fully visited
        res.add(ch);

        return false;
    }
}
