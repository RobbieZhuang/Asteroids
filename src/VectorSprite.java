//UTILIZE BRACKETS AND SEMI-COLON

import java.awt.*;

public class VectorSprite {
    
    double xposition, yposition, xspeed, yspeed, angle;
    Polygon shape;
    Polygon drawShape;
    final double ROTATION = 10*Math.PI/180;
    final double THEFORCE = 0.5;
            //final <type> <name> = <value>
            //final = constants;
    boolean mActive = true;
    int mCounter;
    
    
    
    public VectorSprite() {
        //Constuctor         
    }
    
    public void paint(Graphics g){
        if (mActive == true){
            /*
            int R = (int)(Math.random()* 255);
            int G = (int)(Math.random()* 255);
            int B = (int)(Math.random()* 255);
            Color colour = new Color(R,G,B);
            
            g.setColor(colour);
            */
            g.drawPolygon(drawShape);
        }
        
        /*To Fill Shapes :D
         * g.fillPolygon(drawShape);
        */
    }
    
    public void updatePosition() {
        
        xposition += xspeed;
        yposition += yspeed;
        
        //In one end and out the other :D
        
        
        if (xposition > 900){
            xposition = 0;
        }
        if (xposition < 0){
            xposition = 900;
        }
        if (yposition > 600){
            yposition = 0;
        }
        if (yposition <0){
            yposition = 600;
        }
                
        int x, y;
              
        for (int i = 0; i < shape.npoints; i++){
            
            // "i < shape.npoints" <---- as long as i is less than shape.npoints, then this forloop will continue
            // i++ for every time this forloop continues, 1 is added to i
            
                   x = (int)Math.round(shape.xpoints[i]*Math.cos(angle) - shape.ypoints[i]*Math.sin(angle));
                   y = (int)Math.round(shape.xpoints[i]*Math.sin(angle) + shape.ypoints[i]*Math.cos(angle));
                   
                    /* for awesome turningness :D
                    *   y = (int)Math.round(shape.xpoints[i]*Math.sin(angle) - shape.ypoints[i]*Math.cos(angle));
                    */
                   
            drawShape.xpoints[i] = x;
            drawShape.ypoints[i] = y;
        }
            drawShape.invalidate();
            drawShape.translate((int)Math.round(xposition), (int)Math.round(yposition));
            
            mCounter++;
    }
    
    
}
