import java.awt.Polygon;
/**
 *
 * @author ShinysDescendant
 */
public class BulletsOfDeathAndOfAlsoFlyingness extends VectorSprite {
    

    public BulletsOfDeathAndOfAlsoFlyingness(double xposition, double yposition, double angle){
        shape = new Polygon();
        shape.addPoint (-2,-2);
        shape.addPoint (2,-2);
        shape.addPoint (2,2);
        shape.addPoint (-2,2);
        

        drawShape = new Polygon();
        drawShape.addPoint (-2,-2);
        drawShape.addPoint (2,-2);
        drawShape.addPoint (2,2);
        drawShape.addPoint (-2,2);
       
        this.xposition = xposition;
        this.yposition = yposition;
        this.angle = angle;
        
        xspeed += Math.cos(angle)*15/2;
        yspeed += Math.sin(angle)*15/2;
        
    }

    @Override
    public void updatePosition() {
        super.updatePosition(); 
        if (mCounter > 50){ //How long bullet stays alive  
            this.mActive = false;
        }
    }
}
