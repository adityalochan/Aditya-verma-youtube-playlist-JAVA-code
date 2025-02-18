public static List<Integer> topKFrequent(int[] nums, int k) {
    // Step 1: Count the frequency of each number using a HashMap
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    // Step 2: Use a Min-Heap to keep the top K frequent elements
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1]) // Compare based on frequency (a[1])
    );

    // Step 3: Add elements from the frequency map to the heap
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
        int num = entry.getKey();
        int freq = entry.getValue();
        minHeap.add(new int[]{num, freq}); // Store the pair (number, frequency)

        // If the size of the heap exceeds K, remove the least frequent element
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    // Step 4: Extract the top K elements from the heap
    List<Integer> result = new ArrayList<>();
    while (!minHeap.isEmpty()) {
        result.add(minHeap.poll()[0]); // Add only the number, not the frequency
    }

    // Reverse the result to return numbers in descending frequency order
    Collections.reverse(result);

    return result;
}
