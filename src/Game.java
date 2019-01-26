import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

/**
 * @author user
 *
 */
public class Game extends JFrame{ 
    protected static Board[] board3D;
//    private Board board;
    private Menu muneHandler = new Menu();;
    private JMenuBar menuBar;
    private JMenuItem newMenu;
    private JMenuItem saveMenu;
    private JMenuItem loadMenu;
    /**
     * starts the game. 
     * Open game window.
     * Constructs an object of type Game.
     */
    public Game() {
        board3D = new Board[3];
        setLayout(new GridLayout(1,3));
        for(int i = 2; i >= 0; i--) {
            board3D[i] = new Board(i);
        }
        board3D[0].initialposition();
        initMenu();
        pack();
        setSize(1000, 600);
        setTitle("Chess Game");
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(board3D[0]);
        add(board3D[1]);
        add(board3D[2]);
    }
    /**
     * set the menu bar at the top of the game window.
     */
    public final void initMenu() {
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        
        newMenu = new JMenuItem("New Game");
        newMenu.addActionListener(muneHandler);
        menu.add(newMenu);
        
        saveMenu = new JMenuItem("Save Game");
        saveMenu.addActionListener(muneHandler);
        menu.add(saveMenu);
        
        loadMenu = new JMenuItem("Load Game");
        loadMenu.addActionListener(muneHandler);
        menu.add(loadMenu);
        
        setJMenuBar(menuBar);
    }
    /**
     * reset game.
     */
    public void newMenu() {
        board3D[0].clear();
        board3D[1].clear();
        board3D[2].clear();
        board3D[0].initialposition();
        
    }
    /**
     * save game.
     */
    public final void saveMenu() {
        try {
            FileOutputStream saveFile = new FileOutputStream("./chess.gam");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(board3D[0]);
            save.close();
            saveFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * load saved game.
     */
    public final void loadMenu() {
        this.remove(board3D[0]);
        board3D[0] = null;
        try {
            FileInputStream loadFile = new FileInputStream("./chess.gam");
            ObjectInputStream load = new ObjectInputStream(loadFile);
            board3D[0] = (Board) load.readObject();
            load.close();
            loadFile.close();
        }catch(IOException e) {
            e.printStackTrace();
            return;
        }catch(ClassNotFoundException c) {
            System.out.println("Game not found");
            c.printStackTrace();
            return;
        }
        this.add(board3D[0]);
        this.repaint();
    }
    /**
     * menu actionlistener.
     * @author user
     *
     */
    public class Menu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("New Game".equals(e.getActionCommand())) {
                newMenu();
//                board.clear();
//                board.initialposition();
            }
            if ("Save Game".equals(e.getActionCommand())) {
                saveMenu();
            }
            if ("Load Game".equals(e.getActionCommand())) {
                loadMenu();
            }
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        new Game();

    }
    
}
