package com.gast9ra;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws Exception {
	Scanner in = new Scanner(System.in);
	map("a1-1-2-1,a1-1-1-5");

    }

    private static void map(String position){
        String[] points=position.toLowerCase().split(",");
        DotMap start=new DotMap(points[0]);
        System.out.println(8%3);
        DotMap finish=new DotMap(points[1]);
        System.out.println("Дистанция");
        System.out.println(distans(start.getDot(),finish.getDot()));
        System.out.println("Азимут");
        System.out.println(asimut(start.getDot(),finish.getDot()));
    }

    private static double distans(Point position1,Point position2){
        return Math.sqrt(Math.pow((position2.getX()-position1.getX()),2)
                +Math.pow((position2.getY()-position1.getY()),2));
    }

    private static double asimut(Point dot1,Point dot2){
        Point dot3=new Point(dot1.getX(),dot2.getY());
        double deger=Math.toDegrees(Math.atan(distans(dot2,dot3)/distans(dot1,dot3)));
        if (dot1.getX()-dot2.getX()>0||dot1.getY()-dot2.getY()>0){
            return 360-deger;
        }else if (dot1.getX()-dot2.getX()<=0||dot1.getY()-dot2.getY()<=0){
            return 0+deger;
        }else throw new NumberFormatException();
    }


}
