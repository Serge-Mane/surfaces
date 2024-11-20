package tech.sam.surfaces;

import tech.sam.surfaces.entities.Point;
import tech.sam.surfaces.services.SurfaceService;
import tech.sam.surfaces.utilities.PointMapper;
import tech.sam.surfaces.utilities.ReaderUtilities;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        SurfaceService surfaceService=new SurfaceService();
        ReaderUtilities readerUtilities=new ReaderUtilities();
        PointMapper mapper=new PointMapper();
        int choice=readerUtilities.readChoice();
        List<Integer> coordinates=readerUtilities.readData(choice);
        /*
        for (int i=0;i<coordinates.size();i++){
            System.out.println(String.format("coordonees %s vaut %s",i,coordinates.get(i)));
        }*/

        coordinates.forEach(item-> System.out.printf("coordonees %s",item));
       List<Point>points= mapper.coordinateToPoint(coordinates);

       double surface=surfaceService.calculate(choice,points);
        System.out.printf("surface %s",surface);
    }
}