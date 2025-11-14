// https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/
Leetcode (closest)  :
---------------------------------------------------------------------------------------------------------
//  BRUTEFORCE
----------------------------------------------------------------------------------------------------------
public int maximumSumSubarray(int K, int[] Arr, int N) {
    int maxSum = Integer.MIN_VALUE;
    // Loop over all possible subarrays of size K
    for (int i = 0; i <= N - K; i++) {
        int currentSum = 0;
        // Sum the elements of the current subarray
        for (int j = i; j < i + K; j++) {
            currentSum += Arr[j];
        }
        // Update maximum sum
        maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
}

---------------------------------------------------------------------------------------------------------
// SLIDING WINDOW
----------------------------------------------------------------------------------------------------------
public int maximumSumSubarray(int K, int[] Arr, int N) {
    int i = 0, j = 0;
    int sum = 0;
    int max = Integer.MIN_VALUE;

    while (j < N) {
        sum += Arr[j]; // do calculation to reduce time complexity
        if (j - i + 1 < K) {
            j++; // increment j until window size reaches K
        } else if (j - i + 1 == K) {
            max = Math.max(max, sum); // select maximum from candidates
            sum -= Arr[i];            // remove the first element of the window
            i++;
            j++;
        }
    }
    return max;
}