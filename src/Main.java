import java.util.Scanner;
public class Main {
    private static final int ROWS=3;
    private static final int COLS=3;
    private static String[][] board = new String[ROWS][COLS];
    private static int moveCnt=0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String player="X";
        int row,col=-1;
        clearBoard();
        display();
        String userRes="";

        do {

            do {
                while (true) {
                    System.out.println("Enter Move for " + player);
                    row = SafeInput.getRangedInt(in, "Enter Row", 1, 3) - 1;
                    col = SafeInput.getRangedInt(in, "Enter Row", 1, 3) - 1;
                    if (isValidMove(row, col)) {
                        board[row][col] = player;
                        moveCnt++;
                        display();
                        break;
                    }else{
                        System.out.println("Invalid move. Try again!");
                    }
                }

                //toggle between the players
                if (isWin(player)) {
                    System.out.println("Player " + player + " wins!");
                    break;
                } else if (isTie()) {
                    System.out.println("We've got a tie!");
                    break;
                }
                if (player.equals("X")) {
                    player = "O";
                } else {
                    player = "X";
                }

            } while (moveCnt < 9);

            clearBoard();
            System.out.println("Do you want to play again?");
            userRes = in.nextLine();

        }while (userRes.equalsIgnoreCase("y"));
        in.close();
    }
    private static void clearBoard(){
        for(int row=0;row<ROWS;row++){
            for (int col=0;col<COLS;col++){
                board[row][col]=" ";
            }
        }
        moveCnt=0;
    }
    private static void display(){
        for(int row=0;row<ROWS;row++){
            for (int col=0;col<COLS;col++){
                System.out.print(board[row][col]);
                if(col<2){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
    private static boolean isValidMove(int row,int col){
        return board[row][col].equals(" ");
    }
    private static boolean isWin(String player){
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player)){
            return true;
        }
        return false;
    }
    private static boolean isRowWin(String player){
        for (int row=0;row<ROWS;row++){
            if(board[row][0].equals(player)&& board[row][1].equals(player)&&board[row][2].equals(player)){
                return true;
            }
        }
        return false;
    }
    private static boolean isColWin(String player){
        for (int col=0;col<COLS;col++){
            if((board[0][col]).equals(player) && board[1][col].equals(player) && board[2][col].equals(player)){
                return true;
            }
        }
        return false; //implement this
    }
    private static boolean isDiagonalWin(String player){
        if (board[0][0].equals(player)&&board[1][1].equals(player)&&board[2][2].equals(player)){
            return true;
        } else if (board[0][2].equals(player)&&board[1][1].equals(player)&&board[2][0].equals(player)) {
            return true;
        }
        return false; //implement this
    }
    private static boolean isTie() {
        return moveCnt==9;
    }
}