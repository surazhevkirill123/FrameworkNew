package com.company;

import java.util.Objects;

public class Segment {
    private MyPoint p1;
    private MyPoint p2;


    Segment(){
        int min=1;
        int max=10;
        this.p1=new MyPoint((int)(Math.random() * ((max - min) + 1)) + min,(int)(Math.random() * ((max - min) + 1)) + min);
        this.p2=new MyPoint((int)(Math.random() * ((max - min) + 1)) + min,(int)(Math.random() * ((max - min) + 1)) + min);
    }

    Segment(MyPoint p1,MyPoint p2) {
        this.p1=p1;
        this.p2=p2;
    }

    public void setP1(MyPoint p1) {
        this.p1 = p1;
    }

    public void setP2(MyPoint p2) {
        this.p2 = p2;
    }

    public MyPoint getP1() {
        return p1;
    }

    public MyPoint getP2() {
        return p2;
    }

    @Override
    public String toString() {
        return "\n"+"Segment{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return Objects.equals(p1, segment.p1) &&
                Objects.equals(p2, segment.p2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2);
    }
}