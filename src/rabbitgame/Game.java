
package rabbitgame;
import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;

public class Game {
    
    JFrame frame = new JFrame("Rabbit Game");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    
    JButton[] board = new JButton[9];
    JPanel boardPanel = new JPanel();
    
    ImageIcon rabbitIcon; //animeIcon
    ImageIcon bombIcon; //hammerIcon
    
    JButton currentRabbitTile;
    JButton currentBombTile;
    
    Random random = new Random();
    
    Timer setRabbitTimer;
    Timer setBombTimer;
    
    int score = 0;
    
    
    
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
         //  tile.setIcon(rabbitIcon);
           frame.add(boardPanel);
           tile.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                   JButton clicked = (JButton)e.getSource();
                   if(clicked == currentRabbitTile){
                       score +=10;
                       textLabel.setText("Score: "+ Integer.toString(score));
                   }else if(clicked == currentBombTile){
                       textLabel.setText("Game Over");
                       setRabbitTimer.stop();
                       setBombTimer.stop();
                       for(int j=0;j<9;j++){
                           board[j].setEnabled(false);
                       }
                   }
               }
           });
       }
       
       //Timer
       setRabbitTimer = new Timer(1000, new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               if(currentRabbitTile != null ){
                   currentRabbitTile.setIcon(null);
                   currentRabbitTile = null;
               }
               int num = random.nextInt(9);
               JButton tile = board[num];
               if(currentBombTile == tile) return;
               
               tile.setIcon(rabbitIcon);
               currentRabbitTile = tile;
           }
       });
       
       setBombTimer = new Timer(1500, new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               if(currentBombTile != null){
                   currentBombTile.setIcon(null);
                   currentBombTile = null;
               }
               int num = random.nextInt(9);
               JButton tile = board[num];
               if(currentRabbitTile == tile) return;
               
               tile.setIcon(bombIcon);
               currentBombTile = tile;
           }
       });
       
       setRabbitTimer.start();
       setBombTimer.start();
       
       frame.setVisible(true);
            
    }
}
