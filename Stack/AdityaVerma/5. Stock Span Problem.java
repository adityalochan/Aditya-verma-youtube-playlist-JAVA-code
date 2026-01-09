/*
The stock span problem is a financial problem where we have a series of n daily
price quotes for a stock and we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number
of consecutive days just before the given day, for which the price of the stock on
the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as arr the span values for corresponding
7 days are O/P
arr = [100, 80, 60, 70, 60, 75, 85]
O/P = [1,   1,   1,  2,  1,  4,  6]
Same solution as nearest greater to left with only different of adding [NGL Element,index]
 */
Eg
consecutive smaller or equal = nearest greater non consecutive (span -i)
arr:       100 80 60 70 60 75 55
NSR index	1  1   1  2  1  4  6
*/
------------------
BRUTEFORCE
------------------
public int[] calculateSpan(int[] price, int n) {
    int[] span = new int[n];
    // Step 1: find previous greater index
    for (int i = 0; i < n; i++) {
        span[i] = -1; // default: no greater on left
        for (int j = i - 1; j >= 0; j--) {
            if (price[j] > price[i]) {
                span[i] = j;  // store index of previous greater
                break;        // nearest → stop
            }
        }
    }
    // Step 2: convert index to span
    for (int i = 0; i < n; i++) {
        span[i] = i - span[i];
    }
    return span;
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