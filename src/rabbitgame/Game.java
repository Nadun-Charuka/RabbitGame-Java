
package rabbitgame;
import java.awt.*;
import javax.swing.*;

public class Game {
    
    JFrame frame = new JFrame();
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    
    JButton[] board = new JButton[9];
    JPanel boardPanel = new JPanel();
    
    public Game(){
        //JFrame
        frame.setVisible(true);
        frame.setSize(600,650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        //JLabel
       textLabel.setText("Score: 00");
       textPanel.add(textLabel);
       frame.add(textPanel);
       
       
    }
}
