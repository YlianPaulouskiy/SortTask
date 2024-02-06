package by.acd.service;

import java.io.*;

public class DataService {

    public static String[][] read(String fileName) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = buffer.readLine()) != null) {
                text.append(line).append("\n");
            }
            return fromStringToTable(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(String fileName, String[][] table) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName))) {
            File file = new File(fileName);
            if (!file.exists()) file.createNewFile();

            buffer.write(fromTableToString(table));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String fromTableToString(CharSequence[][] table) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                text.append(table[i][j]);
                if (j != table[i].length - 1) text.append("\t");
            }
            text.append("\n");
        }
        return text.toString();
    }

    private static String[][] fromStringToTable(CharSequence text) {
        var lines = text.toString().split("\n");
        String[][] table = new String[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            table[i] = lines[i].split("\t");
        }
        return table;
    }
}
