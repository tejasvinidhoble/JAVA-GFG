class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
          int maxTime = 0;

        // Ants moving to the left fall off at their position (distance from 0)
        for (int pos : left) {
            maxTime = Math.max(maxTime, pos);
        }

        // Ants moving to the right fall off at (n - pos) (distance from n)
        for (int pos : right) {
            maxTime = Math.max(maxTime, n - pos);
        }

        return maxTime;
    }
}