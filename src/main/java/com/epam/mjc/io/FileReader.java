package com.epam.mjc.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {

        List<String> list = new ArrayList<>();

        try(InputStream in = new FileInputStream(file)) {

            byte[] bytes = new byte[in.available()];
            int counter = 0;
            byte currentByte;
            while ((currentByte = (byte) in.read()) != -1) {
                bytes[counter++] = currentByte;
            }

            String stringValue = new String(bytes);

            String[] lines = stringValue.split("\\r?\\n");



            for (String line : lines) {
                String[] lines2 = line.split(" ");
                String s = lines2[1].trim();
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Profile(
                list.get(0),
                Integer.parseInt(list.get(1)),
                list.get(2),
                Long.parseLong(list.get(3))
        );
    }


    public static void main(String[] args) throws IOException {


    }

}
