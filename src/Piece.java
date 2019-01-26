import javax.swing.Icon;

/**
 * @author user
 *
 */
public interface Piece {
    Icon getIcon();
    boolean validMove(int x, int y, boolean check, boolean color);
    void setPosition(int x, int y);
    boolean getColor();
    int validX();
    int validY();
}
