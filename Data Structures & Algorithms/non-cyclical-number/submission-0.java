class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        sum = helper(n);
        set.add(sum);
        while(true){
            sum = helper(sum);
            if(sum == 1) return true;
            if(set.contains(sum)) return false;
            else set.add(sum);
        }
    }
    public int helper(int n){
        int sum = 0;
        while(n!=0){
            int rem = n%10;
            sum+=(int)Math.pow(rem,2);
            n/=10;
        }
        return sum;
    }
}
