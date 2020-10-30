package com.company;

public class Triangle implements tSide {
    private double side1;
    private double side2;
    private double side3;
    private double area;
    private double perimeter;

    public Triangle(final double side1, final double side2, final double side3) {
        this.setSide1(side1);
        this.setSide2(side2);
        this.setSide3(side3);
        this.setArea();
        this.setPerimeter();
    }

    @Override
    public String toString() {
        return "Triangle{" + "\n" +
                "perimeter =" + getPerimeter() + "\n" +
                "area = " + getArea() + "\n}";
    }

    public void setArea() {
        if (side1 > 0 && side2 > 0 && side3 > 0 && side1 + side2 > side3 && side1 + side3 > 0 && side2 + side3 > side1) {
            this.area = Math.sqrt(P() * (P() - side1) * (P() - side2) * (P() - side3));
        } else {
            this.area = 0;
        }
    }

    private double P() { return (side1 + side2 + side3) / 2;    }

    public void setPerimeter() {
        if (side1 > 0 && side2 > 0 && side3 > 0 && side1 + side2 > side3 && side1 + side3 > 0 && side2 + side3 > side1) {
            this.perimeter = side1 + side2 + side3;
        }
        else {
            this.perimeter = 0;
        }
    }

    public double getArea() { return area;}
    public double getPerimeter() { return perimeter;}
    public void setSide1(final double side1) { this.side1 = side1;}
    public void setSide2(final double side2) { this.side2 = side2;}
    public void setSide3(final double side3) { this.side3 = side3;}
    public double getSide1() {return side1;}
    public double getSide2() {return side2;}
    public double getSide3() {return side3;}
}
