/*Famous stack problem
Find the largest rectangular area possible in a given histogram where the largest
rectangle can be made of a number of contiguous bars. For simplicity, assume that
all bars have same width and the width is 1 unit.
Eg
 arr:    -1 6  2  5  4  5  1  6  7
 NSR index	1  5  3  5  5  7  7
 NSL index -1 -1  1  1  3 -1  5

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
public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int maxArea = 0;

    for (int i = 0; i < n; i++) {
        int height = heights[i];
        int left = i;
        int right = i;

        // Expand to the left
        while (left >= 0 && heights[left] >= height)
            left--;
        // Expand to the right
        while (right < n && heights[right] >= height)
            right++;

        int width = right - left - 1;
        int area = height * width;
        maxArea = Math.max(maxArea, area);
    }
    return maxArea;
}

------------------
STACK
------------------
public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int[] left = new int[n];   // NSL indices
    int[] right = new int[n];  // NSR indices
    Stack<int[]> stack1 = new Stack<>(); // {height, index}
    Stack<int[]> stack2 = new Stack<>();
    int pseudoLeft = -1;
    int pseudoRight = n;

    // -------- NSL (Nearest Smaller to Left) --------
    for (int i = 0; i < n; i++) {

        if (stack1.isEmpty()) {
            left[i] = pseudoLeft;
        }
        else if (stack1.peek()[0] < heights[i]) {
            left[i] = stack1.peek()[1];
        }
        else {
            while (!stack1.isEmpty() && stack1.peek()[0] >= heights[i]) {
                stack1.pop();
            }
            left[i] = stack1.isEmpty() ? pseudoLeft : stack1.peek()[1];
        }
        stack1.push(new int[]{heights[i], i});
    }

    // -------- NSR (Nearest Smaller to Right) --------
    for (int i = n - 1; i >= 0; i--) {
        if (stack2.isEmpty()) {
            right[i] = pseudoRight;
        }
        else if (stack2.peek()[0] < heights[i]) {
            right[i] = stack2.peek()[1];
        }
        else {
            while (!stack2.isEmpty() && stack2.peek()[0] >= heights[i]) {
                stack2.pop();
            }
            right[i] = stack2.isEmpty() ? pseudoRight : stack2.peek()[1];
        }

        stack2.push(new int[]{heights[i], i});
    }
    // -------- Calculate Maximum Area --------
    int maxArea = 0;
    for (int i = 0; i < n; i++) {
        int width = right[i] - left[i] - 1;
        int area = width * heights[i];
        maxArea = Math.max(maxArea, area);
    }
    return maxArea;
}