

import java.awt.Polygon;


public class AsteroidOfAlsoFlyingness extends VectorSprite {
    
    public double mSize = 3;
    
    public AsteroidOfAlsoFlyingness(){
        initializeAsteroid();
    }
    public AsteroidOfAlsoFlyingness(double xposition, double yposition, double size){
        this.mSize = size;
        initializeAsteroid();
        this.xposition = xposition;
        this.yposition = yposition;
           
} 
    public void updatePosition(){
        super.updatePosition();       
        angle += ROTATION;
    }
    public void initializeAsteroid(){
        shape = new Polygon();
        shape.addPoint (-10, -10);
        shape.addPoint (-10,10);
        shape.addPoint (10,10);
        shape.addPoint (10,-10);

        
        
        drawShape = new Polygon();
        drawShape.addPoint (-10, -10);
        drawShape.addPoint (-10,10);
        drawShape.addPoint (10,10);
        drawShape.addPoint (10,-10);

        
        for (int i = 0; i < shape.npoints; i++){
            shape.xpoints[i] *= mSize;
            shape.ypoints[i] *= mSize;
        }
        
        double pSpeed = Math.random() + 2;
        
        double pAngle = Math.random() * 2 * Math.PI;
        
        xspeed = Math.cos(pAngle)*pSpeed;
        yspeed = Math.sin(pAngle)*pSpeed;
        
        pSpeed = Math.random() * 100 + 150;
        pAngle = Math.random() * 2 * Math.PI;
        
        xposition = Math.cos(pAngle)*pSpeed + 450;
        yposition = Math.sin(pAngle)*pSpeed + 300;
    }
    
}

