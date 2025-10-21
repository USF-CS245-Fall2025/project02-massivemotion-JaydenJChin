//@name Jayden
//@date and version [10/20/2025 version 1.00]
//CS245 Project 2

public class CelestialBody{
    protected int x;
    protected int y;
    protected int vx;
    protected int vy;
    protected int size;
    protected boolean isStar;
    
    /** 
    * CelestialBody method
    * Initializes for x,y,size,vx,vy,and isStar
    * @param x position x
    * @param y position y
    * @param size size for celestial body
    * @param vx velocity for x
    * @param vy velocity for y
    * @param isStar boolean for if it is star or not
    */
    public CelestialBody(int x, int y, int size, int vx, int vy, boolean isStar){
        this.x = x;
        this.y = y;
        this.size = size;
        this.vx = vx;
        this.vy = vy;
        this.isStar = isStar;
    }

    /** 
    * getX method
    * @return x position
    */
    public int getX(){
        return x;
    }

    /** 
    * getY method
    * @return y position
    */
    public int getY(){
        return y;
    }

    /** 
    * getSize method
    * @return size
    */
    public int getSize(){
        return size;
    }

    /** 
    * isStar method
    * @return isStar
    */
    public boolean isStar(){
        return isStar;
    }
}
