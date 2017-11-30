package com.gast9ra;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        System.out.println("Пример: A1-3-5-1");
        map("a1-1-1-1,s1-2-9-9");
        while (true) {
            System.out.println("Введите начальную точку");
            String first = read.nextLine();
            System.out.println("Введите цель");
            String second = read.nextLine();
            map(first + "," + second);
        }
    }

    private static void map(String position) {
        String[] points = position.toLowerCase().split(",");
        DotMap start = new DotMap(points[0]);
        DotMap finish = new DotMap(points[1]);
        System.out.println("Дистанция");
        System.out.println(distans(start.getDot(), finish.getDot()));
        System.out.println("Азимут");
        System.out.println(asimut(start.getDot(), finish.getDot()));
        System.out.println("_______________");
    }

    private static double distans(Point position1, Point position2) {
        return Math.sqrt(Math.pow((position2.getX() - position1.getX()), 2)
                + Math.pow((position2.getY() - position1.getY()), 2));
    }

    private static double asimut(Point dot1, Point dot2) {
        Point dot3 = new Point(dot1.getX(), dot2.getY());
        double deger = Math.toDegrees(Math.atan(distans(dot2, dot3) / distans(dot1, dot3)));
        if (dot1.getX() - dot2.getX() > 0 || dot1.getY() - dot2.getY() > 0) {
            return 360 - deger;
        } else if (dot1.getX() - dot2.getX() <= 0 || dot1.getY() - dot2.getY() <= 0) {
            return 0 + deger;
        } else throw new NumberFormatException();
    }


}
