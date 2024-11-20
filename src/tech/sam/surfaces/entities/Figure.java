package tech.sam.surfaces.entities;

import tech.sam.surfaces.enums.FigureType;

import java.util.List;

public class Figure {
    private int id;
    private FigureType name;
    private List<Point> points;

    public Figure() {
    }

    public Figure(int id, FigureType name, List<Point> points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FigureType getName() {
        return name;
    }

    public void setName(FigureType name) {
        this.name = name;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
