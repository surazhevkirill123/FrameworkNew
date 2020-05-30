package com.company;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        System.out.println("Введите кол-во отрезков:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Segment[]segments=new Segment[n];
        for (int i=0;i<segments.length;i++) {
            segments[i]=new Segment();
        }
        ArrayList<MyPoint> intersectionMyPoints = new ArrayList<>();
        for (int i=0;i<segments.length-1;i++) {
            for (int j=i+1;j<segments.length;j++) {
                if(SegmentsIntersection.intersection(segments[i],segments[j]).x<=10 && SegmentsIntersection.intersection(segments[i],segments[j]).y<=10
                        && SegmentsIntersection.intersection(segments[i],segments[j]).x>0 && SegmentsIntersection.intersection(segments[i],segments[j]).y>0) {
                    intersectionMyPoints.add(SegmentsIntersection.intersection(segments[i],segments[j]));
                }
            }
        }
        System.out.println("Список отрезков:");
        System.out.println(Arrays.toString(segments));
        System.out.println("Список точек пересечения:");
        System.out.println(intersectionMyPoints.toString());
        Map<Object, Object> treeMap1 = new TreeMap<>();

        for (int i=0;i<intersectionMyPoints.size();i++) {
            treeMap1.put(intersectionMyPoints.get(i).x,intersectionMyPoints.get(i));
        }
        System.out.println("Список TreeMap(ключ-абсцисса, значение-точка):");
        for(Map.Entry<Object, Object> e : treeMap1.entrySet()) {
            System.out.println(e.getKey()+" "+ e.getValue());
        }
        System.out.println("Точка с минимальной абсциссой:");
        System.out.println("Ключ : " + ((TreeMap<Object, Object>) treeMap1).firstKey()
                + ", значение : " + treeMap1.get(((TreeMap<Object, Object>) treeMap1).firstKey()));

    }
}