// Phil Ero 15JUL08
 
public class BumperCollision
{
   private static double nearestX;	// used to approximate what point of the bumper  
   private static double nearestY;  // a ball collided with

   /**
    * If the Ball collides with the Bumper, the ball will bounce off the bumper at the same angle
    * @param bumper the Bumper
    * @param ball the Ball
    */
   public static void collide(Bumper bumper, Ball ball)
   {
      // see if the ball hit the bumper!
      if(bumper.inBumper(ball))
      {
         // back the ball up until it is just outside the bumper
         while(bumper.inBumper(ball))
         {
            ball.setX((int)(ball.getX() - ball.getdx()/10.0));
            ball.setY((int)(ball.getY() - ball.getdy()/10.0));
         }
         
         // find the point on the edge of the bumper closest to the ball
         findImpactPoint(bumper, ball);
      	
         double ux = nearestX - ball.getX();
         double uy = nearestY - ball.getY();
         double ur = Math.sqrt(ux * ux + uy * uy);
         ux /= ur;
         uy /= ur;
         int dx = (int)ball.getdx();
         int dy = (int)ball.getdy();
         double dot_1 = ux * dx + uy * dy;
         double dot_2 = -uy * dx + ux * dy;
         dot_1 *= -1; // this is the actual "bounce"
         double[] d = new double[2];
         d[0] = dot_1 * ux - dot_2 * uy;      //vector math
         d[1] = dot_1 * uy + dot_2 * ux;      //vector math
         dx = (int)Math.round(d[0]);
         dy = (int)Math.round(d[1]);
         ball.setdx(dx);
         ball.setdy(dy);
      }
   }
   
   /**
    * Finds the point of impact between the Bumper and the Ball and updates to that (x, y) coordinate
    * @param bumper the Bumper
    * @param ball the Ball
    */
   private static void findImpactPoint(Bumper bumper, Ball ball)
   {
       // first assume the nw corner is closest
      nearestX = bumper.getX();  
      nearestY = bumper.getY();
      
      // now work around the edge of the bumper looking for a closer point
      for (int x = bumper.getX(); x <= bumper.getX() + bumper.getWidth(); x++)  // top & bottom edges
      {
         updateIfCloser(x, bumper.getY(), ball);
         updateIfCloser(x, bumper.getY() + bumper.getHeight(), ball);
      }
      for (int y = bumper.getY(); y <= bumper.getY() + bumper.getHeight(); y++)  // right & left edges
      {
         updateIfCloser(bumper.getX(), y, ball);
         updateIfCloser(bumper.getX() + bumper.getWidth(), y, ball);
      }
   }
      
   /**
    * Makes (x,y) the nearest point if it is closer to the ball
    * @param x the x-coordinate
    * @param y the y-coordinate
    * @param b the Ball object
    */
   private static void updateIfCloser(int x, int y, Ball b)
   {
      if(distance(x, y, b.getX(), b.getY()) < distance(nearestX, nearestY, b.getX(), b.getY()))
      {
         nearestX = x;
         nearestY = y;
      }
   }
       
   /**
    * Calculates the distance between (x1, y1) and (x2, y2).
    * @param x1 the x-coordinate of the first object
    * @param y1 the y-coordinate of the first object
    * @param x2 the x-coordinate of the second object
    * @param y2 the y-coordinate of the second object
    * @return the distance between (x1, y1) and (x2, y2).
    */
   private static double distance(double x1, double y1, double x2, double y2)
   {
      return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   }	
}