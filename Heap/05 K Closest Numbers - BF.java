public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Create a list of pairs (element, distance)
        List<int[]> distances = new ArrayList<>();
        for (int num : arr) {
            distances.add(new int[]{num, Math.abs(num - x)});
        }

        // Sort the list based on distance and tie-breaking by value
        Collections.sort(distances, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]); // Tie-breaker: smaller value preferred
            }
            return Integer.compare(a[1], b[1]); // Primary sort by distance
        });

        // Select the first k elements
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(distances.get(i)[0]);
        }

        // Sort the result in ascending order
        Collections.sort(result);

        return result;
}
