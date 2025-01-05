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
