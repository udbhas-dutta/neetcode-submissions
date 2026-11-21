class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowZero = false;
        int rows = matrix.length, cols = matrix[0].length;

        for(int i = 0; i< rows; i++){
            for(int j = 0; j<cols; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    if(i > 0){
                        matrix[i][0] = 0;
                    } else {
                        rowZero = true;
                    }
                } 
            }
        }
        for(int r = 1; r < rows; r++){
            for(int c = 1; c<cols; c++){
                if(matrix[r][0] == 0 || matrix [0][c] == 0){
                    matrix[r][c] = 0;
                }
            }
        }
        
        if(matrix[0][0] == 0){
            for(int r = 0; r<rows; r++){
                matrix[r][0] = 0;
            }
        }

        if(rowZero){
            for(int c = 0; c< cols; c++){
                matrix[0][c] = 0;
            }
        }
    }
}
