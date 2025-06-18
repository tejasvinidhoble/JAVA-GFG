class Solution {
    public ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
          ArrayList<ArrayList<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, ArrayList<String> currentList, ArrayList<ArrayList<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList)); // valid partition
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String part = s.substring(start, end + 1);
            if (isPalindrome(part)) {
                currentList.add(part); // choose
                backtrack(s, end + 1, currentList, result); // explore
                currentList.remove(currentList.size() - 1); // backtrack
            }
        }
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }
}
