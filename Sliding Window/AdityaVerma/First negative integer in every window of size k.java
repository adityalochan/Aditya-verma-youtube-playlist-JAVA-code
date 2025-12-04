------------------
BRUTEFORCE
------------------
/*T:O(N * K) | S:O(1)*/
public int[] firstNegativeBruteforce(int[] arr, int n, int k) {
    int[] result = new int[n - k + 1];
    for (int i = 0; i <= n - k; i++) {
        for (int j = i; j < i + k; j++) {
            if (arr[j] < 0) {
                result[i] = arr[j];
                break;
            }
            result[i] = 0;
        }
    }
    return result;
}
------------------
SLIDING WINDOW
------------------
/*T: O(N) | S: O(K)*/
public int[] printFirstNegativeInteger(int[] A, int N, int K) {
    int i = 0, j = 0;
    int[] res = new int[N - K + 1];
    LinkedList<Integer> list = new LinkedList<>(); // stores indices of negatives
    int idx = 0; // index for result array

    while (j < N) {
        // If current element is negative, store its index
        if (A[j] < 0) list.addLast(j);
        // Expand window until size K
        if (j - i + 1 < K) j++;
        // When window size == K
        else if (j - i + 1 == K) {
            // First negative in current window
            if (list.isEmpty()) {
                res[idx++] = 0;
            } else {
                res[idx++] = A[list.peekFirst()];
            }

            // Before sliding, remove element going out of window from list
            if (!list.isEmpty() && list.peekFirst() == i) {
                list.removeFirst();
            }
            // Slide the window
            i++;
            j++;
        }
    }
    return res;
}
