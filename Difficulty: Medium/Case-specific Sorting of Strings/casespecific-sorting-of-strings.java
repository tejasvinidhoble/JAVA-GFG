class Solution {
    public static String caseSort(String s) {
        // code here
          // Step 1: Store lowercase and uppercase letters separately
        List<Character> lower = new ArrayList<>();
        List<Character> upper = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else {
                upper.add(ch);
            }
        }

        // Step 2: Sort the lowercase and uppercase letters
        Collections.sort(lower);
        Collections.sort(upper);

        // Step 3: Reconstruct the string while keeping original case positions
        StringBuilder result = new StringBuilder();
        int lowerIndex = 0, upperIndex = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                result.append(lower.get(lowerIndex++));
            } else {
                result.append(upper.get(upperIndex++));
            }
        }

        return result.toString();
    }
}