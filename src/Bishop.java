import javax.swing.*;

/**
 * @author user
 *
 */
public class Bishop implements Piece,java.io.Serializable {
    private ImageIcon bishop;
    int xPosition;
    int yPosition;
    int validX;
    int validY;
    boolean color;

    public Bishop(boolean color, int x, int y) {
        if (color)
            this.bishop = new ImageIcon("src/chess icon/bishopW.png");
        else
            this.bishop = new ImageIcon("src/chess icon/bishopB.png");
        this.color = color;
        this.xPosition = x;
        this.yPosition = y;
    }

    @Override
    public Icon getIcon() {
        return bishop;
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
        if(validX==validY) {
            if(Board.turn() == this.color) {
                if (check) {
                    if(blocking(x, y)) {
                        if (color != this.color) 
                            return true;
                    }
                    return false;
                }
                return blocking(x,y);
            }  
        }
        return false;
    }
//
    public boolean blocking(int x, int y) {
        if (xPosition > x && yPosition < y) {
            for (int i =xPosition-1, j = yPosition+1; i > x; i--, j++) {
                if (Board.tiles[j][i].check()) {
                    return false;
                }
            }
        }
        if (xPosition < x && yPosition < y) {
            for (int i = xPosition+1, j = yPosition+1; i < x; i++, j++) {
                if (Board.tiles[j][i].check()) {
                    return false;
                }
            }
        }      
        if (xPosition > x && yPosition > y) {
            for (int i = xPosition-1, j = yPosition-1; i > x; i--, j--) {
                if (Board.tiles[j][i].check()) {
                    return false;
                }
            }
        }
        if (xPosition < x && yPosition > y) {
            for (int i = xPosition+1, j = yPosition-1; i < x; i++, j--) {
                if (Board.tiles[j][i].check()) {
                   return false;
                }
            }
        }
        return true;
    }
    @Override
    public boolean getColor() {
        return color;
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
