/* Given an array arr[] of integers, determine the Next Greater Element (NGE)
for every element in the array, maintaining the order of appearance.

The Next Greater Element for an element x is defined as the first element to the right
of x in the array that is strictly greater than x.
If no such element exists for an element, its Next Greater Element is -1.
https://www.geeksforgeeks.org/dsa/next-greater-element/
Closest Leetcode 496 */
------------------
BRUTEFORCE
------------------
public int[] nextLargerElement(int[] arr, int n) {
    int[] result = new int[n];
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(arr[i] < arr[j]){
                result[i] = arr[j];
            }
        }
    }
    return result;
}
------------------
STACK
------------------
public int[] nextLargerElement(int[] arr, int n) {
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>(); // stack for elements

    // Traverse from right to left
    for (int i = n - 1; i >= 0; i--) {

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

