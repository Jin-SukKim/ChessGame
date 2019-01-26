import javax.swing.*;
/**
 * 
 * @author user
 *
 */
public class Square extends JButton implements java.io.Serializable {
    public static Square data;
    int x;
    int y;
    private Piece piece;
    int baoardNum;
    boolean color;
    JButton confirm = new JButton();
    int count = 0;
    public Square(int x, int y, int boardNum) {
        this.addActionListener(new Event());
        this.x = x;
        this.y = y;
        this.baoardNum = boardNum;
    }
    /**
     * this sets piece on a square with color.
     * @param color boolean
     * @param pieces - chess pieces
     */
    public void initialize(boolean color, String pieces) {
        this.color = color;
        switch(pieces) {
        case "pawn" :
            piece = new Pawn(color, x, y);
            break;
        case "rook" :
            piece = new Rook(color, x, y);
            break;
        case "bishop" :
            piece = new Bishop(color, x, y);
            break;
        case "knight" :
            piece = new Knight(color, x, y);
            break;
        case "king" :
            piece = new King(color, x, y);
            break;
        case "queen" :
            piece = new Queen(color, x, y);
            break;
         default:
             piece = null;
             break;
        }
        setIcon(piece.getIcon());
    }
    /**
     * It returns piece on the square.
     * @return piece
     */
    public Piece getPiece() {
        return piece;
    }
    /**
     * Removes piece on a square.
     */
    public void remove() {
        this.piece = null;
    }
    /**
     * Sets new piece that moved.
     * @param piece - chess piece
     */
    public void move(Piece piece) {
        this.piece = piece;
    }
    /**
     * Check the square has a piece or not.
     * @return boolean
     */
    public boolean check() {
        return (piece != null ? true : false);
    }
    /**
     * check piece movement.
     * @param validSquare - next square to move
     * @return boolean
     */
    public boolean validPosition(Square validSquare) {
        if (piece.validMove(validSquare.x, validSquare.y, validSquare.check(), validSquare.color)) {
            piece.setPosition(validSquare.x, validSquare.y);
            return true;
        }
        return false;
    }
    public int getBoard() {
        return this.baoardNum;
    }
    public boolean valid3D(int x, int y, int boardNum) {
        if(boardNum == this.baoardNum)
            return true;
        if(x==0&&y==0)
            return false;
        if(x==1&&(1==Math.abs(boardNum-this.baoardNum)))
                return true;
        if(y==1&&(1==Math.abs(boardNum-this.baoardNum)))
                return true;
        else {
            if(x==2||y==2)
                return true;
        }
        return false;
    }
}
