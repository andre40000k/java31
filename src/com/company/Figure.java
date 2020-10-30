package com.company;


import java.util.ArrayList;

public class Figure{

    ArrayList<Triangle> triangle;
    ArrayList<Angle> angle;

    public Figure() {
        triangle = new ArrayList<>();
        angle = new ArrayList<>();
    }

    public Figure( ArrayList<Triangle> triangle, ArrayList<Angle> angle) {
        this.triangle = triangle;
        this.angle = angle;
    }

    public void clear() {
        this.triangle.clear();
        this.angle.clear();
    }
}
