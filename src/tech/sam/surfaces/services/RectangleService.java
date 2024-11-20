package tech.sam.surfaces.services;

import tech.sam.surfaces.entities.Point;
import tech.sam.surfaces.enums.FigureType;
import tech.sam.surfaces.utilities.OperationsUtilities;

import java.util.List;

public class RectangleService extends OperationsUtilities implements SurfaceServices{
    @Override
    public double calculate(List<Point> points) {
        double largeur=this.distance(points.get(0),points.get(1));
        double longueur=this.distance(points.get(0),points.get(2));
        this.save(FigureType.RECTANGLE,points);
        return largeur * longueur;
    }

    public void read(){
        super.read();
    }
}
