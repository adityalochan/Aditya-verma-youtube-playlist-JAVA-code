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
