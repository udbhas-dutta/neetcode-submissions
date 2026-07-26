class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length-1;
        int ans = Integer.MIN_VALUE;
        while(i<=j){
            int a = heights[i], b = heights[j];
            int vol = Math.min(a,b)* (j-i);
            ans = Math.max(ans, vol);
            if(a > b) j--;
            else i++;
        }
        return ans;
    }
}
