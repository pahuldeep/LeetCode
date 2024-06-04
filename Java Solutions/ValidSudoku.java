/**
 * 36. Valid Sudoku
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        //Check row
        for(int i = 0; i < 9; i++){
            int[] arr = new int[10];
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(++arr[Character.getNumericValue(board[i][j])] > 1){
                        return false;
                    }
                }
            }   
        }

        //check col
        for(int i = 0; i < 9; i++){
            int[] arr = new int[10];
            for(int j = 0; j < 9; j++){
                if(board[j][i] != '.'){
                    if(++arr[Character.getNumericValue(board[j][i])] > 1){
                        return false;
                    }
                }
            }   
        }

        //check each box
        for(int x = 0; x <= 6; x=x+3){
            for(int y = 0; y <= 6; y=y+3){
                int[] arr = new int[10];
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        if(board[i+x][j+y] != '.'){
                            if(++arr[Character.getNumericValue(board[i+x][j+y])] > 1){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        return true;
    }
}