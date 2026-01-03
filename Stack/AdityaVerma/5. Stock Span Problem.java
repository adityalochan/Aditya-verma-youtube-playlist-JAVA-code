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
    int[] result = new int[n];        // store spans
    Stack<Integer> stack = new Stack<>(); // store indices of previous higher prices

    for (int i = 0; i < n; i++) {
        if (stack.isEmpty()) { // Case 1: no previous higher price
            result[i] = i + 1;  // span = all previous days + current day
        }
        else if (price[stack.peek()] > price[i]) { // Case 2: top of stack is greater
            result[i] = i - stack.peek();         // span = distance to previous greater
        }
        else { // Case 3: top of stack <= current price
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop(); // remove smaller/equal prices
            }
            result[i] = stack.isEmpty() ? i + 1 : i - stack.peek(); // calculate span
        }
        stack.push(i); // push current index for future comparisons
    }

    return result;
}