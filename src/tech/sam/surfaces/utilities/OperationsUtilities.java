package tech.sam.surfaces.utilities;

import tech.sam.surfaces.entities.Point;

public class OperationsUtilities {
    public double distance(Point PointOne, Point pointTwo){
        double x= Math.pow((pointTwo.getX()- PointOne.getX()), 2);
        double y= Math.pow((pointTwo.getY()- PointOne.getY()), 2);
        return Math.sqrt(x + y);
    }
}
