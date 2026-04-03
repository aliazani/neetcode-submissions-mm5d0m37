class Solution {
    public boolean isValid(String s) {
        List<Character> opening = List.of('(', '{', '[');
        List<Character> closing = List.of(')', '}', ']');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (opening.contains(c)) {
                stack.push(c);
            } 
            else if (closing.contains(c)) {

                if (stack.isEmpty()) return false;

                // char top = 

                if (opening.indexOf(stack.peek()) == closing.indexOf(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}