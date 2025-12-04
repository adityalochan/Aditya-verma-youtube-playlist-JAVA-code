Rough : not finalized yet


------------------
BRUTEFORCE
------------------



------------------
SLIDING WINDOW
------------------

public int search(String pat, String txt) {
    HashMap<Character, Integer> map = new HashMap<>();

    // Build frequency map for pattern
    for (char c : pat.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int k = pat.length();        // window size
    int count = map.size();      // how many distinct chars still need to match
    int ans = 0;

    int i = 0, j = 0;

    while (j < txt.length()) {
        char chJ = txt.charAt(j);

        // If current char is part of pattern, decrease its count
        if (map.containsKey(chJ)) {
            map.put(chJ, map.get(chJ) - 1);
            if (map.get(chJ) == 0) {
                count--; // this character is fully matched
            }
        }

        // Expand window until its size is k
        if (j - i + 1 < k) {
            j++;
        }
        // When window size == k
        else if (j - i + 1 == k) {
            // If all chars matched, count this window as an anagram
            if (count == 0) {
                ans++;
            }

            // Now, before sliding, remove the effect of txt[i]
            char chI = txt.charAt(i);
            if (map.containsKey(chI)) {
                map.put(chI, map.get(chI) + 1);
                if (map.get(chI) == 1) {
                    count++; // this char is now "needed" again
                }
            }

            // Slide the window
            i++;
            j++;
        }
    }

    return ans;
}
