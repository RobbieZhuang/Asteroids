
import java.awt.Polygon;


public class DebreeOfExplosionnessWithoutDeathNess extends VectorSprite {
    
    public DebreeOfExplosionnessWithoutDeathNess(double xposition, double yposition){
        
        shape = new Polygon();
        shape.addPoint (0,0);
        shape.addPoint (0,0);
        
        drawShape = new Polygon();
        drawShape.addPoint (0, 0);
        drawShape.addPoint (0,0);
        
        double pSpeed = Math.random() + 2;
        
        double pAngle = Math.random() * 2 * Math.PI;
        
        xspeed = Math.cos(pAngle)*pSpeed;
        yspeed = Math.sin(pAngle)*pSpeed;
        
        this.xposition = xposition;
        this.yposition = yposition;
    }
    public void updatePosition() {
        super.updatePosition(); 
        if (mCounter > 50){  
            this.mActive = false;
        }
    }
}
