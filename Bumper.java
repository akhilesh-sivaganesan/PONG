// Name: 				Date:

import java.awt.*;
   
public class Bumper
{
   //private fields, all ints, for a Bumper
   //hint: the "location" of the bumper begins at its top left corner.     
   //YOUR CODE HERE: YOU ADD THE REST OF THE DATA FIELDS
   private int myX;
   private int myY;
   private int width;
   private int height;
   private Color color;
   

   
   
   // Default constructor
   public Bumper()         
   {
	   myX = 100;
	   myY = 300;
	   width = 50;
	   height = 200;
	   color = Color.ORANGE;
   }
   
   // 5-arg constructor
   public Bumper(int x, int y, int xWidth, int yHeight, Color c)
   {
	   myX = x;
	   myY = y;
	   width = xWidth;
	   height = yHeight;
	   color = c;
   }
      
   //***********************************************
   //
   //  Accessor methods  (one for each field)
   //
   //***********************************************
   
   public int getX()
   {
   return myX;
   }
   public int getY()
   {
   return myY;
   }
   public int getWidth()
   {
   return width;
   }
   public int getHeight()
   {
   return height;
   }
   public Color getColor()
   {
   return color;
   }
 
 //YOUR CODE HERE: YOU ADD THE REST OF THE ACCESSOR METHODS
   
   //***********************************************
   //
   //  Modifier methods  (one for each field)
   //
   //***********************************************   
   
   public void setX(int x)
   {
  myX = x;
   }
   public void setY(int y)
   {
  myY = y;
   }
   public void setWidth(int w)
   {
  width = w;
   }
   public void setHeight(int h)
   {
  height = h;
   }
   public void setColor(Color c)
   {
  color = c;
   }
   
   //YOUR CODE HERE: YOU ADD THE REST OF THE MODIFIER METHODS
   
   
   //************************
   //
   // Instance methods
   //
   //************************
   
   
   /**
    * Chooses a random (x,y) location for the Bumper.  Bumper stays entirely in the window.
    * @param rightEdge the right side of the window
    * @param bottomEdge the bottom side of the window
    */
   public void jump(int rightEdge, int bottomEdge)
   {
      // moves location to random (x, y) within the edges
      //YOUR CODE HERE
	  if(myX < rightEdge && myX > 0)
      {
	         myX = (int)(Math.random()* rightEdge);
      }
	  if(myY < bottomEdge && myY > 0) {
		  myY = (int)(Math.random()* bottomEdge);
	  }
   }
      
   /**
    * Draws a rectangular bumper on the buffer
    * @param myBuffer the picture drawn on the screen
    */
   public void draw(Graphics myBuffer) 
   {
      //change the color of myBuffer (using appropriate data fields)
	   myBuffer.setColor(color);
      //use myBuffer to draw the Bumper (using appropriate data fields)
      //YOUR CODE HERE
	   myBuffer.fillRect(myX, myY, width, height);
   }   
   
   
   /**
    * Returns true if any part of the Polkadot is inside the bumper
    * @return true if any part of the polkadot is inside the bumper
    */
   public boolean inBumper(Polkadot dot)
   {
      for(int x = getX(); x <= getX() + getWidth(); x++)   //starts at upper left corner(x,y)
         for(int y = getY(); y <= getY() + getHeight(); y++)
            if(distance(x, y, dot.getX(), dot.getY()) <= (dot.getDiameter())) //checks every point on the bumper
               return true;            
      return false;
      //THIS METHOD IS ALREADY COMPLETE
   }  
   
   
   
   
   /**
    * Calculates the distance between (x1, y1) and (x2, y2)
    * @param x1 Comment...
    * @param y1 Comment...
    * @param x2 Comment...
    * @param y2 Comment...
    * @return the distance between (x1, y1) and (x2, y2)
    */
   private double distance(double x1, double y1, double x2, double y2)
   {
      return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   //THIS METHOD IS ALREADY COMPLETE
   }	
}