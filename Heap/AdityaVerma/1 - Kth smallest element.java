/*Leetcode 215 : Kth largest element in an Array*/
/*SORTING*/
public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length-k];
}

/*HEAP*/
public int findKthSmallest(int[] nums, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for (int num : nums) {
        maxHeap.add(num);
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
    }
    return maxHeap.peek();
}

