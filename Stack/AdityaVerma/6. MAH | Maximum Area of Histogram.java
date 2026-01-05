/*Famous stack problem
    Key idea recap
	•	Find Nearest Smaller to Left (NSL) → indices
	•	Find Nearest Smaller to Right (NSR) → indices
	•	Width = right[i] - left[i] - 1
    •	Area = height[i] * width
	•	Take max
Eg
 arr:    -1 6  2  5  4  5  1  6  7
 NSR index	1  5  3  5  5  7  7
 NSL index -1 -1  1  1  3 -1  5
 */
------------------
BRUTEFORCE
------------------
public long getMaxArea(long[] arr, int n) {
    long maxArea = 0;

    for (int i = 0; i < n; i++) {
        long height = arr[i];
        int left = i;
        int right = i;

        // Expand to the left
        while (left >= 0 && arr[left] >= height) {
            left--;
        }
        // Expand to the right
        while (right < n && arr[right] >= height) {
            right++;
        }
        long width = right - left - 1;
        long area = height * width;

        maxArea = Math.max(maxArea, area);
    }
    return maxArea;
}

------------------
STACK
------------------
import java.util.*;


public long getMaxArea(long[] arr, int n) {

    int[] left = new int[n];   // NSL indices
    int[] right = new int[n];  // NSR indices
    Stack<long[]> stack1 = new Stack<>(); // {height, index}
    Stack<long[]> stack2 = new Stack<>();
    int pseudoLeft = -1;
    int pseudoRight = n;

    // -------- NSL: Nearest Smaller to Left --------
    for (int i = 0; i < n; i++) {
        if (stack1.isEmpty())
            left[i] = pseudoLeft;
        else if (stack1.peek()[0] < arr[i]) {
            left[i] = (int) stack1.peek()[1];
        }
        else {
            while (!stack1.isEmpty() && stack1.peek()[0] >= arr[i]) {
                stack1.pop();
            }
            left[i] = stack1.isEmpty() ? pseudoLeft : (int) stack1.peek()[1];
        }
        stack1.push(new long[]{arr[i], i});
    }
    // --------NSR: Nearest Smaller to Right --------
    for (int i = n - 1; i >= 0; i--) {
        if (stack2.isEmpty()) {
            right[i] = pseudoRight;
        }
        else if (stack2.peek()[0] < arr[i]) {
            right[i] = (int) stack2.peek()[1];
        }
        else {
            while (!stack2.isEmpty() && stack2.peek()[0] >= arr[i]) {
                stack2.pop();
            }
            right[i] = stack2.isEmpty() ? pseudoRight : (int) stack2.peek()[1];
        }
        stack2.push(new long[]{arr[i], i});
    }

    // -------- Calculate Maximum Area --------
    long maxArea = Long.MIN_VALUE;

    for (int i = 0; i < n; i++) {
        long width = right[i] - left[i] - 1;
        long area = width * arr[i];
        maxArea = Math.max(maxArea, area);
    }
    return maxArea;
}