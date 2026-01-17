class Solution {
    public static boolean checkRedundancy(String s) {
        // code here
          Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // If closing bracket, check inside
            if (ch == ')') {
                boolean hasOperator = false;

                // Pop until opening bracket
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();

                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }

                // Remove '('
                stack.pop();

                // If no operator found → redundant
                if (!hasOperator) {
                    return true;
                }
            } 
            else {
                stack.push(ch);
            }
        }
        return false;
    }
}
