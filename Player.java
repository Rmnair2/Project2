public class Player {
    private String name;
    private int wins;
    private XOPiece xOPiece;

    public Player(){
        name = "";
        wins = 0;
        xOPiece = new XOPiece();
    }

    public Player(String n, int w, XOPiece piece){
        name = n;
        wins = w;
        xOPiece = piece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public XOPiece getxOPiece() {
        return xOPiece;
    }

    public void setxOPiece(XOPiece xOPiece) {
        this.xOPiece = xOPiece;
    }

}