import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author user
 *
 */
public class Board  extends JPanel implements java.io.Serializable {
    public static int turn = 0;
    public static Square[][] tiles;
    public static Board sourceB;
    int count = 0;
    int boardNum;
    public Board(int num) {
        tiles = new Square[8][8];
        setLayout(new GridLayout(8,8));
        for(int i = 0; i < 8; i++) {
            for(int j = 0;j <8;j++) {
                tiles[i][j] = new Square(j, i, boardNum);
                if((i+j)%2!=0)
                    tiles[i][j].setBackground(Color.black);
                else
                    tiles[i][j].setBackground(Color.white);
                add(tiles[i][j]);
            }
        }
        this.boardNum = num;
    }   
    
    /**
     * It sets initial position of pieces.
     */
    public void initialposition() {
        tiles[0][0].initialize(false, "rook");
        tiles[0][1].initialize(false, "knight");
        tiles[0][2].initialize(false, "bishop");
        tiles[0][3].initialize(false, "queen");
        tiles[0][4].initialize(false, "king");
        tiles[0][5].initialize(false, "bishop");
        tiles[0][6].initialize(false, "knight");
        tiles[0][7].initialize(false, "rook");
        for (int i = 0; i < 8; i++) {
            tiles[1][i].initialize(false, "pawn");
        }
        tiles[7][0].initialize(true, "rook");
        tiles[7][1].initialize(true, "knight");
        tiles[7][2].initialize(true, "bishop");
        tiles[7][3].initialize(true, "queen");
        tiles[7][4].initialize(true, "king");
        tiles[7][5].initialize(true, "bishop");
        tiles[7][6].initialize(true, "knight");
        tiles[7][7].initialize(true, "rook");
        for (int i = 0; i < 8; i++) {
            tiles[6][i].initialize(true, "pawn");
        }   
    }
    public void clear() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0;j <8;j++) {
             tiles[i][j].remove();
             tiles[i][j].setIcon(null);
            }
        }
        turn = 0;
    }
//    public void setAction() {
//        for(int i = 0; i < 8; i++) {
//            for(int j = 0;j <8;j++) {
//                tiles[i][j].addActionListener(new Event());
//            }
//        }
//    }
    public static boolean turn() {
        if(turn%2==0)
            return true;
        return false;
    }
}
