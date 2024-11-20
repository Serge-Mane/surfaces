package tech.sam.surfaces.services;

import tech.sam.surfaces.entities.Point;
import tech.sam.surfaces.enums.FigureType;
import tech.sam.surfaces.utilities.OperationsUtilities;

import java.util.List;

public class CircleServices extends OperationsUtilities implements SurfaceServices{
    @Override
    public double calculate(List<Point> points) {
           double diameter=this.distance(points.get(0),points.get(1));
           this.save(FigureType.CIRCLE,points);
           return Math.pow((diameter/2),2)*Math.PI;
    }

    @Override
    public void read() {
    super.read();
    }
}
