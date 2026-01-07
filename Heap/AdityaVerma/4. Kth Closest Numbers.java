/*
Given an unsorted array and two numbers x and k, find k closest values to x.
Input : arr[] = {10, 2, 14, 4, 7, 6}, x = 5, k = 3

 K=3 means, we need to find 3 numbers that are closest to x=5
 */

----------------
 BRUTEFORCE
----------------
public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Create a list of pairs (element, distance)
        List<int[]> distances = new ArrayList<>();
        for (int num : arr) {
            distances.add(new int[]{num, Math.abs(num - x)});
        }

        // Sort the list based on distance and tie-breaking by value
        Collections.sort(distances, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]); // Tie-breaker: smaller value preferred
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

--------------
 HEAP
--------------

public List<Integer> findClosestElements(int[] arr, int k, int x) {
    // Use a max-heap to maintain the closest k elements
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
        if (b[1] == a[1]) return Integer.compare(b[0], a[0]); // Compare values if difference is the same
        return Integer.compare(b[1], a[1]); // Compare differences in descending order
    });

    // Add elements to the heap
    for (int num : arr) {
        maxHeap.add(new int[]{num,Math.abs(x-num)});
        if (maxHeap.size() > k) {
            maxHeap.poll(); // Remove the farthest element
        }
    }

    // Extract elements from the heap
    List<Integer> result = new ArrayList<>();
    while (!maxHeap.isEmpty()) {
        result.add(maxHeap.poll()[0]);
    }

    // Sort the result in ascending order
    Collections.sort(result);
    return result;
}
