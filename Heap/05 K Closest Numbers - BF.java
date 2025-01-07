public static List<Integer> topKFrequent(int[] nums, int k) {
    // Step 1: Create a frequency map
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    // Step 2: Create a list to store pairs of (frequency, number)
    List<int[]> frequencyList = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
        frequencyList.add(new int[]{entry.getValue(), entry.getKey()}); // {frequency, number}
    }

    // Step 3: Sort the list based on frequency in descending order
    Collections.sort(frequencyList, (a, b) -> Integer.compare(b[0], a[0])); // Sort by frequency (descending)

    // Step 4: Extract the top K numbers
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
        result.add(frequencyList.get(i)[1]); // Add the number (not the frequency)
    }

    return result;
}

