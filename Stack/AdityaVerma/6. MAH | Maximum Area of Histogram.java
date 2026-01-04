/*Famous stack problem
    Key idea recap
	•	Find Nearest Smaller to Left (NSL) → indices
	•	Find Nearest Smaller to Right (NSR) → indices
	•	Width = right[i] - left[i] - 1
    •	Area = height[i] * width
	•	Take max
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
    Stack<long[]> s1 = new Stack<>(); // {height, index}
    Stack<long[]> s2 = new Stack<>();
    int pseudoLeft = -1;
    int pseudoRight = n;

    // -------- Nearest Smaller to Left --------
    for (int i = 0; i < n; i++) {
        if (s1.isEmpty())
            left[i] = pseudoLeft;
        else if (s1.peek()[0] < arr[i]) {
            left[i] = (int) s1.peek()[1];
        }
        else {
            while (!s1.isEmpty() && s1.peek()[0] >= arr[i]) {
                s1.pop();
            }
            left[i] = s1.isEmpty() ? pseudoLeft : (int) s1.peek()[1];
        }
        s1.push(new long[]{arr[i], i});
    }

    // -------- Nearest Smaller to Right --------
    for (int i = n - 1; i >= 0; i--) {
        if (s2.isEmpty()) {
            right[i] = pseudoRight;
        }
        else if (s2.peek()[0] < arr[i]) {
            right[i] = (int) s2.peek()[1];
        }
        else {
            while (!s2.isEmpty() && s2.peek()[0] >= arr[i]) {
                s2.pop();
            }
            right[i] = s2.isEmpty() ? pseudoRight : (int) s2.peek()[1];
        }
        s2.push(new long[]{arr[i], i});
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