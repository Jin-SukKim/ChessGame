import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @author user
 *
 */
public class King implements Piece,java.io.Serializable {
    private ImageIcon king;
    int xPosition;
    int yPosition;
    int validX;
    int validY;
    boolean color;
    public King(boolean color, int x, int y) {
        if (color)
            this.king = new ImageIcon("src/chess icon/kingW.png");
        else
            this.king = new ImageIcon("src/chess icon/kingB.png");
        this.color = color;
        this.xPosition = x;
        this.yPosition = y;
    }
    @Override
    public Icon getIcon() {
        return king;
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
        int validX = Math.abs(xPosition - x);
        int validY = Math.abs(yPosition - y);
        if(Board.turn() == this.color) {
            if(check) {
                if (this.color != color) {
                    for(int i=0; i<2;i++) {
                        for(int j=0; j<2; j++) {
                            if(validX==i && validY==j)
                                return true;
                        }
                    }
                }
                return false;
            }
            for(int i=0; i<2;i++) {
                for(int j=0; j<2; j++) {
                     if(validX==i && validY==j)
                         return true;
                }
            }
            return false;
        }return false;
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
