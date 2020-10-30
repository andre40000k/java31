package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args ) throws IOException{

        Figure fg = new Figure();

        fg.triangle.add(new Triangle (2,2,2));
        fg.triangle.add(new Triangle (2,3,2));
        fg.triangle.add(new Triangle (4,5,4));
        fg.triangle.add(new Triangle (3,3,3));
        fg.angle.add(new Angle(fg.triangle.get(0).getSide1(), fg.triangle.get(0).getSide2(), fg.triangle.get(0).getSide3()));
        fg.angle.add(new Angle(fg.triangle.get(1).getSide1(), fg.triangle.get(1).getSide2(), fg.triangle.get(1).getSide3()));
        fg.angle.add(new Angle(fg.triangle.get(2).getSide1(), fg.triangle.get(2).getSide2(), fg.triangle.get(2).getSide3()));
        fg.angle.add(new Angle(fg.triangle.get(3).getSide1(), fg.triangle.get(3).getSide2(), fg.triangle.get(3).getSide3()));


        System.out.println(Aveequequilater(fg.triangle, fg.angle));
        System.out.println(fg.triangle.toString());
        System.out.println(fg.angle.toString());
        //System.out.println(fg.ffigure.toString());


        SLFile slfile = new SLFile();

        slfile.save("save.txt",fg.triangle, fg.angle);
        fg.clear();
        slfile.read("save.txt",fg.triangle,fg.angle);

        slfile.serielize("save_serialize.txt",fg.triangle, fg.angle);
        fg.clear();
        fg = slfile.deserialize("save_serialize.txt",fg.triangle, fg.angle);

        slfile.serializeFastjson("figure_json.json", fg.triangle, fg.angle);
        fg.clear();
        fg = slfile.deserializeFastjson("figure_json.json", fg.triangle, fg.angle);
    }

    public static String Aveequequilater(final ArrayList<Triangle> triangle,  ArrayList<Angle> angle )
    {
        double averagearea = 0;
        double largestequilatertriangle = 0;
        int n = 0, i = 0;
        for(Triangle triangle1 : triangle) {

            if (angle.get(n).getAngle1() == angle.get(n).getAngle2() && angle.get(n).getAngle2() == angle.get(n).getAngle3() && angle.get(n).getAngle1() != 0 && triangle1.getPerimeter()>largestequilatertriangle) {
                largestequilatertriangle = triangle1.getPerimeter();
            }
            else{
                averagearea += triangle.get(n).getArea();
                i++;
            }
            n++;
        }
        averagearea = averagearea/i;
        return "Average area = " + averagearea + "\n" + "Largest equilater triangle = " + largestequilatertriangle;
    }
}
