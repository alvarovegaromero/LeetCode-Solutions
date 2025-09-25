//https://leetcode.com/problems/the-skyline-problem

// First solution
// Time Complexity: O(n * x) 
// with n number of building and x the difference between x1 - x0
// Space Complexity: O(x)
// Problem --> overflow if building too big and efficiency not the best
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int xLength = Integer.MIN_VALUE;

        for(int[] building : buildings) {
            xLength = Math.max(building[1], xLength);
        }

        List<Integer> skyline = new ArrayList<>(Collections.nCopies(xLength + 1, 0));

        for(int[] building : buildings) {
            for(int i = building[0]; i <= building[1] - 1; i++) {
                skyline.set(i, Math.max(skyline.get(i), building[2]));
            }
        }

        List<List<Integer>> result = new ArrayList<>(xLength);

        int prevVal = 0;
        for(int i = 0; i < xLength + 1; i++) {
            if(skyline.get(i) != prevVal) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(skyline.get(i));
                result.add(tmp);
                prevVal = skyline.get(i);
            }
        }

        return result;
    }
}

// Second Solution:  Sweep Line + Priority Queue
// Time Complexity: O(n * log(n))
// Space Complexity: O(n)
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            // -b to process earlier bigger heights at the start of the buildings
            events.add(new int[]{b[0], -b[2]}); // start of building
            events.add(new int[]{b[1], b[2]});  // end of building
        }

        // Sort events, first by x coordinate, then by height
        events.sort((a, b) -> {
            if (a[0] != b[0]) 
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> heights = new PriorityQueue<>(Collections.reverseOrder());
        heights.add(0);
        int prevHeight = 0;

        for (int[] e : events) {
            int x = e[0], height = e[1];
            if (height < 0) {
                heights.add(-height); // start
            } else {
                heights.remove(height); // end
            }

            int currHeight = heights.peek();
            if (currHeight != prevHeight) {
                result.add(List.of(x, currHeight));
                prevHeight = currHeight;
            }
        }

        return result;
    }
}
