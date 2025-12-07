
------------------
BRUTEFORCE -> LINEAR SEARCH
------------------
simple for

------------------
BINARY SEARCH
------------------
public int count(int nums[], int target) {
    int start = 0, end = nums.length - 1;
    int first = -1;
    int last = -1;

    // ✅ First occurrence
    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (target == nums[mid]) {
            first = mid;
            end = mid - 1;   // move left
        }
        else if (target < nums[mid]) end = mid - 1;
        else start = mid + 1;
    }

    // ✅ RESET pointers before second binary search
    start = 0;
    end = nums.length - 1;

    // ✅ Last occurrence
    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (target == nums[mid]) {
            last = mid;
            start = mid + 1;   // move right
        }
        else if (target < nums[mid]) end = mid - 1;
        else start = mid + 1;
    }
    // ✅ Final count
    if (first == -1) return 0;   // target not found at all
    return last - first + 1;
}
