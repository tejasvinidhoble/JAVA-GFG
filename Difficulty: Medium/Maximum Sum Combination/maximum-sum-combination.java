class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
         int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        Set<String> visited = new HashSet<>();

        int i = n - 1;
        int j = n - 1;

        maxHeap.add(new int[]{a[i] + b[j], i, j});
        visited.add(i + "," + j);

        ArrayList<Integer> result = new ArrayList<>();

        while (k-- > 0 && !maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int sum = top[0];
            i = top[1];
            j = top[2];

            result.add(sum);

            // Move to next possible pairs
            if (i - 1 >= 0 && !visited.contains((i - 1) + "," + j)) {
                maxHeap.add(new int[]{a[i - 1] + b[j], i - 1, j});
                visited.add((i - 1) + "," + j);
            }

            if (j - 1 >= 0 && !visited.contains(i + "," + (j - 1))) {
                maxHeap.add(new int[]{a[i] + b[j - 1], i, j - 1});
                visited.add(i + "," + (j - 1));
            }
        }

        return result;
    }
}