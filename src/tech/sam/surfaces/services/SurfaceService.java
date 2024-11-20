package tech.sam.surfaces.services;

import tech.sam.surfaces.dao.SurfaceDAO;
import tech.sam.surfaces.entities.Figure;
import tech.sam.surfaces.entities.Point;
import tech.sam.surfaces.utilities.OperationsUtilities;

import java.sql.SQLException;
import java.util.List;

public class SurfaceService {
    SurfaceDAO surfaceDAO=new SurfaceDAO();
    OperationsUtilities operationsUtilities =new OperationsUtilities();
    public  double calculate(int choice,List<Point>points){
        double surface=0;
        if (points.size()==2){
            double diameter=this.operationsUtilities.distance(points.get(0),points.get(1));
            surface=Math.pow((diameter/2),2)*Math.PI;
        }
        if (points.size()==6 && choice==2){
            double largeur=this.operationsUtilities.distance(points.get(0),points.get(1));
            double longueur=this.operationsUtilities.distance(points.get(0),points.get(2));
            surface=largeur * longueur;
        }
        if (points.size()==6 && choice==3){
            double basse=this.operationsUtilities.distance(points.get(0),points.get(1));
            double hauteur=this.operationsUtilities.distance(points.get(0),points.get(2));
            surface=basse * hauteur /2;
        }


    /*    points.forEach(point -> {
            try {
                this.surfaceDAO.savePoint(point);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });*/
        Figure figure=new Figure();
        figure.setName("" + choice);
        int figureId=this.surfaceDAO.saveFigure(figure);
        points.forEach(point -> this.surfaceDAO.savePoint(point,figureId));
    return surface;
    }
}
