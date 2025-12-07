
------------------
BRUTEFORCE -> LINEAR SEARCH
------------------
public int[] searchRange(int[] nums, int target) {
    int firstOccurrence = -1;
    int lastOccurrence = -1;

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target) {
            if (firstOccurrence == -1) {
                firstOccurrence = i;   // first time we see target
            }
            lastOccurrence = i;        // keep updating last occurrence
        }
    }

    return new int[]{firstOccurrence, lastOccurrence};
}

------------------
BINARY SEARCH
------------------
/*T:O(log N) , S:O(1)*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurrence = -1;
        int lastOccurrence = -1;
        int start = 0;
        int end = nums.length - 1;

        // ✅ Find First Occurrence
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                firstOccurrence = mid;
                end = mid - 1;   // move left
            }
            else if (target < nums[mid]) end = mid - 1;
            else start = mid + 1;
        }

        // ✅ Reset pointers for Last Occurrence
        start = 0;
        end = nums.length - 1;

        // ✅ Find Last Occurrence
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                lastOccurrence = mid;
                start = mid + 1;   // move right
            }
            else if (target < nums[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return new int[]{firstOccurrence, lastOccurrence};
    }
}
