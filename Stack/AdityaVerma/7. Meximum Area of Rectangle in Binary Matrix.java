
/*
1.	Treat each row as a histogram
	2.	For every row:
        •	Update histogram heights
	•	Compute Maximum Area Histogram (MAH)
	3.	Return the maximum of all rows
*/
------------------
BRUTEFORCE
------------------

------------------
STACK
------------------
public int maximalRectangle(char[][] matrix) {
    int m = matrix.length;
    if (m == 0) return 0;
    int n = matrix[0].length;
    int result = 0;
    int[] histogram = new int[n];

    for (int i = 0; i < m; i++) {
        // Build histogram for current row
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == '1')
                histogram[j] += 1;
            else
                histogram[j] = 0;
        }
        // Apply MAH
        result = Math.max(result, largestRectangleArea(histogram));
    }
    return result;
}
/* Exact same code as 6.MAH */
public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int[] left = new int[n];   // NSL
    int[] right = new int[n];  // NSR
    Stack<int[]> stack1 = new Stack<>(); // {height, index}
    Stack<int[]> stack2 = new Stack<>();
    int pseudoLeft = -1;
    int pseudoRight = n;

    // -------- NSL --------
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
    // -------- NSR --------
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
    // -------- Calculate Area --------
    int maxArea = 0;
    for (int i = 0; i < n; i++) {
        int width = right[i] - left[i] - 1;
        int area = width * heights[i];
        maxArea = Math.max(maxArea, area);
    }
    return maxArea;
}