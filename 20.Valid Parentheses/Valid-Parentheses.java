class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = Map.of(
            '(', ')', '[', ']', '{', '}'
        );
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || pairs.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}