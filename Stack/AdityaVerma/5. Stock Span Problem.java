

Same solution as nearest greater to left with only different of adding [NGL Element,index]
------------------
BRUTEFORCE
------------------
public int[] calculateSpan(int[] price, int n) {
    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
        result[i] = -1; // default value
        int count = 1; // at least today counts
        for (int j = i - 1; j >= 0; j--) {
            if (price[j] <= price[i])
                count++;
            else
                break; // stop at first greater price
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
    Stack<int[]> stack = new Stack<>(); // {price, index}

    for (int i = 0; i < n; i++) {
        // Case 1: stack empty → no greater on left
        if (stack.isEmpty()) {
            span[i] = -1;
        }
        // Case 2: top of stack is greater than current price
        else if (stack.peek()[0] > price[i]) {
            span[i] = stack.peek()[1];
        }
        // Case 3: top of stack <= current price
        else {
            while (!stack.isEmpty() && stack.peek()[0] <= price[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? -1 : stack.peek()[1];
        }
        // Push current price with index
        stack.push(new int[]{price[i], i});
    }
    // Convert previous greater index → span
    for (int i = 0; i < n; i++) {
        span[i] = i - span[i];
    }

    return span;
}