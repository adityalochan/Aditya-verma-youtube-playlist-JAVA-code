public List<Integer> findClosestElements(int[] arr, int k, int x) {
    // Use a max-heap to maintain the closest k elements
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
        if (b[0] == a[0]) return Integer.compare(b[1], a[1]); // Compare values if difference is the same
        return Integer.compare(b[0], a[0]); // Compare differences in descending order
    });

    // Add elements to the heap
    for (int num : arr) {
        maxHeap.offer(new int[]{Math.abs(x-num), num});
        if (maxHeap.size() > k) {
            maxHeap.poll(); // Remove the farthest element
        }
    }

    // Extract elements from the heap
    List<Integer> result = new ArrayList<>();
    while (!maxHeap.isEmpty()) {
        result.add(maxHeap.poll()[1]);
    }

    // Sort the result in ascending order
    Collections.sort(result);
    return result;
}

