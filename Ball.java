// Billington.  email: mlbillington@fcps.edu
// version: 7.25.2007

import java.awt.*;
public class Ball extends Polkadot
{
   private int dx;       // pixels to move each time step() is called.
   private int dy;
    // constructors
   public Ball()         //default constructor
   {
      super(200,200,50,Color.WHITE);
      /*dx = (int)(Math.random()*11-6);          //pixels to move vertically
      dy = (int)(Math.random()*11-6);  
              //pixels to move sideways
	      if (dx==0)
	    	  dx=5;
	      if(dy==0)
	    	  dy=-5;
	    	  */
      dx = 10;
      dy = 10;
      
   }
   public Ball(int x, int y, int dia, Color c)
   {
      super(x, y, dia, c);
      /*
      dx = (int)(Math.random()*11-6);
      dy = (int)(Math.random()*11-6);
	      if (dx==0)
	    	  dx=5;
	      if(dy==0)
	    	  dy=-5;
	    	  */
       dx = 10;
       dy = 10;
   }
     //modifier methods 
   public void setdx(int x)        
   {
      dx = x;
   }
   public void setdy(int y)
   {
      dy = y;
   }
      //accessor methods
   public int getdx()             
   {
      return dx;
   }
   public int getdy()
   {
      return dy;
   }
     //instance methods
   public void move(int rightEdge, int bottomEdge)
   {
      setX(getX()+ dx);                    // x = x + dx
      setY(getY() +dy);
        
   	  
   	   //***Update the Y value with the change in Y*****////
   		
   		
      int radius = getDiameter() / 2;
 		
   		/******
   		complete the other 3 edges
   		
   		*****/

      if(getY() >= bottomEdge - radius) {//bottom edge
    	  setY(bottomEdge - radius);
    	  dy = dy * -1;
      }
      if(getY() <= radius) {//Top edge
    	  setY(radius);
    	  dy *= -1;
      }
   		/******
   		complete the other 3 edges
   		
   		
   		*****/
      
         
   }
}