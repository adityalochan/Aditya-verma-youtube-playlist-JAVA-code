import java.util.PriorityQueue;

-----------
SORTING
-----------
public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length-k];
}

-----------
HEAP
-----------
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) {
        minHeap.add(num);
        if (minHeap.size() > k) {
            minHeap.poll(); // remove smallest
        }
    }
    return minHeap.peek();
}