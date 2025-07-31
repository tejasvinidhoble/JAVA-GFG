class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        // code here
        TreeMap<Integer, Integer> map = new TreeMap<>();

        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }

        int current = 0;
        int last = -1;
        int result = -1;

       
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int pos = entry.getKey();
            int delta = entry.getValue();

            if (current >= k) {
              
                result = Math.max(result, pos - 1);
            }

            current += delta;
            last = pos;
        }

        return result;
    }
}