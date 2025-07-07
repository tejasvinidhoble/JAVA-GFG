class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1)); 
        Stack<Integer> stack = new Stack<>();
        
       
        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n;

            while (!stack.isEmpty() && arr[currentIndex] > arr[stack.peek()]) {
                int index = stack.pop();
                result.set(index, arr[currentIndex]);
            }

            if (i < n) {
                stack.push(currentIndex);
            }
        }
        return result;
    }
}