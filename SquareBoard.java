import java.util.Objects;

public class SquareBoard {
        int size;
        //create gameboard
        XOPiece [][]gameBoard;

        /**
         * Constructor that creates an n x n board of
         * XOPieces and each XOPiece is set to an initial Token
         */
        public SquareBoard(int n, XOPiece e)
        {
            /* FIX ME */
            gameBoard = new XOPiece[n][n];
            for (int i = 0; i < gameBoard.length; i++)
            {
                for (int j = 0; j < gameBoard[i].length; j++)
                {
                    gameBoard[i][j] = new XOPiece();
                }
            }
        }
        public SquareBoard(){
            gameBoard = new XOPiece[3][3];
            for (int i = 0; i < gameBoard.length; i++)
            {
                for (int j = 0; j < gameBoard[i].length; j++)
                {
                    gameBoard[i][j] = new XOPiece();
                }
            }

        }

        /**
         * String representation of the board
         * showing the contents of each space
         */
        public String toString()
        {
            /* FIX ME */
            String returnBoard = "";
            for (int i = 0; i < gameBoard.length; i++)
            {
                for (int j = 0; j < gameBoard[i].length; j++)
                {
                    returnBoard += ("[" + gameBoard[i][j] + "] ");
                }
                returnBoard += "\n";
            }
            returnBoard += "\n";

            return returnBoard;
        }

        /**
         * Method that prints out the board with
         * the coordinates of each slot
         * to show the users how to identify each slot
         */
        public void printBoardCoordinates()
        {
            for (int i=0; i<gameBoard.length; i++)
            {
                for (int j=0; j<gameBoard[i].length; j++)
                {
                    System.out.print("["+i+","+j+"] ");
                }
                System.out.println();
            }
            System.out.println();
        }

        /**
         * Sets a Token on the board with coordinates (i,j)
         */
        public boolean setPiece(XOPiece t, int i, int j)
        {
            /* FIX ME */
            if (gameBoard[i][j].getPiece().equals(new XOPiece().getPiece())) {
                gameBoard[i][j] = t;
                return true;
            } else {
                return false;
            }
        }

        /**
         * Gets an item on the board with coordinates (i,j)
         */
        public XOPiece getPiece(int i, int j)
        {
            /* FIX ME */
            return gameBoard[i][j];
        }

        public boolean checkWin(XOPiece piece){
            //incomplete- finish logic
            boolean result = false;

            //case 1: diagonal left to right
            int counter = 0;
            for (int i=0; i<gameBoard.length; i++)
            {
                for (int j=0; j<gameBoard[i].length; j++)
                {
                    if (gameBoard[i][j].equals(piece) && (i==j)) {
                        counter++;
                    }
                    }
                }
            if (counter == 3) {
                result = true;
            }

            //case 2: rows
            counter = 0;
            for (int i=0; i<gameBoard.length; i++)
            {
                counter = 0;
                for (int j=0; j<gameBoard[i].length; j++)
                {
                    if (gameBoard[i][j].equals(piece)) {
                        counter++;
                    }
                }
                if (counter == 3) {
                    break;
                }
            }
            if (counter == 3) {
                result = true;
            }

            //case 2: columns
            counter = 0;
            for (int j=0; j <= (gameBoard.length - 1); j++)
            {
                for (int i=0; i <= (gameBoard.length - 1); i++)
                {
                    if (gameBoard[i][j].equals(piece)) {
                        counter++;
                    }
                }
                if (counter == 3) {
                    break;
                }
                counter = 0;
            }
            if (counter == 3) {
                result = true;
            }

            //case 4: diagonal right to left
            counter = 0;
            int row = 0;
            int column = 2;
            for (int i=0; i<gameBoard.length; i++)
            {
                for (int j=(gameBoard[i].length - 1); j>=0; j--)
                {
                    if ((gameBoard[i][j].equals(piece)) && (i == row) && (j == column)) {
                        counter++;
                        break;
                    }
                }
                row++;
                column--;
            }
            if (counter == 3) {
                result = true;
            }

            return result;
            }




        public boolean checkBoardFull(){
            boolean resultFull = true;
            for (int i=0; i<gameBoard.length; i++)
            {
                for (int j=0; j<gameBoard[i].length; j++)
                {
                    if(gameBoard[i][j].getPiece().equals(new XOPiece().getPiece())){
                        resultFull = false;
                        break;
                    }
                }
            }
                return resultFull;
        }


}

