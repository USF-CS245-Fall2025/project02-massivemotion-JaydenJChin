//@name Jayden
//@date and version [10/20/2025 version 1.00]
//CS245 Project 2

import java.io.*;
import java.net.URL;
import java.util.Objects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class MassiveMotion extends JPanel implements ActionListener {

    protected Timer tm;

    // TODO: Consider removing the next two lines (coordinates for two balls) **DONE**
    protected int window_size_x;
    protected int window_size_y;

    // Star properties from properties file **DONE**
    protected int star_position_x;
    protected int star_position_y;
    protected int star_size;
    protected int star_velocity_x;
    protected int star_velocity_y;

    // Timer delay **DONE**

    protected int timer_delay;

    //Celestial Body
    protected List<CelestialBody> celestialBodies;
    protected double gen_x;
    protected double gen_y;
    protected int body_size;
    protected int body_velocity;

    /** 
    * Massive Motion method
    * Reads input from the property file.
    * Depending on the type of list required, creates a new list of that type.
    * Throws exceptions to verify that it works.
    * If does not work, then abandon execution.
    * Reads timer delay from property file and creates a new timer delay.
    * Creates a new celestial body from the specifications in property file.
    * @param propfile property .txt file
    * @throws RuntimeException if there is no file or cannot be read from file and abandons execution
    */
    public MassiveMotion(String propfile) {
    // public MassiveMotion() { **DONE**
        // TODO: insert your code to read from configuration file here. **DONE**
        Properties prop = new Properties();

        try(FileInputStream file = new FileInputStream(propfile)){
            prop.load(file);

            //in try catch so if value missing, it abandons execution
            timer_delay = Integer.parseInt(prop.getProperty("timer_delay"));
            window_size_x = Integer.parseInt(prop.getProperty("window_size_x"));
            window_size_y = Integer.parseInt(prop.getProperty("window_size_y"));
            star_position_x = Integer.parseInt(prop.getProperty("star_position_x"));
            star_position_y = Integer.parseInt(prop.getProperty("star_position_y"));
            star_size = Integer.parseInt(prop.getProperty("star_size"));
            star_velocity_x = Integer.parseInt(prop.getProperty("star_velocity_x"));
            star_velocity_y = Integer.parseInt(prop.getProperty("star_velocity_y"));
            gen_x = Double.parseDouble(prop.getProperty("gen_x"));
            gen_y = Double.parseDouble(prop.getProperty("gen_y"));
            body_size = Integer.parseInt(prop.getProperty("body_size"));
            body_velocity = Integer.parseInt(prop.getProperty("body_velocity"));
            String typeList = prop.getProperty("list").toLowerCase();

            if(typeList.equals("arraylist")){
                celestialBodies = new ArrayList<CelestialBody>();
            } 
            else if(typeList.equals("single")){
                celestialBodies = new LinkedList<CelestialBody>();
            } 
            else if(typeList.equals("double")){
                celestialBodies = new DoublyLinkedList<CelestialBody>();
            } 
            else if(typeList.equals("dummyhead")){
                celestialBodies = new DummyHeadLinkedList<CelestialBody>();
            } 
            else{
                throw new RuntimeException("Invalid list_type in properties");
            }

        } 
        catch (IOException e){
            throw new RuntimeException("Error: Check Property File, Abandoning Execution");
        } 

        tm = new Timer(timer_delay, this); // TODO: Replace the first argument with delay with value from config file. **DONE**

        // TODO: Consider removing the next two lines (coordinates) for random starting locations. **DONE**
        celestialBodies.add(new CelestialBody(star_position_x, star_position_y, star_size, star_velocity_x, star_velocity_y, true));
    }


    /** 
    * paintComponent method
    * Checks if star, if it is make the color red for star.
    * If not star make color black for celestial body.
    * Fills in dimension values for the corresponding one.
    * Starts the painting the circles.
    * @param g Graphics used for drawing and coloring the star and celestial body
    */
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Probably best you leave this as is.

        // TODO: Paint each ball. Here's how to paint two balls, one after the other:
        for(int i = 0; i < celestialBodies.size(); i++){
            CelestialBody body = celestialBodies.get(i);
            if(body.isStar()){
                g.setColor(Color.RED);
            } 
            else{
                g.setColor(Color.BLACK);
            }
            g.fillOval(body.getX(), body.getY(), body.getSize(), body.getSize());
        }


        // Recommend you leave the next line as is
        tm.start();
    }

    /** 
    * actionPerformed method
    * Backwardsly iterate through the celestialBodies list and updates position x,y.
    * Checks if celestial body goes OOB and removes them.
    * Randomly creates new celestial body on gen_x and gen_y sides of the screen with a random velocity between 3 and -3 excluding 0.
    * @param actionEvent actionEvent used to update celestial bodies each epoch
    */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // TODO: Change the location of each ball. Here's an example of them moving across the screen:
        //       ... but to be clear, you should change this.

        for(int i = celestialBodies.size() - 1; i >= 0; i--){
            CelestialBody body = celestialBodies.get(i);
            body.x += body.vx;
            body.y += body.vy;

        // These two "if" statements keep the balls on the screen in case they go off one side.
            if(body.x < 0 || body.x > window_size_x || body.y < 0 || body.y > window_size_y){
                System.out.println("Removed Celestial Body at index " + i + " position (" + body.x + "," + body.y + ")"); //non visual verification of working for question 1
                celestialBodies.remove(i);
            }
        }

        if(Math.random() < gen_x){
            int yPos = (int)(Math.random() * window_size_y);
            int xPos;
            if(Math.random() < 0.5){
                xPos = 0;
            } 
            else{
                xPos = window_size_x - body_size;
            }

            int vx = getRandomVelocity(body_velocity);
            int vy = getRandomVelocity(body_velocity);

            CelestialBody newBody = new CelestialBody(xPos, yPos, body_size, vx, vy, false);
            celestialBodies.add(newBody);
        }

        if(Math.random() < gen_y){
            int xPos = (int)(Math.random() * window_size_x);
            int yPos;
            if (Math.random() < 0.5){
                yPos = 0;
            } 
            else{
                yPos = window_size_y - body_size;
            }

            int vx = getRandomVelocity(body_velocity);
            int vy = getRandomVelocity(body_velocity);

            CelestialBody newBody = new CelestialBody(xPos, yPos, body_size, vx, vy, false);
            celestialBodies.add(newBody);
        }

        // Keep this at the end of the function (no matter what you do above):
        repaint();
    }

    /** 
    * getRandomVelocity method
    * Checks if velocity is 0, if it is then updates it to a random one within the range of 3 to -3.
    * @param range for the velocity
    * @return velocity velocity is the random velocity after updating within the range
    */
    private int getRandomVelocity(int range){
        int velocity = 0;
        while(velocity == 0){ 
            velocity = (int)(Math.random() * (2 * range + 1)) - range;
        }
        return velocity;
    }

    /** 
    * main method
    * Initializes jframe, paints the canvas and starts the animation.
    * @param args used for user input
    */
    public static void main(String[] args) {
        System.out.println("Massive Motion starting...");
        MassiveMotion mm = new MassiveMotion(args[0]);
        // MassiveMotion mm = new MassiveMotion(); **DONE**

        JFrame jf = new JFrame();
        jf.setTitle("Massive Motion");
        jf.setSize(mm.window_size_x, mm.window_size_y); // TODO: Replace with the size from configuration! **DONE**
        jf.add(mm);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
