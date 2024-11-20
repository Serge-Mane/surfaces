package tech.sam.surfaces;

import tech.sam.surfaces.entities.Point;
import tech.sam.surfaces.enums.FigureType;
import tech.sam.surfaces.services.*;
import tech.sam.surfaces.utilities.PointMapper;
import tech.sam.surfaces.utilities.ReaderUtilities;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        SurfaceServices rectangleService=new RectangleService();
        SurfaceServices triangleService=new TriangleServices();
        SurfaceServices circleServices=new CircleServices();

        ReaderUtilities readerUtilities=new ReaderUtilities();


        int choice=readerUtilities.readChoice();
        FigureType figureType= FigureType.values()[choice -1];


        List<Integer> coordinates=readerUtilities.readData(choice);
        /*
        for (int i=0;i<coordinates.size();i++){
            System.out.println(String.format("coordonees %s vaut %s",i,coordinates.get(i)));
        }*/

        coordinates.forEach(item-> System.out.printf("coordonees %s",item));


        PointMapper mapper=new PointMapper();
        List<Point>points= mapper.coordinateToPoint(coordinates);

       double surface;
        switch (figureType){
            case RECTANGLE ->{
                surface=rectangleService.calculate(points);
            }
            case TRIANGLE -> {
                surface=triangleService.calculate(points);
            }
            default-> {
                surface=circleServices.calculate(points);
            }
        }

        System.out.printf("surface %s",surface);
    }
}