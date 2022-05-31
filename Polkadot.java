// Billington.  email: mlbillington@fcps.edu
// version: 7.25.2007

   import java.awt.*;
    public class Polkadot
   {
      private int myX;              // x and y coordinates of center
      private int myY;
      private int myDiameter;
 
	private Color myColor; 
        
    // constructors
       public Polkadot()     //default constructor
      {
         myX = 200;
         myY = 200;
         myDiameter = 25;
         myColor = Color.red;
      }
       public Polkadot(int x, int y, int d, Color c)
      {
         myX = x;
         myY = y;
         myDiameter = d;
         myColor = c;
      }
    // accessor methods
       public int getX() 
      { 
         return myX;
      }
       public int getY()      
      { 
         return myY;
      }
       public int getDiameter() 
      { 
         return myDiameter;
      }
       
       public void setMyDiameter(int myDiameter) {
   		this.myDiameter = myDiameter;
   	}
       public Color getColor() 
      { 
         return myColor;
      }
   // modifier methods
       public void setX(int x)
      {
         myX = x;
      } 
       public void setY(int y)
      {
         myY = y;
      }
       
       public void setColor(Color c)
       {
           myColor = c;
       }
   //	 instance methods
       public void jump(int rightEdge, int bottomEdge)
      {
         myX = (int)(Math.random()* rightEdge);
         myY = (int)(Math.random()* bottomEdge);
      }
       public void draw(Graphics myBuffer) 
      {
         int r = myDiameter / 2;
         myBuffer.setColor(myColor);
         myBuffer.fillOval(myX-r, myY-r, myDiameter, myDiameter);
      }
   }