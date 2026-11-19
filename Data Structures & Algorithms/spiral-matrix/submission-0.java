class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0, bottom = matrix.length;
        int left = 0, right = matrix[0].length;
        
        while(left < right && top < bottom){
            //left -> right
            for(int i = left; i<right; i++){
                ans.add(matrix[top][i]);
            }
            top++;

            //top -> bottom
            for(int i = top; i<bottom; i++){
                ans.add(matrix[i][right-1]);
            }
            right--;

            if(left >= right || top >= bottom) break;

            //right -> left
            for(int i = right-1; i>= left; i--){
                ans.add(matrix[bottom-1][i]);
            }
            bottom--;

            //down -> up
            for(int i = bottom-1; i>=top; i--){
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
