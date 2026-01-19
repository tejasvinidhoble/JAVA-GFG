class Solution {
    public String removeKdig(String s, int k) {
        // code here
          int n = s.length();
        if (k == n) return "0";

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > ch) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(ch);
        }

        // Remove remaining digits from the end if k > 0
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros
        int idx = 0;
        while (idx < stack.length() && stack.charAt(idx) == '0') {
            idx++;
        }

        String result = stack.substring(idx);
        return result.isEmpty() ? "0" : result;
    }
}