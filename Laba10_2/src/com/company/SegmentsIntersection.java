package com.company;

import java.awt.*;
import java.io.IOException;

public class SegmentsIntersection {

    static public boolean isIntersect(Segment s1,Segment s2)
    {
        MyPoint x1y1=s1.getP1();
        MyPoint x2y2=s1.getP2();
        MyPoint x3y3=s2.getP1();
        MyPoint x4y4=s2.getP2();
        double d1 = (x4y4.x - x3y3.x) * (x1y1.y - x3y3.y) - (x4y4.y - x3y3.y) * (x1y1.y - x3y3.y);
        double d2 = (x4y4.x - x3y3.x) * (x2y2.y - x3y3.y) - (x4y4.y - x3y3.y) * (x2y2.y - x3y3.y);
        double d3 = (x2y2.x - x1y1.x) * (x3y3.y - x1y1.y) - (x2y2.y - x1y1.y) * (x3y3.y - x1y1.y);
        double d4 = (x2y2.x - x1y1.x) * (x4y4.y - x1y1.y) - (x2y2.y - x1y1.y) * (x4y4.y - x1y1.y);
        if (d1 * d2 <= 0 && d3 * d4 <= 0)
            return true;
        return false;
    }
    static public MyPoint intersection(Segment s1,Segment s2)
    {
        if(isIntersect(s1,s2)==false) {
            return  new MyPoint();
        }
        else {
            MyPoint A = s1.getP1();
            MyPoint B = s1.getP2();
            MyPoint C = s2.getP1();
            MyPoint D = s2.getP2();
            double xo = A.x, yo = A.y;
            double p = B.x - A.x, q = B.y - A.y;

            double x1 = C.x, y1 = C.y;
            double p1 = D.x - C.x, q1 = D.y - C.y;

            double x = (xo * q * p1 - x1 * q1 * p - yo * p * p1 + y1 * p * p1) /
                    (q * p1 - q1 * p);
            double y = (yo * p * q1 - y1 * p1 * q - xo * q * q1 + x1 * q * q1) /
                    (p * q1 - p1 * q);

            return new MyPoint((int) x, (int) y);
        }
    }
    public static void main(String[] args) throws IOException {
        Segment s1=new Segment(new MyPoint(3,5),new MyPoint(7,9));
        Segment s2=new Segment(new MyPoint(5,9),new MyPoint(7,7));
        Segment s3=new Segment(new MyPoint(0,2),new MyPoint(0,4));
        Segment s4=new Segment(new MyPoint(6,0),new MyPoint(2,0));

        System.out.println(s1.toString()+" "+s2.toString());
        System.out.println(isIntersect(s1,s2));
        MyPoint intersectionMyPoint=intersection(s1,s2);
        System.out.println(intersectionMyPoint.toString());

        System.out.println(s3.toString()+" "+s4.toString());
        System.out.println(isIntersect(s3,s4));
        MyPoint intersectionMyPoint1=intersection(s3,s4);
        System.out.println(intersectionMyPoint1.toString());
    }
}
