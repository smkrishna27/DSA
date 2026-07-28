package medium.dp;

public class WordSearchBackTrack {

    public static void main(String[] args) {
        //Input:
        //board = [
        //  ["A","B","C","D"],
        //  ["S","A","A","T"],
        //  ["A","C","A","E"]
        //],
        //word = "CAT"

        char[][] board = {
                {'A', 'B', 'C', 'D'},
                {'S', 'A', 'A', 'T'},
                {'A', 'C', 'A', 'E'}
        };

        System.out.println(exist(board, "CAT"));


    }

    public static boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backtrack(board, word, i, j, 0)) return true;
            }
        }

        return false;


    }

    private static boolean backtrack(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length && board[i][j] != word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean result = backtrack(board, word, i - 1, j, index + 1) ||
                backtrack(board, word, i + 1, j, index + 1) ||
                backtrack(board, word, i, j - 1, index + 1) ||
                backtrack(board, word, i, j + 1, index + 1);
        board[i][j] = temp;
        return result;


    }
}
