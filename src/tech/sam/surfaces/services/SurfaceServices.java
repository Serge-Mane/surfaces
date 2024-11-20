package tech.sam.surfaces.services;

import tech.sam.surfaces.entities.Point;

import java.util.List;

public interface SurfaceServices {
   double calculate(List<Point> points);

   void read();
}
