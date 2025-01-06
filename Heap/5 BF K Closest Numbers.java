public class KClosestNumbersBruteForce {

    // Function to find the K closest numbers to target in a sorted array using brute force
    public static List<Integer> findKClosestNumbers(int[] arr, int target, int k) {
        // Step 1: Create a list to store pairs of (absolute difference, number)
        List<int[]> differences = new ArrayList<>();

        // Step 2: Calculate the absolute difference and store it in the list
        for (int num : arr) {
            int diff = Math.abs(num - target); // Compute the absolute difference
            differences.add(new int[]{diff, num}); // Store the pair (difference, number)
        }

        // Step 3: Sort the list based on the absolute difference
        Collections.sort(differences, (a, b) -> Integer.compare(a[0], b[0]));  // Sort by the first element (difference)

        // Step 4: Extract the first K numbers from the sorted list
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(differences.get(i)[1]);  // Only add the number, not the difference
        }

        return result;
    }
}
