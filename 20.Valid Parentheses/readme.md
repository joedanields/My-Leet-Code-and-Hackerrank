# Valid Parentheses - LeetCode Problem 20

## Problem Description

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:
- Open brackets must be closed by the same type of brackets
- Open brackets must be closed in the correct order
- Every close bracket has a corresponding open bracket of the same type

## Solution Approach

This solution uses a **stack data structure** to solve the problem efficiently using the **LIFO (Last-In-First-Out)** principle .

### Algorithm

1. **Iterate** through each character in the string
2. **Push** opening brackets `'('`, `'{'`, `'['` onto the stack
3. **For closing brackets**, check if:
   - The stack is empty (no matching opening bracket) → return `false`
   - The top of the stack doesn't match the bracket type → return `false`
4. **Pop** the matching opening bracket from the stack
5. **After iteration**, return `true` only if the stack is empty (all brackets matched)

### Why Stack?

The stack is ideal because:
- We need to match the **most recent** unmatched opening bracket with each closing bracket
- LIFO ordering ensures proper nesting validation 
- Easy to track which opening bracket should be matched next 

## Code Implementation

```

class Solution {
public:
bool isValid(string s) {
stack<char> st;
for (char c : s) {
if (c == '(' || c == '{' || c == '[') {
st.push(c);
} else {
if (st.empty() ||
(c == ')' \&\& st.top() != '(') ||
(c == '}' \&\& st.top() != '{') ||
(c == ']' \&\& st.top() != '[')) {
return false;
}
st.pop();
}
}
return st.empty();
}
};

```

## Complexity Analysis

- **Time Complexity:** O(n) - We traverse the string once, and stack operations (`push`, `pop`, `top`) are O(1) 
- **Space Complexity:** O(n) - In the worst case (all opening brackets), the stack stores all characters

## Example Test Cases

```

Input: s = "()"
Output: true

Input: s = "()[]{}"
Output: true

Input: s = "(]"
Output: false

Input: s = "([)]"
Output: false

Input: s = "([{}])"
Output: true

```

## Key Edge Cases

- Empty stack when closing bracket is encountered
- Unmatched opening brackets remaining (stack not empty at end)
- Incorrect bracket type matching
- Empty string (valid - returns `true`)

## Prerequisites

- C++11 or higher



## LeetCode Link

[Problem 20 - Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

## License

This solution is provided for educational purposes.
```
