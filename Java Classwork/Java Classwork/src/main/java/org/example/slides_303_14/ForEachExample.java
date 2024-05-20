package org.example.slides_303_14;

import java.util.ArrayList;
import java.util.List;

public class ForEachExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Larry");
        names.add ("Steve") ;
        names.add ("James") ;
        names.add ( "Conan") ;
        names.add ( "Ellen") ;
        names.forEach (name -> {  System.out.println (name);    } );
    }
}

