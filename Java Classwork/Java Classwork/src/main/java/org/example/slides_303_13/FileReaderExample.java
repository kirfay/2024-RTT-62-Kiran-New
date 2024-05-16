package org.example.slides_303_13;

import java.io.File;
import java.io.FileReader;

public class FileReaderExample {

    public static void main(String[] args) {
        try {
            File input = new File(pathname: "output.txt");
            FileReader fileReader = new FileReader(input);
        }
    }
}
