------------------
BRUTEFORCE -> LINEAR SEARCH
------------------
/*T:O(N) | S:O(1)*/
public int search(int[] nums, int target) {
    // Traverse the array one by one
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target) {
            return i; // target found at index i
        }
    }
    return -1; // target not found
}

------------------
BINARY SEARCH
------------------
/*T:O(log N) | S:O(1)*/
public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }

    return -1;
}


