package com.company;

public class Angle extends Triangle {

    private double angle1;
    private double angle2;
    private double angle3;

    public Angle(final double side1, final double side2, final double side3) {
        super(side1, side2, side3);
        this.setAngle1();
        this.setAngle2();
        this.setAngle3();
    }


    @Override
    public String toString() {
        return "Angles{" + "\n" +
                "angle1=" + getAngle1() + "\n" +
                "angle2=" + getAngle2() + "\n" +
                "angle3=" + getAngle3() + "\n}";
    }

    public void setAngle1() {
        if(getArea() != 0){
        this.angle1 = Math.cos((Math.pow(getSide2(),2) + Math.pow(getSide3(),2) - Math.pow(getSide1(),2))/(2*getSide2()*getSide3()));
        }
        else {
        this.angle1 = 0;
        }
    }

    public void setAngle2() {
        if(getArea() != 0){
            this.angle2 = Math.cos((Math.pow(getSide1(),2) + Math.pow(getSide3(),2) - Math.pow(getSide2(),2))/(2*getSide1()*getSide3()));
        }
        else {
            this.angle2 = 0;
        }
    }

    public void setAngle3() {
        if(getArea() != 0){
            this.angle3 = Math.cos((Math.pow(getSide2(),2) + Math.pow(getSide1(),2) - Math.pow(getSide3(),2))/(2*getSide2()*getSide1()));
        }
        else {
            this.angle3 = 0;
        }
    }

    public double getAngle1() { return angle1;}
    public double getAngle2() { return angle2;}
    public double getAngle3() { return angle3;}




}
