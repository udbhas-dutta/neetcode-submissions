class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = helper(n);
        while(slow != fast){
            fast = helper(fast);
            fast = helper(fast);
            slow = helper(slow);
        }
        return fast == 1;
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
