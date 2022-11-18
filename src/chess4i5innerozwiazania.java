import java.util.ArrayList;

public class chess4i5innerozwiazania {

    //##rozwiazanie1

    public static ArrayList<String> results = new ArrayList<>();


    public static void main(String[] args) {
        towers(4);
    }

    public static void towers(int x) {
        boolean[][] board = new boolean[x][x];
        towerCalc(board, 0);

        System.out.println("Liczba możliwych rozwiązań: " + results.size());
        for(String e : results){
            System.out.println("-".repeat(e.length()/3));
            System.out.println(e);
        }
    }

    public static void towerCalc(boolean[][] board, int row) {
        if (row == board.length) {
            results.add(printBoard(board));
        } else {
            for (int i = 0; i < board.length; i++) {
                if (canPlace(board, row, i)) {
                    board[row][i] = true;
                    towerCalc(board, row + 1);
                    board[row][i] = false;
                }
            }
        }
    }


    public static boolean canPlace(boolean[][] board, int row, int column) {
        for (int i = 0; i < board.length; i++){
            if (board[i][column] || board[row][i])
                return false;
        }

        return true;
    }



    public static String printBoard(boolean[][] board) {
        String text = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                text += board[i][j] ? "X" : ".";
                text += "\t";
            }
            text +="\n";
        }
        return text;
    }
}
