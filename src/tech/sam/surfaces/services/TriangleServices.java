package tech.sam.surfaces.services;

import tech.sam.surfaces.entities.Point;
import tech.sam.surfaces.enums.FigureType;
import tech.sam.surfaces.utilities.OperationsUtilities;

import java.util.List;

public class TriangleServices extends OperationsUtilities implements SurfaceServices{

    @Override
    public double calculate(List<Point> points) {
        double basse=this.distance(points.get(0),points.get(1));
        double hauteur=this.distance(points.get(0),points.get(2));
        this.save(FigureType.TRIANGLE,points);
        return basse * hauteur /2;
    }

    @Override
    public void read() {
    super.read();
    }
}
