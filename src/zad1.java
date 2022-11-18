import java.util.ArrayList;
import java.util.List;

public class zad1 {
    public static void main(String[] args) {

        //decomposition(3);
        //zadRozkladNaSumy.decompose(4);
        queens(4);

    }

    public static int factorial(int x) {


        if (x>1) {
            return x*factorial(x-1);
        } else {
            return 1;
        }
    }

    public static int fibonacci(int x) {

        if(x==0) return 0;
        else if(x==1) return 1;
        else {
            return fibonacci(x-1)+fibonacci(x-2);
        }
    }


    public static void queens(int x){
        int[][] board = new int[x][x];

        int numOfRes = 0;

        for(int i = 0; i< board.length; i++) {
            numOfRes+=queens(board, i, numOfRes);
        }

        System.out.println(numOfRes);
    }



    public static boolean queens(int[][] board, int col, int num) {


        if (col > board.length) return true;

        for(int r = 0; r<board.length; r++) {

            if(queensIsSafe(board, r, col)) {
                board[r][col] = 1;

                if (queens(board, col + 1, num) > num) {
                    //num=+1;
                    return true;
                }

                board[r][col] = 0;
            }

        }
            return num;
    }

    public static boolean queensIsSafe(int[][] board, int row, int col) {

        int i,j;

        for(i=0; i<col; i++) {
            if (board [row][i] == 1) return false;
        }

        for(i = row, j = col; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        for(i = row, j = col; i<board.length && j>=0; i++, j--) {
            if (board[i][j] == 1) return  false;
        }

        return true;

    }







//    public static void decomposition(int x) {
//
//        List<List<Integer>> result;
//        int[] summands = new int[x];
//
//        for(int s = 1; s < x; s++) {
//            summands[s-1] = s;
//        }
//
//        List<Integer> tempSums = new ArrayList<>();
//        List<List<Integer>> sums = new ArrayList<>();
//
//
//
//        System.out.println(getSummands(x, tempSums, summands, sums));
//
//    }

    //4 / 1
//    public static List<List<Integer>> getSummands(int number, List<Integer> tempSums) {
//
//        int sum = 0;
//        //sums = new ArrayList<>(sums);
//
//        for(int summand : tempSums) {
//            sum+=summand;
//        }
//
//        if(sum<number) {
//            for(int i : summands) {
//                if(sum+i <= number) {
//                    List<Integer> newTempSums = new ArrayList<>(tempSums);
//                    getSummands(number, newTempSums, summands, sums);
//                }
//            }
//
//        } else if(sum==number) {
//            sums.add(tempSums);
//        }
//
//        return sums;
//    }
}