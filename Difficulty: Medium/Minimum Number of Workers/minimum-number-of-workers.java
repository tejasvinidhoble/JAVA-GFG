class Solution {
    public int minMen(int arr[]) {
        // code here
         int n = arr.length;
        List<int[]> intervals = new ArrayList<>();

        // Step 1: Create intervals
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int start = Math.max(0, i - arr[i]);
                int end = Math.min(n - 1, i + arr[i]);
                intervals.add(new int[]{start, end});
            }
        }

        // Step 2: Sort intervals
        intervals.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        int count = 0;
        int currentEnd = -1;
        int i = 0;

        // Step 3: Greedy coverage
        while (currentEnd < n - 1) {
            int farthest = currentEnd;

            while (i < intervals.size() && intervals.get(i)[0] <= currentEnd + 1) {
                farthest = Math.max(farthest, intervals.get(i)[1]);
                i++;
            }

            if (farthest == currentEnd) {
                return -1; // Cannot extend coverage
            }

            currentEnd = farthest;
            count++;
        }

        return count;
    }
}