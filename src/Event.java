import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Square source = (Square) e.getSource(); 
          if (source.getPiece() != null) {
              if(Square.data != null) {
                  if (Square.data.validPosition(source)) {
                      if(Square.data.valid3D(Square.data.getPiece().validX(), Square.data.getPiece().validY(), source.baoardNum)) {
                          Square.data.setIcon(null);
                          source.setIcon(Square.data.getPiece().getIcon());
                          source.move(Square.data.getPiece());
                          Square.data.remove();
                          Square.data = null;
                          Board.turn++;
                      }
                  } else
                      Square.data = (Square) source;
              } else
                  Square.data = (Square) source;
          } else {
              if (Square.data != null) {
                  if (Square.data.validPosition(source)) {  
                      Square.data.setIcon(null);
                      source.setIcon(Square.data.getPiece().getIcon());
                      source.move(Square.data.getPiece());
                      Square.data.remove();
                      Square.data = null;
                      Board.turn++;
                  }
              }
          }
        }
    private void pieceMove() {} 
}

