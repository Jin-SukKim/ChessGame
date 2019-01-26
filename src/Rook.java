import javax.swing.*;
/**
 * @author user
 *
 */
public class Rook implements Piece,java.io.Serializable{
    private ImageIcon rook;
    int xPosition;
    int yPosition;
    int validX;
    int validY;
    boolean color;
    public Rook(boolean color, int x, int y) {
        if (color)
            rook = new ImageIcon("src/chess icon/rookW.png");
        else
            rook = new ImageIcon("src/chess icon/rookB.png");
        this.color = color;
        this.xPosition = x;
        this.yPosition = y;
    }
    @Override
    public Icon getIcon() {
        return rook;
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
                    if(blocking(x, y)) {
                        for (int i=0; i<8; i++) {
                            if(validX==0 && validY==i)
                                return true;
                            if(validY==0 && validX==i)
                                return true;
                        }
                    }
                }
            } else {
                if(blocking(x, y)) {
                    for (int i=0; i<8; i++) {
                        if(validX==0 && validY==i)
                            return true;
                        if(validY==0 && validX==i)
                            return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean blocking(int x, int y) {
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
