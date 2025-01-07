public static List<Integer> topKFrequent(int[] nums, int k) {
    // Step 1: Count the frequency of each number using a HashMap
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    // Step 2: Convert the frequency map into a list of entries
    List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

    // Step 3: Sort the list based on frequency in descending order
    entryList.sort((a, b) -> b.getValue() - a.getValue()); // Sort by frequency

    // Step 4: Extract the top K elements
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
        result.add(entryList.get(i).getKey()); // Add only the number (not the frequency)
    }

    return result;
}
