//https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        // Stack<Character> stack = new Stack <>();
        // Recommended implementation of Stack. Faster and can be used as a queue too
        Deque<Character> stack = new ArrayDeque<>();

        char currentStackTop;

        for(char currentChar : s.toCharArray()) {
            if(currentChar == '(' || currentChar == '[' || currentChar == '{')
                stack.push(currentChar);
            else {
                if (stack.isEmpty())
                    return false;

                currentStackTop = stack.pop();
                
                if((currentStackTop == '[' && currentChar != ']') ||
                    (currentStackTop == '(' && currentChar != ')') ||
                    (currentStackTop == '{' && currentChar != '}') )
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
