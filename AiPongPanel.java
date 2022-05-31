//Torbert, e-mail: mr@torbert.com, website: www.mr.torbert.com
//version 6.17.2003
// Chapin, email: john.chapin@lcps.org changed to use sleep and Gui class

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class AiPongPanel extends JPanel {
	// constants
   private static final int FRAME = 800;
   private static final Color BACKGROUND = new Color(0, 50, 0);//Background is causing 'blank' problem
	
	// fields
   private BufferedImage myImage;
   private Ball ball;
   private Polkadot pd;
   private Bumper leftBumper;    
    //1)  ***********   Any Other Objects?
   private Bumper rightBumper;
   private int player1Score = 0;
   private int player2Score = 0;
   private int delayLength = 10;
   private int[] nums = {-1, 1};
   private static int maxScore;

   

   
   public AiPongPanel() {
      getPanelGraphics();
       //2) *****Instantiate all objects
      ball = new Ball();
      leftBumper = new Bumper(0, 300, 50, 300, (new Color(255, 0, 0)));
      rightBumper = new Bumper(750, 300, 50, 300, (new Color(255, 0, 0)));
      addMouseListener(new Mouse());
      addKeyListener(new Key());
      setFocusable(true);
    	/*
   	 * Create a thread that will call the Panel every time
   	 * the screen needs to be drawn.
   	 */
      AiPongPanelGui ballGui = new AiPongPanelGui(this);
      Thread ballThread = new Thread(ballGui);
      
      ballThread.start();
      
       // 3)*********  Key Listener??	
   }
	
   private void drawBall() {
   	
   //****************   Your code here  ************
      Graphics graphics = getPanelGraphics();

   //So far color is set to the background
      ball.move(FRAME, FRAME);
      
   //4) **********   What collides and how to call it
      BumperCollision.collide(leftBumper, ball);
      BumperCollision.collide(rightBumper, ball);

      ball.draw(graphics);
   //5)  *********  What else needs be drawn?
      leftBumper.draw(graphics);
      rightBumper.draw(graphics);
      
      //Draw rectangle for score board
      /*
      graphics.setColor(new Color (203, 203, 203));
      graphics.fillRect(FRAME/5, 0, 2* FRAME/3, 70);
      */

      Font font = new Font("Candara", Font.BOLD, 70);
      graphics.setFont(font);
      graphics.setColor(new Color(255, 0, 0));
      graphics.drawString(String.valueOf(player1Score) , (FRAME/4), 50);
      graphics.setColor(new Color(0, 255, 0));
      graphics.drawString(String.valueOf(player2Score), ((3 * FRAME)/4), 50);
      graphics.setColor(Color.WHITE);
      graphics.drawLine(FRAME/2, 0, FRAME/2, FRAME);
      
      //Score code - Player 2 Score
      if(ball.getX() < 0) {
    	  player2Score++;
    	  ball.setX(FRAME/2);
    	  ball.setY(FRAME/2);
    	  if(Math.random() > 0.5){
    		  ball.setdx(ball.getdx() * nums[0]);
    	  }
    	  if(Math.random() < 0.5) {
    		  ball.setdx(ball.getdx() * nums[1]);
    	  }
      //Score code - Player 1 Score
    	  
      }
      if(ball.getX() > FRAME) {
    	  player1Score++;
    	  ball.setX(FRAME/2);
    	  ball.setY(FRAME/2);
    	  if(Math.random() > 0.5){
    		  ball.setdy(ball.getdy() * nums[0]);
    	  }
    	  if(Math.random() < 0.5) {
    		  ball.setdy(ball.getdy() * nums[1]);
    	  }
      }
      //Ai part
      
      if((ball.getY() < (leftBumper.getY() - (0.5 * leftBumper.getHeight()))) && (leftBumper.getY() > 0)) {
    	  leftBumper.setY(leftBumper.getY() - 10);
      }
      if((ball.getY() > (leftBumper.getY() - (0.5 * leftBumper.getHeight()))) && ((leftBumper.getY() + leftBumper.getHeight()) < FRAME)) {
    	  leftBumper.setY(leftBumper.getY() + 10);
      }
      
      if(player1Score == maxScore) {
    	  
          //player1Score++;
    	  getPanelGraphics();
          Font font3 = new Font("Candara", Font.BOLD, 70);
          graphics.setFont(font3);
          graphics.setColor(new Color(255, 0, 0));
          graphics.drawString(String.valueOf(player1Score) , (FRAME/4), FRAME/2);
          graphics.drawString(String.valueOf(player2Score) , (3*FRAME/4), FRAME/2);
          graphics.drawString("to", FRAME/2, FRAME/2);
    	  graphics.setColor(Color.ORANGE);
    	  graphics.drawString("YOU LOST!", FRAME/4, FRAME/3);
    	 
      }
      if(player2Score == maxScore) {
    	 
    	  //player2Score++;
    	  getPanelGraphics();
    	  Font font4 = new Font("Candara", Font.BOLD, 70);
          graphics.setFont(font4);
          graphics.setColor(new Color(255, 0, 0));
          graphics.drawString(String.valueOf(player2Score) , (FRAME/4), FRAME/2);
          graphics.drawString(String.valueOf(player1Score), 3* FRAME/4, FRAME/2);
          graphics.drawString("to", FRAME/2, FRAME/2);
    	  graphics.setColor(Color.ORANGE);
    	  graphics.drawString("YOU WON!", FRAME/4, FRAME/3);
    	  
      }
          repaint();
          
   }
   public static void setMaxScore (int s) {
	   maxScore = s;
   }
   public int getMaxScore () {
	   return maxScore;
   }
   private class Mouse extends MouseAdapter
   {
      public void mouseClicked (MouseEvent e)
      {
         pd.setX(e.getX());
         pd.setY(e.getY());
      
      }
   }
   
   private class Key extends KeyAdapter
   {
      public void keyPressed(KeyEvent e)
      {
    	 boolean rightUp = false;
    	 boolean rightDown = false;
    	
    	 
    	 //Right keys
         if (e.getKeyCode() == KeyEvent.VK_UP)
         {
            rightUp = true;
            rightDown = false;
         }
      	
         if (e.getKeyCode() == KeyEvent.VK_DOWN)
         {
            rightUp = false;
            rightDown = true;
         }
      
         if (rightUp && (rightBumper.getY() > 0))
            rightBumper.setY(rightBumper.getY() - 10);
         if(rightDown && ((rightBumper.getY() + rightBumper.getHeight()) < FRAME))
            rightBumper.setY(rightBumper.getY() + 10);
      	//Left Keys	
         
      }//keyPressed
    	
      public void keyReleased(KeyEvent e) {
    	  boolean rightUp = false;
    	  boolean rightDown = false;
    	 
    	  
         if (e.getKeyCode() == KeyEvent.VK_UP)
         {
            rightUp = false;
         }
         
         if (e.getKeyCode() == KeyEvent.VK_DOWN)
         {
            rightDown = false;
         }
         
      }//keyreleased
   }

  
    
    
   public void paintComponent(Graphics g) {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
	
	/*
	 * set up the buffer if null create a new one, else clear the buffer with a
	 * background image
	 */
   private Graphics getPanelGraphics() {
   
      if (null == myImage) {
         myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      }
      int w = FRAME;
      int h = FRAME;
   
      Graphics g = myImage.getGraphics();
      g.setColor(BACKGROUND);// blue
   
   	// 1 ********* write the code to "clear the screen" for animation
      g.fillRect(0, 0, w,h);
      return g;
   }
	
   public void updateBall()  {
         // draw the Ball and then sleep for "delay length" 
	
      try {
         SwingUtilities.invokeAndWait(
            new Runnable() {
               @Override
                
               public void run() {
            	  if(player1Score < maxScore && player2Score < maxScore) {
                  drawBall();
            	  }
            	  
                  try {
                     Thread.sleep(delayLength);
                  } catch (InterruptedException ex) {
                     Thread.currentThread().interrupt();
                  
            	  }
            	                                }
            });
      } catch (Exception e) {
         e.printStackTrace();
      }
   }


}