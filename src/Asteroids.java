
/* Triginometry
 * SOH CAH TOA 
 * sin = Opposite side/hypotenuse
 * cos = adjacent/hypotenuse
 * tan = opposite/adjacent
 */

// !!!IF Value and Variable USE == DOUBLE EQUALS

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.ArrayList;


public class Asteroids extends Applet implements KeyListener, ActionListener {
    
//Variables Are Right Underneath
    
    SpaceCraftOfFlyingness ship; 
    Timer mTimer;
    int mCounter;
    Image offScreen;
    Graphics offG;
    boolean leftKey;
    boolean rightKey;
    boolean upKey;
    boolean downKey;
    boolean spaceKey;
    ArrayList<AsteroidOfAlsoFlyingness> mAsteroidlist;
    ArrayList<BulletsOfDeathAndOfAlsoFlyingness> mBulletslist;
    ArrayList<DebreeOfExplosionnessWithoutDeathNess> mExplosionlist;
    
    public void init() {
        
        this.setSize(900, 600);
        this.addKeyListener (this);
        ship = new SpaceCraftOfFlyingness();
        mTimer = new Timer(20, this);
        offScreen = createImage (this.getWidth(), this.getHeight());
        offG = offScreen.getGraphics();
        mAsteroidlist = new ArrayList();
        for (int i = 0; i < 6; i++){
            mAsteroidlist.add(new AsteroidOfAlsoFlyingness());
        }
        mBulletslist = new ArrayList();
        mExplosionlist = new ArrayList();
    }
    
    public void update(Graphics g){
         
        paint(g);
    }
    public void paint(Graphics g) {
        
        offG.setColor(Color.BLACK);
        offG.fillRect(0, 0, 900, 600);
        offG.setColor(Color.GREEN);
        ship.paint(offG);
        offG.setColor(Color.WHITE);
        for (int i = 0; i < mAsteroidlist.size(); i++){
            mAsteroidlist.get(i).paint(offG);
        }
        offG.setColor(Color.CYAN);
        for (int i = 0; i < mBulletslist.size(); i++){
            mBulletslist.get(i).paint(offG);
        }
        offG.setColor(Color.RED);
        for (int i = 0; i < mExplosionlist.size(); i++){
            mExplosionlist.get(i).paint(offG);
        }
        if (mAsteroidlist.size() == 0){
            offG.setColor(Color.GREEN);
            offG.fillRect(350, 250, 200, 100);
            
            /*
            offG.setColor(Color.CYAN);
            offG.drawString("YOU WIN :D", 450, 550);
            offG.drawString("YOU WIN :D", 450, 500);
            offG.drawString("YOU WIN :D", 450, 450);
            offG.drawString("YOU WIN :D", 450, 400);
            offG.drawString("YOU WIN :D", 450, 350);
            offG.drawString("YOU DON'T WIN :D", 450, 300);
            offG.drawString("YOU WIN :D", 450, 250);
            offG.drawString("YOU WIN :D", 450, 200);
            offG.drawString("YOU WIN :D", 450, 150);
            offG.drawString("YOU WIN :D", 450, 100);
            offG.drawString("YOU WIN :D", 450, 50);
            */
        }
        
            
        g.drawImage(offScreen, 0,0, this);
        
            
        repaint();
    }
    
    public void keyCheck(){  
         
        if (upKey == true) {
            ship.accelerate();
        }
        
        if (leftKey == true) {
            ship.angle -= ship.ROTATION; 
        }
        
        if (rightKey == true) {
            ship.angle += ship.ROTATION;
        }
        if (downKey == true){
            ship.backwards();
        }
        if (spaceKey == true && ship.mCounter > 10 && ship.mActive == true) {
            mBulletslist.add(new BulletsOfDeathAndOfAlsoFlyingness(ship.xposition, ship.yposition, ship.angle));
            ship.mCounter = 2; //Tracks rate of fire
        }
          
    }

    public void keyTyped (KeyEvent e) { 
        
    }
    
