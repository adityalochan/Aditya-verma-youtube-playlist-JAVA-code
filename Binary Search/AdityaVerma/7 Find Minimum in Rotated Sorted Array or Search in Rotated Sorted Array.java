/*7 Number of Times a Sorted array is Rotated OR
Find the Rotation Count in Rotated Sorted array
Consider an array of distinct numbers sorted in increasing order.
The array has been rotated (clockwise) k number of times. Given such an array,
find the value of k.*/

------------------
BRUTEFORCE -> LINEAR SEARCH
------------------
Normal linear search

------------------
BINARY SEARCH
------------------
/* Hint : minimum element (pivot) is smaller than left and right both. */
public int findMin(int[] nums) {
    int n = nums.length;
    int start = 0;
    int end = n - 1;
    // If there's only one element, that's the minimum
    if (n == 1) return nums[0];

    while (start <= end) {
        int mid = start + (end - start) / 2;
        int prev = (mid + n - 1) % n; // if index is 0 , 0-1 would be negative so mid+n-1
        int next = (mid + 1) % n; // if index was n , mid+n would be out of bound, so %n

        // Check if mid is the minimum (smaller than both neighbors)
        if (nums[mid] < nums[prev] && nums[mid] < nums[next])
            return nums[mid];
        // Decide which half to go to
        else if (nums[end] < nums[mid])
            start = mid + 1; // Right half is unsorted → min lies there
        else
            end = mid - 1; // Left half is unsorted or includes pivot
    }
    return -1; // ideally never reached for valid rotated sorted arrays
}
