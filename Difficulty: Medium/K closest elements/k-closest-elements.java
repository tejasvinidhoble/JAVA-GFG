
class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        // Max heap with custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);

            // If differences are not same, bigger difference first
            if (diffA != diffB) return diffB - diffA;

            // If same difference, prefer larger value
            return a - b;
        });

        for (int num : arr) {
            if (num == x) continue; // Skip x if it exists
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the farthest or smaller one if tied
            }
        }

        // Transfer from heap to list and sort as per problem rule
        List<Integer> result = new ArrayList<>(maxHeap);
        result.sort((a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            if (diffA != diffB) return diffA - diffB;
            return b - a; // Prefer larger in tie
        });

        // Convert to array and return
        int[] resArr = new int[k];
        for (int i = 0; i < k; i++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }
}

   