    public void keyPressed (KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_UP) {
            upKey = true;
        }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftKey = true;
        }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightKey = true;
        }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downKey = true;
        }   
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            spaceKey = true;
        }
    }
            
    public void keyReleased (KeyEvent e) {
        
            if (e.getKeyCode() == KeyEvent.VK_UP) {
            upKey = false;
        }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftKey = false;
        }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightKey = false;
        }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downKey = false;
        }
            if (e.getKeyCode() == KeyEvent.VK_SPACE){
            spaceKey = false;    
        }
    }
    public void actionPerformed(ActionEvent e){
        keyCheck();
        ship.updatePosition();
        
        for (int i = 0; i < mAsteroidlist.size(); i++){
            mAsteroidlist.get(i).updatePosition();
            if (mAsteroidlist.get(i).mActive == false){
                if (mAsteroidlist.get(i).mSize != 1){
                    mAsteroidlist.add(new AsteroidOfAlsoFlyingness(mAsteroidlist.get(i).xposition, mAsteroidlist.get(i).yposition, mAsteroidlist.get(i).mSize - 1));
                    mAsteroidlist.add(new AsteroidOfAlsoFlyingness(mAsteroidlist.get(i).xposition, mAsteroidlist.get(i).yposition, mAsteroidlist.get(i).mSize - 1));
                    //mAsteroidlist.add(new AsteroidOfAlsoFlyingness(mAsteroidlist.get(i).xposition, mAsteroidlist.get(i).yposition, mAsteroidlist.get(i).mSize - 1));
                }
                for (int j = 0; j < Math.random()*30 + 15; j++){
                    mExplosionlist.add(new DebreeOfExplosionnessWithoutDeathNess(mAsteroidlist.get(i).xposition, mAsteroidlist.get(i).yposition));
                }
                mAsteroidlist.remove(i);
            }
        }
        for (int i = 0; i < mBulletslist.size(); i++){
            mBulletslist.get(i).updatePosition();
            if (mBulletslist.get(i).mActive == false){
                mBulletslist.remove(i);
            }
                
        }
        for (int i = 0; i < mExplosionlist.size(); i++){
            mExplosionlist.get(i).updatePosition();
            if (mExplosionlist.get(i).mCounter == 30){
                mExplosionlist.remove(i);
            }
                
        }
        checkCollision();
        Respawn();
    }
    public boolean collision(VectorSprite pCollider, VectorSprite pCollideee){
        
        for (int i = 0; i < pCollideee.drawShape.npoints; i++){
            if (pCollider.drawShape.contains (pCollideee.drawShape.xpoints[i], pCollideee.drawShape.ypoints[i])){
                return true;
            }
        }
        for (int i = 0; i < pCollider.drawShape.npoints; i++){
            if (pCollideee.drawShape.contains (pCollider.drawShape.xpoints[i], pCollider.drawShape.ypoints[i])) {
                return true;
            }
        }
       return false;
    }
    public void checkCollision(){
        
        for (int i = 0; i < mAsteroidlist.size(); i++){
            
            if (collision(ship, mAsteroidlist.get(i)) && ship.mActive == true){ 
                for (int j = 0; j < Math.random()*30 + 15; j++){
                    mExplosionlist.add(new DebreeOfExplosionnessWithoutDeathNess(ship.xposition, ship.yposition));
                }
                ship.mActive = false;
                mCounter = 0;
            }
            
            for (int j = 0; j < mBulletslist.size(); j++){
                if (collision(mBulletslist.get(j), mAsteroidlist.get(i))){
                    mAsteroidlist.get(i).mActive = false;
                    mBulletslist.get(j).mActive = false;
                }
            }
        }       
    }
    public void Respawn(){
        mCounter++;
        if (ship.mActive == false && mCounter > 50 && !checkDistance()){
            ship.mActive = true;
            ship.xposition = 450;
            ship.yposition = 300;
            ship.xspeed = 0;
            ship.yspeed = 0;
            ship.angle = 0; 
        }
    }
    public boolean checkDistance(){
        
        for (int i = 0; i < mAsteroidlist.size(); i++){
            double a, b;
            a = 450 - mAsteroidlist.get(i).xposition;
            b = 300 - mAsteroidlist.get(i).yposition;
            
            if (a*a + b*b < 75*75){
                return true;
            }
        }
        return false;
    } 
    
    public void start() {
        mTimer.start();
    }
    public void stop() {
        mTimer.stop();
    }   
}
