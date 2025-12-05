------------------
BRUTEFORCE -> LINEAR SEARCH
------------------
Same a linear search

------------------
BINARY SEARCH
------------------
/*Opposite of sorted.*/
/*T:O(log N) | S:O(1)*/
public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            start = mid + 1;   // reversed comparison
        } else {
            end = mid - 1;
        }
        return -1;
    }
}
