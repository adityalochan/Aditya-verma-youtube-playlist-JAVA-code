/*Given an array of integers, find the closest (not considering distance, but value)
greater on left of every element. If an element has no greater on the left side,
print -1 .
arr = [1, 3, 2, 4]
O/P : -1 -1  3  -1
*/
------------------
BRUTEFORCE
------------------
public int[] nearestGreaterToLeft(int[] arr, int n) {
    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
        result[i] = -1;  // default if no greater exists
        // Scan left side
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j] > arr[i]) {
                result[i] = arr[j]; // first greater on left
                break;              // nearest → stop
            }
        }
    }
    return result;
}
------------------
STACK
------------------
public int[] nearestGreaterToLeft(int[] arr, int n) {
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>(); // stack for elements

    // Traverse from left to right
    for (int i = 0; i < n; i++) {

        if (stack.isEmpty()) // Case 1: stack is empty
            result[i] = -1;
        else if (stack.peek() > arr[i]) // Case 2: top of stack is greater
            result[i] = stack.peek();
        else { // Case 3: top is smaller or equal
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
        }

        stack.push(arr[i]); // Push current element
    }

    return result;
}