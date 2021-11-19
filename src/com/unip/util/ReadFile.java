package com.unip.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Realiza a leitura de um arquivo e retorna o conteúdo presente nele.
 * @author luanz
 */
public class ReadFile {

    private static BufferedReader reader(String filename) throws IOException{
        return new BufferedReader(new FileReader(filename));
    }

    public static ArrayList<String> getFileContent(String filename) throws IOException {
        BufferedReader br = reader(filename);
        String line;

        ArrayList<String> b = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            b.add(line);
        }

        return b;
    }

    public static ArrayList<String[]> getFileContent(String filename, String separator) throws IOException {
        BufferedReader br = reader(filename);
        String line;

        ArrayList<String[]> b = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            b.add(line.split(separator));
        }
        br.close();

        return b;
    }
}
