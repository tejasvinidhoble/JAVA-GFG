class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
      ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            // Remove all elements smaller or equal to current price
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            // If stack is empty → span = i + 1
            if (st.isEmpty()) {
                span.add(i + 1);
            } 
            // Else span = current index - top index
            else {
                span.add(i - st.peek());
            }

            // Push current index
            st.push(i);
        }

        return span;  
    }
}