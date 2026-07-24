package Agoda;

public class ChessBoard {


    public static void printBoard(int boardSize){

        for(int row=0;row<boardSize;row++){
            for(int col=0;col<boardSize;col++){
                if((row+col)%2==0){
                    System.out.print("* ");
                } else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        printBoard(8);
    }


}
