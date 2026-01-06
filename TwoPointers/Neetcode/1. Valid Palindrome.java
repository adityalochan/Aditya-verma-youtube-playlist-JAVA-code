------------------
BRUTEFORCE 1 : O(N), O(N)
------------------
public boolean isPalindrome(String s) {
    s=s.toLowerCase();
    s=s.replaceAll(" ","");
    s=s.replaceAll("[^A-Za-z0-9]","");

    int l=0;
    int r=s.length()-1;
    while(l<=r){
        if(s.charAt(l)!=s.charAt(r)) return false;
        l++;
        r--;
    }
    return true;
}
------------------
BRUTEFORCE 2 : O(N), O(N)
------------------
public boolean isPalindrome(String s) {
    s=s.toLowerCase();
    s=s.replaceAll(" ","");
    s=s.replaceAll("[^A-Za-z0-9]","");

    StringBuilder sb = new StringBuilder(s);
    sb=sb.reverse();
    return s.equals(sb.toString());
}