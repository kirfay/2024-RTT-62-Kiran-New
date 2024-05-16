package org.example.slides_303_13;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileWriterExample {

    public static void main (String[] args) {

        try {
            String pathname;
            File output = new File( "output.txt");

            FileWriter filewriter = new FileWriter(output);

            filewriter.write(str:"This is my first sentence writing to a file.")
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
