
// Function to find the K closest numbers to target in a sorted array using a max-heap
public static List<Integer> findKClosestNumbers(int[] arr, int target, int k) {
    // Max-Heap to store pairs of (absolute difference, number)
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])  // Compare based on the absolute difference (b[0] > a[0])
    );

    // Step 1: Iterate through the array and add elements to the max-heap
    for (int num : arr) {
        int diff = Math.abs(num - target); // Compute the absolute difference
        maxHeap.add(new int[]{diff, num}); // Store the pair (difference, number)

        // If the heap size exceeds K, remove the element with the largest difference
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
    }

    // Step 2: Extract the elements from the heap into a result list
    List<Integer> result = new ArrayList<>();
    while (!maxHeap.isEmpty()) {
        result.add(maxHeap.poll()[1]); // Only add the number (not the difference)
    }

    return result;
}

