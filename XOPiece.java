public class XOPiece
{
    /** enumerated type that dictates the two values of
     * tic tac toe
     */
    public static enum XO {X, O, E}
    private XO userPiece;
    String input = "";

    /** Constructor to hold an empty piece
     * that is neither X or O. An empty
     * piece should just display 3 spaces
     */
    public XOPiece()
    {
        //FIX ME//
        userPiece = XO.E;
    }

    /** Constructor that creates a piece for
     * the TicTacToe board -- either an X or O
     * See sample output.
     */
    public XOPiece(XO choice)
    {
        //FIX ME//
        userPiece = choice;
    }

    public XO getPiece()
    {
        return userPiece;
    }

    public void setPiece(XO choice)
    {
        userPiece = choice;
    }

    public String toString()
    {
        String returnString = " ";
        if (userPiece==XO.X){
            returnString="-X-";
        }else if (userPiece==XO.O){
            returnString="-O-";
        }else if (userPiece==XO.E) {
            returnString="   ";
        }
        return returnString;
    }

    /** Method that checks if one XOPiece has the same XO value.
     * If the calling object has the same internal XO value as the
     * object sent as a formal parameter.
     */

    public boolean match(XOPiece piece)
    {
        if (userPiece.equals(piece.getPiece()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}