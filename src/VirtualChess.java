import java.util.Scanner;

public class VirtualChess {

    public enum Chessmen {
        WHITE_KING, WHITE_QUEEN, WHITE_ROOK, WHITE_BISHOP, WHITE_KNIGHT, WHITE_PAWN, BLACK_KING, BLACK_QUEEN, BLACK_ROOK, BLACK_BISHOP, BLACK_KNIGHT, BLACK_PAWN, EMPTY
    }

    public static Chessmen[][] chessboard = new Chessmen[8][8];

    public static void createBoard() {

        int rows = 8;
        int columns = 8;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((i == 0 && j == 0) || (i == 0 && j == 7)) {
                    chessboard[i][j] = Chessmen.BLACK_ROOK;
                } else if ((i == 0 && j == 1) || (i == 0 && j == 6)) {
                    chessboard[i][j] = Chessmen.BLACK_KNIGHT;
                } else if ((i == 0 && j == 2) || (i == 0 && j == 5)) {
                    chessboard[i][j] = Chessmen.BLACK_BISHOP;
                } else if (i == 0 && j == 3) {
                    chessboard[i][j] = Chessmen.BLACK_KING;
                } else if (i == 0 && j == 4) {
                    chessboard[i][j] = Chessmen.BLACK_QUEEN;
                } else if ((i == 7 && j == 0) || (i == 7 && j == 7)) {
                    chessboard[i][j] = Chessmen.WHITE_ROOK;
                } else if ((i == 7 && j == 1) || (i == 7 && j == 6)) {
                    chessboard[i][j] = Chessmen.WHITE_KNIGHT;
                } else if ((i == 7 && j == 2) || (i == 7 && j == 5)) {
                    chessboard[i][j] = Chessmen.WHITE_BISHOP;
                } else if (i == 7 && j == 3) {
                    chessboard[i][j] = Chessmen.WHITE_KING;
                } else if (i == 7 && j == 4) {
                    chessboard[i][j] = Chessmen.WHITE_QUEEN;
                } else if (i == 1) {
                    chessboard[i][j] = Chessmen.BLACK_PAWN;
                } else if (i == 6) {
                    chessboard[i][j] = Chessmen.WHITE_PAWN;
                } else {
                    chessboard[i][j] = Chessmen.EMPTY;
                }
            }
        }
    }

    public static void printBoard(Chessmen[][] chessboard) {
        int k = 8;
        System.out.print("   " + "\t" + "a" + "\t" + "b" + "\t" + "c" + "\t"
                + "d" + "\t" + "e" + "\t" + "f" + "\t" + "g" + "\t" + "h");
        for (int i = 0; i < 8; i++) {
            System.out.print("\n" + k);
            k--;
            for (int j = 0; j < 8; j++) {
                System.out.print("\t");
                switch (chessboard[i][j]) {
                case WHITE_KING:
                    System.out.print("\u2654");
                    break;
                case WHITE_QUEEN:
                    System.out.print("\u2655");
                    break;
                case WHITE_ROOK:
                    System.out.print("\u2656");
                    break;
                case WHITE_BISHOP:
                    System.out.print("\u2657");
                    break;
                case WHITE_KNIGHT:
                    System.out.print("\u2658");
                    break;
                case WHITE_PAWN:
                    System.out.print("\u2659");
                    break;
                case BLACK_KING:
                    System.out.print("\u265A");
                    break;
                case BLACK_QUEEN:
                    System.out.print("\u265B");
                    break;
                case BLACK_ROOK:
                    System.out.print("\u265C");
                    break;
                case BLACK_BISHOP:
                    System.out.print("\u265D");
                    break;
                case BLACK_KNIGHT:
                    System.out.print("\u265E");
                    break;
                case BLACK_PAWN:
                    System.out.print("\u265F");
                    break;
                case EMPTY:
                    System.out.print("");
                    break;

                } // switch

            } // / j for

        } // i for

    }

    public static void move(Chessmen[][] chessboard, String move) {



        char newj = move.charAt(6);
        int newi = Integer.parseInt(move.substring(7, 8));
        newi = -newi + 8;
        char oldj = move.charAt(0);
        int oldi = Integer.parseInt(move.substring(1, 2));
        oldi = -oldi + 8;

        switch (newj) {
        case 'a':
            newj = (int) 0;
            break;
        case 'b':
            newj = (int) 1;
            break;
        case 'c':
            newj = (int) 2;
            break;
        case 'd':
            newj = (int) 3;
            break;
        case 'e':
            newj = (int) 4;
            break;
        case 'f':
            newj = (int) 5;
            break;
        case 'g':
            newj = (int) 6;
            break;
        case 'h':
            newj = (int) 7;
            break;
        }

        switch (oldj) {
        case 'a':
            oldj = (int) 0;
            break;
        case 'b':
            oldj = (int) 1;
            break;
        case 'c':
            oldj = (int) 2;
            break;
        case 'd':
            oldj = (int) 3;
            break;
        case 'e':
            oldj = (int) 4;
            break;
        case 'f':
            oldj = (int) 5;
            break;
        case 'g':
            oldj = (int) 6;
            break;
        case 'h':
            oldj = (int) 7;
            break;
        }



        chessboard[newi][newj] = chessboard[oldi][oldj]; // Move
                                                                                            // piece
                                                                                            // to
                                                                                            // new
                                                                                            // position
        chessboard[oldi][oldj] = Chessmen.EMPTY;


    }

    public static boolean isValid(Chessmen[][] chessboard, int oldi,int oldj, int newi, int newj) {
        switch (chessboard[oldi][oldj]) {
        case WHITE_ROOK:
            if (oldi == newi || oldj == newj) {
                return true;
            } 
        case BLACK_ROOK : 
            if(oldi == newi || oldj == newj){
                return true;
            } 
        case WHITE_KNIGHT :
            if((newi==oldi-1 && newj==oldj+1)|| (newi==oldi-2 && newj==oldj-1)||(newi==oldi-2 && newj==oldj+1)
            ||(newi==oldi-1 && newj==oldj+2)||(newi==oldi+1 && newj==oldj+2)||(newi==oldi+2 && newj==oldj+1)|| 
            (newi==oldi+2 && newj==oldj-1)||(newi==oldi+1 && newj==oldj-2)){
                return true;
            }
        case BLACK_KNIGHT : 
            if((newi==oldi-1 && newj==oldj+1)|| (newi==oldi-2 && newj==oldj-1)||(newi==oldi-2 && newj==oldj+1)
                    ||(newi==oldi-1 && newj==oldj+2)||(newi==oldi+1 && newj==oldj+2)||(newi==oldi+2 && newj==oldj+1)|| 
                    (newi==oldi+2 && newj==oldj-1)||(newi==oldi+1 && newj==oldj-2)){
                        return true;
                    }
        case WHITE_BISHOP :
            for(int x =0;x<8;x++){
                if(newi==oldi+x && newj==oldj+x || newi==oldi-x && newj==oldj-x || newi==oldi+x && newj==oldj-x || newi==oldi-x && newj==oldj+x){
                    return true;
                }
            }
        case BLACK_BISHOP :
            for(int x =0;x<8;x++){
                if(newi==oldi+x && newj==oldj+x || newi==oldi-x && newj==oldj-x || newi==oldi+x && newj==oldj-x || newi==oldi-x && newj==oldj+x){
                    return true;
                }
            }
        case WHITE_KING :
            if((newi==oldi+1 && newj==oldj) ||
                    (newi==oldi+1 && newj==oldj+1) ||
                    (newi==oldi && newj==oldj+1) ||
                    (newi==oldi-1 && newj==oldj) ||
                    (newi==oldi-1 && newj==oldj-1) ||
                    (newi==oldi && newj==oldj-1) ||
                    (newi==oldi-1 && newj==newj+1) ||
                    (newi==oldi-1 && newj==newj+1) ){
                return true;
            }
        case BLACK_KING :
            if((newi==oldi+1 && newj==oldj) ||
                    (newi==oldi+1 && newj==oldj+1) ||
                    (newi==oldi && newj==oldj+1) ||
                    (newi==oldi-1 && newj==oldj) ||
                    (newi==oldi-1 && newj==oldj-1) ||
                    (newi==oldi && newj==oldj-1) ||
                    (newi==oldi-1 && newj==newj+1) ||
                    (newi==oldi-1 && newj==newj+1) ){
                return true;
            }
        case WHITE_PAWN : 
            if(oldi==6 && newi<=4){
                return true;
            }
            else if(newi==oldi-1){
                return true;
            }
        case BLACK_PAWN :
            if(oldi==1 && newi<=3){
                return true;
            }
            else if(oldi==newi-1){
                return true;
            }

        default: return false;

        } 
    }

    public static void main(String[] args) {

        createBoard();

        Scanner in = new Scanner(System.in);

        String command;

        while (!in.equals("exit")) {
            printBoard(chessboard);
            System.out.println("Please enter a move.");
            command = in.nextLine();
            move(chessboard, command);
        }
    }
}