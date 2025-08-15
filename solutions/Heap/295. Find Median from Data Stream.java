//https://leetcode.com/problems/find-median-from-data-stream

// Time Complexity: O(log n) for addNum, O(1) for findMedian
// Space Complexity: O(n)
class MedianFinder {
    // store smaller half of numbers
    private PriorityQueue<Integer> maxHeap;
    
    // store larger half of numbers
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // add to maxHeap first
        maxHeap.offer(num);

        // balance by moving the largest from maxHeap to minHeap
        minHeap.offer(maxHeap.poll());

        // ensure maxHeap has equal or one more element than minHeap
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        // If even number of elements, average the two middle values
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        // If odd, maxHeap has the extra element
        return maxHeap.peek();
    }
}

// Optimized -  reduce number of operations
// Time Complexity: O(log n) for addNum, O(1) for findMedian
// Space Complexity: O(n)
class MedianFinder {
    // store smaller half of numbers
    private PriorityQueue<Integer> maxHeap;
    
    // store larger half of numbers
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // add to maxHeap first if empty or num smaller than top of maxHeap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {            
            // insert into minHeap if greater
            minHeap.offer(num);
        }

        // balance by moving the largest from maxHeap to minHeap if needed
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }

        // ensure maxHeap has equal or one more element than minHeap
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        // If even number of elements, average the two middle values
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        // If odd, maxHeap has the extra element
        return maxHeap.peek();
    }
}