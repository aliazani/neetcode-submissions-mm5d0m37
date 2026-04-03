class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String s: strs) {
            builder.append(s.length());
            builder.append("#");
            builder.append(s);
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
        
            int len_word = Integer.parseInt(str.substring(i, j));
            res.add(str.substring(j+1, j+1+len_word));
            i = j+1+len_word;


        }

        return res;

    }

}
