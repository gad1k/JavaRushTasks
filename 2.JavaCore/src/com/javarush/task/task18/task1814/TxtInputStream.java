package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        Pattern regexp = Pattern.compile("\\.txt$");
        Matcher matcher = regexp.matcher(fileName);
        if (!matcher.find()) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }
    public static void main(String[] args) {
    }
}