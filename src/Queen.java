import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @author user
 *
 */
public class Queen implements Piece,java.io.Serializable {
    private ImageIcon queen;
    int xPosition;
    int yPosition;
    int validX;
    int validY;
    boolean color;
    /**
     * @param args
     */
    public Queen(boolean color, int x, int y) {
        if (color)
            queen = new ImageIcon("src/chess icon/queenW.png");
        else
            queen = new ImageIcon("src/chess icon/queenB.png");
        this.color = color;
        this.xPosition = x;
        this.yPosition = y;
        
    }
    @Override
    public Icon getIcon() {
        return queen;
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
        this.validX = Math.abs(xPosition - x);
        this.validY = Math.abs(yPosition - y);
        if(Board.turn() == this.color) {
            if(check) {
                if (this.color != color) {
                    if (validX==validY)
                        return blocking(x,y);
                    else {
                        if(straight(x,y)) {
                            for (int i=0; i<8; i++) {
                                if(validX==0 && validY==i)
                                    return true;
                                if(validX==i && validY==0)
                                    return true;
                            }
                        }
                    }
                }
            } else {
                if (validX==validY)
                    return blocking(x,y);
                else {
                    if(straight(x,y)) {
                        for (int i=0; i<8; i++) {
                            if(validX==0 && validY==i)
                                return true;
                            if(validX==i && validY==0)
                                return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }
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
    public boolean straight(int x, int y) {
        if (xPosition < x) {
            for(int i=xPosition+1;i<x;i++) {
                if(Board.tiles[yPosition][i].check())
                    return false;
            }
        }
        if(xPosition > x) {
            for(int i=xPosition-1;i>x;i--) {
                if(Board.tiles[yPosition][i].check())
                    return false;
            }
        }
        if(yPosition < y) {
            for(int i=yPosition+1;i<y;i++) {
                if(Board.tiles[i][xPosition].check())
                    return false;
            }
        }
        if(yPosition > y) {
            for(int i=yPosition-1;i>y;i--) {
                if(Board.tiles[i][xPosition].check())
                    return false;
            }
        }
        return true;
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
