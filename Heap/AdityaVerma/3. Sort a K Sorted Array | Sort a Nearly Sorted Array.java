/*
Given an array of n elements, where each element is at most k away from its target position,
devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2,
an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.

Example:
Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
k = 3
Output : arr[] = {2, 3, 5, 6, 8, 9, 10} .
*/

---------------
SORTING (Insertion Sort)
---------------
public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums;
}

--------------
HEAPSORT: O(n log n)
--------------
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

--------------
HEAP: O(n log k) | k << n, this is much faster than O(n log n).
--------------
/* Function to sort a nearly sorted array using a min-heap */
public int[] sortNearlySortedArray(int[] arr, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int[] result = new int[arr.length]; // Array to store the sorted result
    int index = 0;

    // Add the first k+1 elements to the heap
    for (int i = 0; i <= k && i < arr.length; i++) {
        minHeap.add(arr[i]);
    }
    // Process the remaining elements
    for (int i = k + 1; i < arr.length; i++) {
        result[index++] = minHeap.poll(); // Extract the smallest element from the heap
        minHeap.add(arr[i]); // Add the next element from the array
    }
    // Extract remaining elements from the heap
    while (!minHeap.isEmpty()) {
        result[index++] = minHeap.poll();
    }
    return result; // Return the sorted array
}
