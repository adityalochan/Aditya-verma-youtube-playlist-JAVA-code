---------------------------------------------------------------------------------------------------------------------
 USING SORTING
---------------------------------------------------------------------------------------------------------------------
static int[] insertionSort(int A[], int size) {
    // Start from the second element (index 1) because the first element (index 0) is already "sorted"
    for (int i = 1; i < size; i++) {
        int key = A[i]; // Key is the element to be inserted into the sorted part of the array
        int j = i - 1;  // Start comparing with the last element of the sorted part

        /*
         * Move elements of the sorted part (A[0..i-1]) that are greater than the key
         * one position ahead to make space for the key.
         */
        while (j >= 0 && A[j] > key) {
            A[j + 1] = A[j]; // Shift the element one position to the right
            j--; // Move to the previous element
        }

        // Place the key in its correct position
        A[j + 1] = key;
    }

    // Return the sorted array
    return A;
}

---------------------------------------------------------------------------------------------------------------------
 USING HEAP
---------------------------------------------------------------------------------------------------------------------
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
