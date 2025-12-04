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
    List<Integer> list = new LinkedList<>(); // stores negative values in window

    while (j < N) {
        // If current element is negative, store its value
        if (A[j] < 0) list.addLast(A[j]);

        // Expand window until size K
        if (j - i + 1 < K) j++;
        // When window size == K
        else if (j - i + 1 == K) {
            // First negative in current window
            if (list.isEmpty()) res[i] = 0;
            else res[i] = list.peekFirst();
            // Before sliding, remove element going out of window from list
            if (!list.isEmpty() && A[i] == list.peekFirst()) {
                list.removeFirst();
            }
            // Slide the window
            i++;
            j++;
        }
    }
    return res;
}
