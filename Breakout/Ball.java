import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.util.List;

/**
 * A ball is an object that can hit other objects and bounce off the 
 * edges of the world (except the bottom edge).  It will bounce off of
 * a paddle as well.
 * 
 * @author Barbara Ericson Georgia Tech 
 * @version 1.0 April 6, 2007
 */
public class Ball extends Actor
{
    //////////// fields /////////////////////////////
    boolean lado;
    /** the radius of this ball */
    private int radius = 10;
    
    /** the width of this ball (diameter) */
    private int width = radius * 2;
    
    /** the color of the ball */
    private Color color = Color.BLACK;
    
    /** the amount of change in x during each act */
    private int velX;
    
    /** the amount of change in y during each act */
    private int velY = 2;
    
    ////////////////// constructors /////////////////////
    
    /**
     * Constructor that takes no arguments 
     */
    public Ball()
    {
        // set velX to 1-2 or -1 to -2
        lado = true;
        velX = Greenfoot.getRandomNumber(2) + 1;
        if (Greenfoot.getRandomNumber(2) == 0)
           velX = -1 * velX;
        updateImage();
        setRotation(90);
    }
    
    /**
     * Constructor that takes initial values for all fields
     * @param theRadius the radius to use
     * @param theColor  the color to use
     * @param theVelX   the amount to change in X per act
     * @param theVelY   the amount to change in Y per act
     */
    public Ball(int theRadius, Color theColor, 
                int theVelX, int theVelY)
    {
        radius = theRadius;
        color = theColor;
        velX = theVelX;
        velY = theVelY;
        lado = true;
        updateImage();
    }
    
    ///////////////////// Methods ///////////////////////////////
    
    /**
     * Balls will move and check if they have hit a brick or paddle or
     * one of the edges of the world
     */
    public void act() 
    {

        if(!lado)
        {
            if(getX() < getWorld().getWidth() - this.width/2)

                //setLocation(getX()+velX,getY()+velY);
         
            if(!lado)
            {
            if(getX()<=0 || getX() < getWorld().getWidth() - this.width/2)

            {
                 mueveDerecha();
            }
        }
        

            else
            {
                 lado = true;
            }

            else{
                lado = true;

            }
        }
        if(lado)
        {
            if(getX() >= this.width/2)
            {
                mueveIzquierda();
            }
            else{

                lado = false;
            }
        }
        if(isTouching(Paddle.class))
        {
            velY = -velY;
        }
        if(isTouching(Brick.class))
        {
            velY = -velY;
            removeTouching(Brick.class);
        }
        checaBloques();
        if(isTouching(Paddle.class))
       {
            velY = -velY;
            
       }
       quita();
    }
    public void quita()
    {
        if(isTouching(Brick.class))
        {
            removeTouching(Brick.class);
        }
    }
//<<<<<<< HEAD
//=======
    
    public void checaBloques()
    {
        
            World mundo = getWorld();
            List lista=mundo.getObjects(Brick.class);
        }
        
//>>>>>>> origin/master
    public void mueveDerecha(){
        move(velY);
        setLocation(getX()+velX, getY()+velY);
        
    }
    
    public void mueveIzquierda(){
        move(velY);
        setLocation(getX()- velX, getY()+velY);
       
    }
    /**
     * Method to set the ball color
     */
    public void setColor(Color theColor)
    {
        this.color = theColor;
        updateImage();
    }
    

    /**
     * Method to create the image and set it for the ball 
     * If you change the ball width or color you should 
     * invoke this again
     */
    public void updateImage()
    {
        GreenfootImage image = new GreenfootImage(width,width);
        image.setColor(color);
        image.fillOval(0,0,width,width);
        setImage(image);
    }
}

