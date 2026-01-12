class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
         ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {

            // Remove elements out of this window
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Add max to result once window is complete
            if (i >= k - 1) {
                result.add(arr[dq.peekFirst()]);
            }
        }

        return result;
    }
}