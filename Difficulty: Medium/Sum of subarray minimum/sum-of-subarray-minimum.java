class Solution {
    public int sumSubMins(int[] arr) {
        // code here
          int MOD = (int)1e9 + 7;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long) arr[i] * left[i] * right[i];
            result %= MOD;
        }

        return (int) result;
    }
}
