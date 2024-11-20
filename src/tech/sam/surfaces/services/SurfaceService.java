package tech.sam.surfaces.services;

import tech.sam.surfaces.dao.SurfaceDAO;
import tech.sam.surfaces.entities.Figure;
import tech.sam.surfaces.entities.Point;
import tech.sam.surfaces.enums.FigureType;
import tech.sam.surfaces.utilities.OperationsUtilities;

import java.sql.SQLException;
import java.util.List;

public class SurfaceService {
    SurfaceDAO surfaceDAO=new SurfaceDAO();
    OperationsUtilities operationsUtilities =new OperationsUtilities();
    public  double calculate(int choice,List<Point>points){
        double surface=0;
        FigureType figureType= FigureType.values()[choice -1];

        switch (figureType){
            case RECTANGLE ->{
                double largeur=this.operationsUtilities.distance(points.get(0),points.get(1));
                double longueur=this.operationsUtilities.distance(points.get(0),points.get(2));
                surface=largeur * longueur;
            }
            case TRIANGLE -> {
                double basse=this.operationsUtilities.distance(points.get(0),points.get(1));
                double hauteur=this.operationsUtilities.distance(points.get(0),points.get(2));
                surface=basse * hauteur /2;
            }
            default->{
                double diameter=this.operationsUtilities.distance(points.get(0),points.get(1));
                surface=Math.pow((diameter/2),2)*Math.PI;
            }
        }


    /*    points.forEach(point -> {
            try {
                this.surfaceDAO.savePoint(point);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });*/
        Figure figure=new Figure();
        figure.setName(figureType);
        int figureId=this.surfaceDAO.saveFigure(figure);
        points.forEach(point -> this.surfaceDAO.savePoint(point,figureId));
    return surface;
    }
}
