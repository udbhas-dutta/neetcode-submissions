class Solution {
    public boolean exist(char[][] board, String word) {
        boolean vis[][] = new boolean[board.length][board[0].length];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(helper(board, word, i, j, new StringBuilder(), vis) == true) return true;
            }
        }
        return false;
    }
    public boolean helper(char[][] board, String word, int i, int j, StringBuilder sb, boolean[][]vis){
        //base case
        if(sb.toString().equals(word)) return true;

        if(i<0 || j <0 || i==board.length || j==board[0].length) return false;
        if(sb.length()>0 && sb.charAt(sb.length()-1) != word.charAt(sb.length()-1)) return false;
        if(vis[i][j] == true) return false;

        vis[i][j] = true;
        sb.append(board[i][j]);
        if(helper(board, word, i+1, j, sb, vis)||helper(board, word, i-1, j, sb, vis) || helper(board, word, i, j+1, sb, vis) || helper(board, word, i, j-1, sb, vis) == true ) return true;
        sb.deleteCharAt(sb.length()-1);
        vis[i][j] = false;  

        return false;      
    }
}
