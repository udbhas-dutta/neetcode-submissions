class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        int ans = 0;
        while(x != 0){
            int digit = x%10;

            if(ans > max/10 || ans == max/10 && digit > max % 10) return 0;
            if(ans < min/10 || ans == min/10 && digit < min % 10) return 0;

            ans = (ans*10)+digit;

            x/=10;
        }
        return ans;
    }
}
