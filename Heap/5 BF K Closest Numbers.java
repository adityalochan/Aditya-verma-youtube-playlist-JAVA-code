public class KClosestNumbersBruteForce {
    // Function to find the K closest numbers to target in a sorted array using brute force
    public static List<Integer> findKClosestNumbers(int[] arr, int target, int k) {
        // Step 1: Create a list to store pairs of (number, absolute difference from target)
        List<int[]> differences = new ArrayList<>();

        // Step 2: Calculate the absolute difference and store it in the list
        for (int num : arr) {
            int diff = Math.abs(num - target); // Compute the absolute difference
            differences.add(new int[]{num, diff});
        }

        // Step 3: Sort the list based on the absolute difference
        Collections.sort(differences, (a, b) -> Integer.compare(a[1], b[1]));  // Sort by the second element (difference)

        // Step 4: Extract the first K numbers from the sorted list
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(differences.get(i)[0]);  // Only add the number, not the difference
        }

        return result;
    }
}
