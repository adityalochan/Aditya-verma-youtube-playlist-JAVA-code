public static List<Integer> topKFrequent(int[] nums, int k) {
    // Step 1: Count the frequency of each number
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    // Step 2: Convert the map to a list of entries
    List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

    // Step 3: Sort the list based on frequency in descending order
    entryList.sort((a, b) -> Integer.compare(b.getValue(), a.getValue())); // Sort by frequency

    // Step 4: Extract the top K elements
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
        result.add(entryList.get(i).getKey());
    }

    return result;
}

public static void main(String[] args) {
    int[] nums = {1, 1, 1, 3, 2, 2, 4, 4, 4, 4};
    int k = 2;

    List<Integer> result = topKFrequent(nums, k);
    System.out.println("Top " + k + " Frequent Numbers: " + result);
}
