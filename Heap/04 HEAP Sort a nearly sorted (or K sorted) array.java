public class NearlySortedArraySorter {
    /* Function to sort a nearly sorted array using a min-heap */
    static int[] sortNearlySortedArray(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] result = new int[arr.length]; // Array to store the sorted result
        int index = 0;

        // Add the first k+1 elements to the heap
        for (int i = 0; i <= k && i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        // Process the remaining elements
        for (int i = k + 1; i < arr.length; i++) {
            result[index++] = minHeap.poll(); // Extract the smallest element from the heap
            minHeap.add(arr[i]); // Add the next element from the array
        }

        // Extract remaining elements from the heap
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }

        return result; // Return the sorted array
    }
}
