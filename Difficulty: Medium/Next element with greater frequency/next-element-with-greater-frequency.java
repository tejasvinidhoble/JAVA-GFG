class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        // code here
          int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        
        
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        
        for (int i = n - 1; i >= 0; i--) {
            int currFreq = freq.get(arr[i]);

           
            while (!stack.isEmpty() && freq.get(stack.peek()) <= currFreq) {
                stack.pop();
            }

            
            res[i] = stack.isEmpty() ? -1 : stack.peek();

           
            stack.push(arr[i]);
        }

        
        for (int val : res) {
            result.add(val);
        }

        return result;
    }
}