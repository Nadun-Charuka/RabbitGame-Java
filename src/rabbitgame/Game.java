
package rabbitgame;
import java.awt.*;
import javax.swing.*;

public class Game {
    
    JFrame frame = new JFrame("Rabbit Game");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    
    JButton[] board = new JButton[9];
    JPanel boardPanel = new JPanel();
    
    ImageIcon rabbitIcon; //animeIcon
    ImageIcon bombIcon; //hammerIcon
    
    public Game(){
        //JFrame
        
        frame.setSize(600,650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        //JLabel
       textLabel.setText("Score: 00");
       textLabel.setFont(new Font("Arial", Font.PLAIN ,50));
       textPanel.add(textLabel);
       frame.add(textPanel,BorderLayout.NORTH);
       
       //Image Icons
       Image rabbitImg = new ImageIcon(getClass().getResource("./rabbit.jpg")).getImage();
       rabbitIcon = new ImageIcon(rabbitImg.getScaledInstance(190,190,java.awt.Image.SCALE_SMOOTH));
       
       Image bombImg = new ImageIcon(getClass().getResource("./bomb.jpg")).getImage();
       bombIcon = new ImageIcon(bombImg.getScaledInstance(190, 190,java.awt.Image.SCALE_SMOOTH));
       //buttons
       boardPanel.setLayout(new GridLayout(3,3));
       for(int i=0; i<9; i++){
           JButton tile = new JButton();
           board[i] = tile;
           boardPanel.add(tile);
           tile.setFocusable(false);
           tile.setIcon( bombIcon);
           frame.add(boardPanel);
       }
       
       frame.setVisible(true);
       
       
       
       
    }
}
