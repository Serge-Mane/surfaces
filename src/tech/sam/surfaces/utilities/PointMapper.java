package tech.sam.surfaces.utilities;

import tech.sam.surfaces.entities.Point;

import java.util.ArrayList;
import java.util.List;

public class PointMapper {
    public List<Point> coordinateToPoint(List<Integer> coordinates){
        List<Point> points=new ArrayList<>();
        if (coordinates.size()==4){
            Point pointOne=new Point();
            pointOne.setX(coordinates.get(0));
            pointOne.setY(coordinates.get(1));
            points.add(pointOne);

            Point pointTwo=new Point();
            pointTwo.setX(coordinates.get(2));
            pointTwo.setY(coordinates.get(3));
            points.add(pointTwo);
        }
        if (coordinates.size()==6){
            points.add(new Point(coordinates.get(0),coordinates.get(1)));
            points.add(new Point(coordinates.get(2),coordinates.get(3)));
            points.add(new Point(coordinates.get(4),coordinates.get(5)));
    }
        return   points;
    }
}
