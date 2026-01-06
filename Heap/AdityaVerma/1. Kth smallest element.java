import java.util.PriorityQueue;
/*Leetcode 215 : Kth largest element in an Array

Given an array and a number k where k is smaller than size of array,
we need to find the k’th smallest element in the given array. It is
given that all array elements are distinct.
Example:
Input: arr[] = {7, 10, 4, 3, 20, 15}
k = 3
Output: 7

*/

-----------
SORTING
-----------
public int findKthSmallest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length-k];
}

-----------
HEAP
-----------
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

