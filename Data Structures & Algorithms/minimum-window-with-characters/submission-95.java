class Solution {
    public String minWindow(String s, String t) {
        if (t == "") return "";

        Map<Character, Integer> need = new HashMap<>();

        t.chars().forEach(c -> need.put((char) c, need.getOrDefault((char)c, 0)+1));
        int required = need.size();

        // t.toChars().forEach(c -> need.put(need.getOrDefault(c, 0) + 1))
        // for (char c: t.toCharArray()) {
            // map.put(c, map.getOrDefault(c, 0) + 1);
        // }

        // sliding window here
        Map<Character, Integer> window = new HashMap<>();
        int have = 0;
        int left = 0;

        // resuList
        String result = "";
        int resultLen = Integer.MAX_VALUE;


        for (int right=0; right < s.length(); right++) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);

            if (need.containsKey(s.charAt(right)) 
                &&
                window.get(s.charAt(right)) == need.get(s.charAt(right))) have++;

            while (have == required) {
                if (right-left+1 <= resultLen)  { 
                    result = s.substring(left, right+1);
                    resultLen = result.length();
                }

                // pop from the char list
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                
                if (need.containsKey(s.charAt(left))
                   &&
                   window.get(s.charAt(left)) < need.get(s.charAt(left)) 
                   ) {
                    have--;
                   }
                
                left++;
        }

        }
        return result;

    }

}
