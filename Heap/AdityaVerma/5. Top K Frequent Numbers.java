/*
Given an array of n numbers. Your task is to read numbers from the array and keep at-most
K numbers at the top (According to their decreasing frequency) every time a new number is
read. We basically need to print top k numbers sorted by frequency when input stream has
included k distinct elements, else need to print all distinct elements sorted by frequency.

Example:
Input :  arr[] = {5, 2, 1, 3, 2}
k = 4
Output : 5 2 5 1 2 5 1 2 3 5 2 1 3 5
*/
-------------
 BRUTEFORCE
-------------
public static List<Integer> topKFrequent(int[] nums, int k) {
    // Step 1: Count the frequency of each number
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    // Step 2: Convert the map to a list of entries
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());

    // Step 3: Sort the list based on frequency in descending order
    list.sort((a, b) -> Integer.compare(b.getValue(), a.getValue())); // Sort by frequency

    // Step 4: Extract the top K elements
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
        result.add(list.get(i).getKey());
    }
    return result;
}

------------
 HEAP
------------
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
