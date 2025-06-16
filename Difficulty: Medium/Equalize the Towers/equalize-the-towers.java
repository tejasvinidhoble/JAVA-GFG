class Solution {
    public int minCost(int[] heights, int[] cost) {
        // code here
        
        int low = 1, high = 10000;  // height limits as per constraints
        long answer = Long.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            long costMid = totalCost(heights, cost, mid);
            long costLeft = mid > 1 ? totalCost(heights, cost, mid - 1) : Long.MAX_VALUE;
            long costRight = mid < 10000 ? totalCost(heights, cost, mid + 1) : Long.MAX_VALUE;

            answer = Math.min(answer, costMid);

            // Move in direction of lower cost
            if (costLeft < costMid) {
                high = mid - 1;
            } else if (costRight < costMid) {
                low = mid + 1;
            } else {
                break;
            }
        }

        return (int) answer;
    }

    // Helper method to calculate total cost for making all heights equal to 'targetHeight'
    private long totalCost(int[] heights, int[] cost, int targetHeight) {
        long total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += 1L * Math.abs(heights[i] - targetHeight) * cost[i];
        }
        return total;
    }
}

  
