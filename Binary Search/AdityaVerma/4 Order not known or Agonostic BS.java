
------------------
BRUTEFORCE -> LINEAR SEARCH
------------------


------------------
BINARY SEARCH
------------------
/* Hint: find if its ascending or descending and then apply BS */
public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;

    // Edge case: only one element
    if (nums.length == 1) {
        return nums[0] == target ? 0 : -1;
    }

    // Check order of the array
    if (nums[0] > nums[1]) { // Descending order
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                return mid;
            }
            else if (target < nums[mid]) {
                start = mid + 1;   // reversed comparison
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    if (nums[0] < nums[1]) { // Ascending order
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                return mid;
            }
            else if (target < nums[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
    return -1; // fallback (should never hit in valid sorted arrays)
}