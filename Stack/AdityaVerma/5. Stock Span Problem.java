------------------
BRUTEFORCE
------------------
public int[] calculateSpan(int[] price, int n) {
    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
        result[i] = -1; // default value
        int count = 1; // at least today counts
        for (int j = i - 1; j >= 0; j--) {
            if (price[j] <= price[i]) {
                count++;
            } else {
                break; // stop at first greater price
            }
        }
        result[i] = count;
    }
    return result;
}
------------------
STACK
------------------
public int[] calculateSpan(int[] price, int n) {
    int[] span = new int[n];
    Stack<int[]> stack = new Stack<>(); // pair: {price, index}

    for (int i = 0; i < n; i++) {
        if (stack.isEmpty()) {
            span[i] = -1;
        }
        // Case 2: top price > current price
        else if (stack.peek()[0] > price[i]) {
            span[i] = stack.peek()[1];
        }
        // Case 3: top price <= current price
        else {
            while (!stack.isEmpty() && stack.peek()[0] <= price[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? -1 : stack.peek()[1];
        }
        // Push current price and index
        stack.push(new int[]{price[i], i});
    }
    // Convert indices to span values
    for (int i = 0; i < n; i++) {
        span[i] = i - span[i];
    }
    return span;
}