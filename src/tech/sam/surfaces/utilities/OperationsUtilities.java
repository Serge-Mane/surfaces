package tech.sam.surfaces.utilities;

import tech.sam.surfaces.dao.SurfaceDAO;
import tech.sam.surfaces.entities.Figure;
import tech.sam.surfaces.entities.Point;
import tech.sam.surfaces.enums.FigureType;

import java.util.List;

public abstract class OperationsUtilities {
    SurfaceDAO surfaceDAO=new SurfaceDAO();
    //seul les classes filles qui heritent de cette classe qui peuvent utiliser la methode protected
    protected double distance(Point PointOne, Point pointTwo){
        double x= Math.pow((pointTwo.getX()- PointOne.getX()), 2);
        double y= Math.pow((pointTwo.getY()- PointOne.getY()), 2);
        return Math.sqrt(x + y);
    }

    protected void save(FigureType figureType, List<Point> points){
        Figure figure=new Figure();
        figure.setName(figureType);
        int figureId=this.surfaceDAO.saveFigure(figure);
        points.forEach(point -> this.surfaceDAO.savePoint(point,figureId));
    }
}
