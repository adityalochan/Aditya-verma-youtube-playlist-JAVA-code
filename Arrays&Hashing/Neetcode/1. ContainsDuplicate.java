------------
BRUTEFORCE
------------    
// T:O(N*N) | S:O()
public boolean containsDuplicate(int[] nums) {
    for(int i=0;i<nums.length;i++){
        int a=nums[i];
        for(int j=i+1;j<nums.length;j++){
            int b=nums[j];
            if(a==b) return true;;
        }
    }
    return false;
}
------------
SORTING
------------
// T:O() | S:O()
public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for(int i=0;i<nums.length-1;i++){
        if(nums[i]==nums[i+1])return true;
    }
    return false;
}
----------
HASHSET
----------
// T:O() | S:O()
public boolean containsDuplicate(int[] nums) {
    Set<Integer> hs = new HashSet<>();
    for(int num:nums){
        if(hs.contains(num))return true;
        else hs.add(num);
    }
    return false;
}
