class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i] ){
                int curr = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int area = heights[curr] * (nse-pse-1);
                ans = Math.max(area, ans);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int curr = stack.pop();
            int nse = heights.length;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int area = heights[curr] * (nse-pse-1);
            ans = Math.max(ans, area);
        }
        return ans;
    }
}
