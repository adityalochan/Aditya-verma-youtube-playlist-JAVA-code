------------------
BRUTEFORCE
------------------
/*T:O(N * K) | S:O(1)*/
public int[] firstNegativeBruteforce(int[] arr, int n, int k) {
    int[] result = new int[n - k + 1];

    for (int i = 0; i <= n - k; i++) {
        int firstNeg = 0;

        for (int j = i; j < i + k; j++) {
            if (arr[j] < 0) {
                firstNeg = arr[j];
                break;
            }
        }
        result[i] = firstNeg;
    }
    return result;
}
------------------
SLIDING WINDOW
------------------
/*T: O(N) | S: O(K)*/
public int[] printFirstNegativeInteger(int[] A, int N, int K) {
    int i = 0, j = 0;
    List<Integer> ans = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    while (j < N) {
        // Add current element to list if it's negative
        if (A[j] < 0) list.addLast(A[j]);

        if (j - i + 1 < K) j++;
        else if (j - i + 1 == K) {
            // window size == K → pick answer
            if (list.isEmpty()) ans.add(0);
            else ans.add(list.getFirst());

            // before sliding, remove the outgoing element if it's negative
            if (A[i] < 0 && !list.isEmpty()) list.removeFirst();
            i++;
            j++;
        }
    }
    // convert List<Integer> → int[]
    int[] res = new int[ans.size()];
    for (int idx = 0; idx < ans.size(); idx++) {
        res[idx] = ans.get(idx);
    }
    return res;
}