class Solution {
    public String minWindow(String s, String t) {
        if (t == "") return "";

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // sliding window here
        int left = 0;
        int meet = 0;
        int have = map.size();

        // resuList
        String result = "";
        int resultLen = Integer.MAX_VALUE;


        for (int right=0; right < s.length(); right++) {
            map2.put(s.charAt(right), map2.getOrDefault(s.charAt(right), 0) + 1);

            if (map.containsKey(s.charAt(right)) 
                &&
                map2.get(s.charAt(right)) == map.get(s.charAt(right))) meet++;

            while (meet == have) {
                if (right-left+1 <= resultLen)  { 
                    result = s.substring(left, right+1);
                    resultLen = result.length();
                }
                // pop from the char list
                map2.put(s.charAt(left), map2.get(s.charAt(left)) - 1);
                if (map.containsKey(s.charAt(left))
                   &&
                   map2.get(s.charAt(left)) < map.get(s.charAt(left)) 
                   ) {
                    meet--;
                   }
                
                left++;
        }

        }
        return result;

    }

}
