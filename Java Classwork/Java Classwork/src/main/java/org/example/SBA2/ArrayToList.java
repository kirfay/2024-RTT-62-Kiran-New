package org.example.SBA2;

import java.util.ArrayList;

public class ArrayToList {

    private ArrayList<String> arrayToList = new ArrayList<>();

    public ArrayToList() {
        arrayToList = new ArrayList<>();
    }

    public void convert(String[] a) {
        for ( int pos = 0 ; pos < a.length ; pos++ ) {
            arrayToList.add(a[pos]);
            System.out.println("I have added the string: " + a[pos] + "at the index: " + pos);
        }
    }

    public void replace(int idx) {
        String value = arrayToList.get(idx);
        arrayToList.set(idx, "");
        System.out.println("I have replaced the string: " + value + " with a null string");

        String x = "";
        String Y = null;
    }

    public ArrayList<String> compact() {
        ArrayList<String> result = new ArrayList<>();

        for (String s : arrayToList ) {
            if ( s.equals("")) {
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayToList arrayToList = new ArrayToList();

        String[] strArray = {"one", "two", "three", "four", "five"};
        arrayToList.convert(strArray);

        arrayToList.replace(1);
        arrayToList.replace(2);

        ArrayList<String> compacted = arrayToList.compact();
        for( String c : compacted ) {
            System.out.println(c);
        }
    }
}
