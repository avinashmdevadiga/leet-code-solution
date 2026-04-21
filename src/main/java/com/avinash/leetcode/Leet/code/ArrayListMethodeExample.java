package com.avinash.leetcode.Leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Tuple implements Comparable<Tuple>{
    int a,b;
    public Tuple(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a + "," + b;
    }

    @Override
    public int compareTo(Tuple other) {
        if (this.b != other.b){
            return this.b-other.b;
        }
        return this.a-other.a;
    }
}
public class ArrayListMethodeExample {
    static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println(Arrays.toString(integers.toArray()));

        List<Integer> list = Arrays.asList(1, 4, 3, 2, 2);
        System.out.println(list);

        int[] ints = new int[]{10, 2, 3, 30, 4, 6, 2};

        Arrays.sort(ints, 3, 6);

        System.out.println(Arrays.toString(ints));

        //Binary Search

        int[] intArray1 = {11, 12, 20, 34, 65, 79, 90};

        int key = 12;
        System.out.println("index of " + key + ": " + Arrays.binarySearch(intArray1, key));

        System.out.println(Arrays.binarySearch(intArray1, 0, 3, key));

        // fill method

        int[] intArray2 = new int[10];
        Arrays.fill(intArray2, 5);
        System.out.println(Arrays.toString(intArray2));

        //sort

        Tuple[] tuples = new Tuple[4];

        tuples[0] = new Tuple(1, 4);
        tuples[1] = new Tuple(2, 3);
        tuples[2] = new Tuple(3, 2);
        tuples[3] = new Tuple(4, 1);

//        Arrays.sort(tuples);
        Arrays.sort(tuples,(o1,o2)->{
            if (o1.a>o2.a) return o1.a-o2.a;
            else if (o2.a>o1.a) return o2.a-o1.a;
            return 0;
        });
        for (int i = 0; i < tuples.length; i++) {
            System.out.println(tuples[i]);
        }


    }
}
