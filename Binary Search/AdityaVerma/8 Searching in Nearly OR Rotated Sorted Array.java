/* Leetcode : 33. Search in Rotated Sorted Array */

/* Hint: # of rotations -> Index of minimum element */
------------------
BRUTEFORCE -> LINEAR SEARCH
------------------
/*normal linear search*/
------------------
BINARY SEARCH
------------------
public int search(int[] nums, int target) {
    int n = nums.length;

    // Case: array of size 1
    if (n == 1) return nums[0] == target ? 0 : -1;

    // Case: array already sorted
    if (nums[0] < nums[n - 1]) {
        return bs(nums, 0, n - 1, target);
    }

    /* --------- Find Pivot (smallest element) ---------*/
    int pivot = -1;
    int start = 0, end = n - 1;

    while (start <= end) {
        int mid = start + (end - start) / 2;
        int prev = (mid - 1 + n) % n;
        int next = (mid + 1) % n;

        // Pivot condition
        if (nums[mid] < nums[prev] && nums[mid] < nums[next]) {
            pivot = mid;
            break;
        }
        // Move to right side
        else if (nums[mid] >= nums[0] && nums[mid] >= nums[n - 1]) {
            start = (mid + 1) % n;
        }
        // Move to left side
        else {
            end = (mid - 1 + n) % n;
        }
    }

    // --------- Decide which half to binary search ---------
    if (target >= nums[pivot] && target <= nums[n - 1]) {
        return bs(nums, pivot, n - 1, target);
    }
    return bs(nums, 0, pivot - 1, target);
}

// Standard Binary Search
private int bs(int[] nums, int start, int end, int target) {
    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) return mid;
        else if (target > nums[mid]) start = mid + 1;
        else end = mid - 1;
    }
    return -1;
}
