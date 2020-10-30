package com.company;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class SLFile {
    public int n = 0, i = 0;
    public Figure serielize(String filename, ArrayList<Triangle> triangle, ArrayList<Angle> angle) throws IOException{
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(triangle);
            out.writeObject(angle);
            fileOut.close();
            out.close();
        } catch (IOException e) {
            System.out.println("Error = " + e);
        }
        return new Figure(triangle, angle);
    }

    public Figure deserialize(String filename, ArrayList<Triangle> triangle, ArrayList<Angle> angle) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            triangle  = (ArrayList<Triangle>) in.readObject();
            angle = (ArrayList<Angle>) in.readObject();
            in.close();
            fileIn.close();
            return new Figure(triangle, angle);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Student class not found");
            c.printStackTrace();
        }
        return new Figure(triangle, angle);
    }


    public void save(String filename, ArrayList<Triangle> triangle, ArrayList<Angle> angle) throws IOException {
        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Triangle triangle1 : triangle) {
            n++;
            if(triangle1.getArea() != 0 ) {
                try {
                    bw.write("Triangle " + n + "\n{" + "\n" +
                            "side1 = " + triangle1.getSide1() + "\n" +
                            "side2 = " + triangle1.getSide2() + "\n" +
                            "side3 = " + triangle1.getSide3() + "\n" +
                            "perimeter =" + triangle1.getPerimeter() + "\n" +
                            "area = " + triangle1.getArea() + "\n" +
                            "angle1 =" + angle.get(i).getAngle1() + "\n" +
                            "angle2 =" + angle.get(i).getAngle2() + "\n" +
                            "angle3 =" + angle.get(i).getAngle3() + "\n}\n");
                    bw.write(System.lineSeparator());

                } catch (IOException e) {
                    System.out.println("Error" + e);
                }
            }
            i++;
        }
        bw.close();
        fw.close();
    }

    public void read(String filename, ArrayList<Triangle> triangle, ArrayList<Angle> angle) throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(filename));
        String line;
        while((line = br.readLine()) != null )
        {
            System.out.println(line);
        }
        br.close();
    }

    public void serializeFastjson(String filename, ArrayList<Triangle> triangle, ArrayList<Angle> angle) throws IOException {
        FileWriter os = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(os);
        bw.write(JSON.toJSONString(triangle));
        bw.write("\n");
        bw.write(JSON.toJSONString(angle));
        bw.close();
        os.close();
    }

    public Figure deserializeFastjson(String filename, ArrayList<Triangle> triangle, ArrayList<Angle> angle) throws IOException {

        FileReader fr = new FileReader(filename);
        Scanner scanner = new Scanner(fr);
        Triangle c = null;

        ArrayList<JSONObject> JSONlist = JSON.parseObject(scanner.nextLine(), ArrayList.class);
        for (JSONObject st : JSONlist) {
            triangle.add(new Triangle(st.getDouble("side1"), st.getDouble("side2"),st.getDouble("side3")));
        }

        JSONlist = JSON.parseObject(scanner.nextLine(), ArrayList.class);
        for (JSONObject st : JSONlist) {
            angle.add(new Angle(st.getDouble("angle1"), st.getDouble("angle2"),st.getDouble("angle3")));
        }

        scanner.close();
        fr.close();

        return new Figure(triangle, angle);
    }


}
