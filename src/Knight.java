import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @author user
 *
 */
public class Knight implements Piece,java.io.Serializable {
    private ImageIcon knight;
    int xPosition;
    int yPosition;
    int validX;
    int validY;
    boolean color;
    public Knight(boolean color, int x, int y) {
        if (color)
            knight = new ImageIcon("src/chess icon/knightW.png");
        else
            knight = new ImageIcon("src/chess icon/knightB.png");
        this.color = color;
        this.xPosition = x;
        this.yPosition = y;
    }
    @Override
    public Icon getIcon() {
        return knight;
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

    @Override
    public boolean getColor() {
        return color;
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
        int validX = Math.abs(xPosition - x);
        int validY = Math.abs(yPosition - y);
        if(Board.turn() == this.color) {
            if(check) {
                if (this.color != color)
                    return ((validX==1 && validY==2) || (validX==2 && validY==1) ? true : false);
                return false;
            }
            return ((validX==1 && validY==2) || (validX==2 && validY==1) ? true : false);
        }
        return false;
    }
    public boolean blocking(int x, int y) {
        // TODO Auto-generated method stub
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
