import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @author user
 *
 */
public class Pawn implements Piece,java.io.Serializable {
    private ImageIcon pawn; 
    int xPosition;
    int yPosition;
    int validX;
    int validY;
    boolean color;
    public Pawn(boolean color, int x, int y) {
        if (color)
            pawn = new ImageIcon("src/chess icon/pawnW.png");
        else
            pawn = new ImageIcon("src/chess icon/pawnB.png");
        this.color = color;
        this.xPosition = x;
        this.yPosition = y;
    }
    @Override
    public Icon getIcon() {
        return pawn;
    }

    @Override
    public boolean getColor() {
        return color;
    }
    /**
     * where the piece is.
     * @see Piece#setPosition(int, int)
     * @param x position
     * @param y position
     */
    @Override
    public void setPosition(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }
    /**
     * check it is valid movement with piece position and next square position.
     * @see Piece#validMove(int, int, boolean, boolean)
     * @param x position
     * @param y position
     * @param check square has piece or not
     * @param color other piece's color
     * @return
     */
    @Override
    public boolean validMove(int x, int y, boolean check, boolean color) {
        this.validX = Math.abs(x-xPosition);
        this.validY = Math.abs(y - yPosition);
        if(Board.turn() == this.color) {
                if (this.color) {
                    if (check) {
                        if(color != this.color)
                            return (Math.abs(yPosition - y)==Math.abs(xPosition - x) ? true : false);
                        return false;
                    }
                    if (yPosition == 6) {
                        if (yPosition-2==y && xPosition==x) {
                            if(!Board.tiles[yPosition-1][xPosition].check())
                                return true;
                        }
                        if (yPosition-1==y && xPosition==x)
                            return true;
                        return false;
                    }
                    return (yPosition-1==y && xPosition==x ? true : false);
                } else {
                    if (check) {
                        if(color != this.color)
                            return (Math.abs(yPosition - y)==Math.abs(xPosition - x) ? true : false);
                        return false;
                    }
                    if (yPosition == 1) {
                        if (yPosition+2==y && xPosition==x) {
                            if(!Board.tiles[yPosition+1][xPosition].check())
                                return true;
                        }
                        if (yPosition+1==y && xPosition==x)
                            return true;
                        return false;
                    }
                    return (yPosition+1==y && xPosition==x ? true : false);
                }
            }
            return false;
    }
    @Override
    public int validX() {
        return this.validX;
    }
    @Override
    public int validY() {
        return this.validY;
    }

}
