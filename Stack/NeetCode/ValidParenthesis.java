-------------
BRUTEFORCE
-------------
// O(N*N) O(N)
public boolean isValid(String s) {
    while(s.contains("()") || s.contains("[]") || s.contains("{}"))
    {
        s=s.replace("()","");
        s=s.replace("[]","");
        s=s.replace("{}","");
    }
    return s.isEmpty();
}
-------------
STACK
-------------

public boolean isValid(String s) {
    Stack<Character> sk = new Stack<>();
    for(char ch:s.toCharArray()){
        if(!sk.isEmpty() && sk.peek()==('(') && ch==(')'))sk.pop();
        else if(!sk.isEmpty() && sk.peek()==('{') && ch==('}'))sk.pop();
        else if(!sk.isEmpty() && sk.peek()==('[') && ch==(']'))sk.pop();
        else sk.push(ch);
    }
    return sk.isEmpty();
}
