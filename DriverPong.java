import javax.swing.JFrame;
import javax.swing.JOptionPane;
   public class DriverPong
   {
      public static void main(String[] args)
      { 
    	 int players = Integer.parseInt((String)JOptionPane.showInputDialog("Please enter number of players (1 or 2)"));
    	 int s = Integer.parseInt((String)JOptionPane.showInputDialog("Please enter the maximum score."));
    	     	 
         JFrame frame = new JFrame("Pong");
         frame.setSize(800, 800);
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         if(players == 1) {
        	 AiPongPanel c = new AiPongPanel();
        	 AiPongPanel.setMaxScore(s);
        	 frame.setContentPane(c);
        	 frame.setVisible(true);
             c.requestFocus();
         }
         
         else if(players == 2) {
        	 
         PongPanel p = new PongPanel();
         PongPanel.setMaxScore(s);
         frame.setContentPane(p);
         frame.setVisible(true);
         p.requestFocus();
         }
       
         
        
      }
   }