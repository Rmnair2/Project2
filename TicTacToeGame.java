import java.util.Scanner;

public class TicTacToeGame
{
    static int currentPlayer = 0;

    public static void main(String[] args)
    {
        //introduce name and rules:

        //also add players and pieces:
        Player[] player = new Player[2];
        Scanner sc = new Scanner(System.in);
        String name;


            for (int i = 1; i < 3; i++) {
                System.out.println("Enter name of Player " + i + ":");
                name = sc.next();
                if (i == 1) {
                    player[i - 1] = new Player(name, 0, new XOPiece(XOPiece.XO.X));
                } else {
                    player[i - 1] = new Player(name, 0, new XOPiece(XOPiece.XO.O));

                }
            }
        int playAgain = 1;
        while(playAgain == 1) {
            SquareBoard board = new SquareBoard(3, new XOPiece());
            board.printBoardCoordinates();
            System.out.println(board);


            //game logic loop
            String userInput;
            int row, column;
            for (int i = 0; i < 9; i++) {
                int otherPlayer = (currentPlayer == 1) ? 0 : 1;
                System.out.println("Player " + player[currentPlayer].getName() + "'s turn");
                System.out.println("Enter the position you wish to place your piece (row  column): ");
                userInput = sc.next();
                String[] inputPosition = userInput.split(",", 0);
                row = Integer.valueOf(inputPosition[0]);
                column = Integer.valueOf(inputPosition[1]);

                //check setter
                while (!(board.setPiece(player[currentPlayer].getxOPiece(), row, column))) {
                    System.out.println("There is already a piece in that position. Choose new position: ");
                    userInput = sc.next();
                    inputPosition = userInput.split(",", 0);
                    row = Integer.valueOf(inputPosition[0]);
                    column = Integer.valueOf(inputPosition[1]);
                }
                System.out.println(board);
                if (board.checkWin(player[currentPlayer].getxOPiece())) {
                    //player turn
                    System.out.println("Player " + player[currentPlayer].getName() + " has won!");
                    System.out.println();1

                    int currentWins = player[currentPlayer].getWins();
                    currentWins++;
                    player[currentPlayer].setWins(currentWins);
                    System.out.println("Player " + player[currentPlayer].getName() + " has " + currentWins + " wins!");

                    //other player
                    System.out.println("Player " + player[otherPlayer].getName() + " has " + player[otherPlayer].getWins() + " wins!");
                    break;
                }

                if (!(board.checkWin(player[currentPlayer].getxOPiece())) && board.checkBoardFull()) {
                    System.out.println("The game has ended in a tie.");
                    System.out.println("Player " + player[currentPlayer].getName() + " has " + player[currentPlayer].getWins() + " wins!");
                    System.out.println("Player " + player[otherPlayer].getName() + " has " + player[otherPlayer].getWins() + " wins!");
                    break;
                }
                changePlayer();
            }
            System.out.println("Play Again? Enter 1 for yes and 0 for no: ");
            playAgain = sc.nextInt();

        }

    }

    public static void changePlayer(){
        if (currentPlayer == 0){
            currentPlayer = 1;
        }
        else{
            currentPlayer = 0;
        }
    }

}

/* Here is the output for printBoardCoordinates
 * and an empty board
 * followed by a sample outcome of a finished game
 * FEEL FREE TO CHANGE HOW YOUR OUTPUT LOOKS
 */