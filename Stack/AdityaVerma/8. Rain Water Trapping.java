/* Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.

Input: arr[]   = {2, 0, 2}
Output: 2
Structure is like below
| |
|_|
We can trap 2 units of water in the middle gap.

Input: arr[]   = {3, 0, 0, 2, 0, 4}
Output: 10
Structure is like below
     |
|    |
|  | |
|__|_|
We can trap "3*2 units" of water between 3 an 2,
"1 unit" on top of bar 2 and "3 units" between 2
and 4.  See below diagram also.

Dont mix it up with MAH. Both are different questions
arr = [3, 0, 0, 2, 0, 4]
1. Build maxLeft array
2. Build maxRight array
3. For each index:
      water += min(maxLeft, maxRight) - height
 */
------------------
BRUTEFORCE - T: (O(n²))
------------------
public int trap(int[] height) {
    int n = height.length;
    int totalWater = 0;

    for (int i = 0; i < n; i++) {
        int mxl = 0;
        for (int j = i; j >= 0; j--) {
            mxl = Math.max(mxl, height[j]);
        }
        int mxr = 0;
        for (int j = i; j < n; j++) {
            mxr = Math.max(mxr, height[j]);
        }

        totalWater += Math.min(leftMax, rightMax) - height[i];
    }
    return totalWater;
}
------------------
STACK - T:O(N) , S:O(N)
------------------
public int trap(int[] arr) {
    int n = arr.length;

    int[] mxl = new int[n]; // max to the left
    int[] mxr = new int[n]; // max to the right
    int[] water = new int[n];

    // Step 1: Build max-left array
    mxl[0] = arr[0];
    for (int i = 1; i < n; i++) {
        mxl[i] = Math.max(mxl[i - 1], arr[i]);
    }

    // Step 2: Build max-right array
    mxr[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        mxr[i] = Math.max(mxr[i + 1], arr[i]);
    }

    // Step 3: Calculate trapped water at each index
    int sum = 0;
    for (int i = 0; i < n; i++) {
        water[i] = Math.min(mxl[i], mxr[i]) - arr[i];
        sum += water[i];
    }

    return sum;
}