/*Given an array of integers, find the closest (not considering distance, but value)
smaller on rightof every element. If an element has no smaller on the right side, print -1.
arr = [4, 5, 2, 10, 8]
O/P :  2  2 -1  8  -1
*/
------------------
BRUTEFORCE
------------------
public int[] nearestSmallerToRight(int[] arr, int n) {
    int[] result = new int[n];
    for(int i = 0; i < n; i++){
        result[i] = -1;
        for(int j = i+1; j < n; j++){
            if(arr[j] < arr[i]){
                result[i] = arr[j];
                break;
            }
        }
    }
    return result;
}
------------------
STACK
------------------
public int[] nearestSmallerToRight(int[] arr, int n) {
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    for(int i=n-1;i>=0;i++){
        if(stack.isEmpty())
            result[i]=-1;
        else if(stack.peek()<arr[i])
            result[i]=stack.peek();
        else{
            while(!stack.isEmpty() && stack.peek()>=arr[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty()? -1:stack.peek();
        }
        stack.push(arr[i]);
    }
    return result;
}