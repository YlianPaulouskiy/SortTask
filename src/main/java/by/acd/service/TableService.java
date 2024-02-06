package by.acd.service;

public class TableService {

    public static void sort(String[][] table) {
        for (int i = 0; i < table.length; i++) { // this row
            for (int l = i - 1; l < table.length; l++) { // - 1 row
                for (int j = 0; j < table.length - 1; j++) { // this line
                    for (int k = j + 1; k < table.length; k++) { // +1 line
                        try {
                            if (l != -1) { // (previous row don't exist)
                                if (compare(table[j][l], table[k][l]) == 0) { // if have two equals value need to check by next row
                                    if (compare(table[j][i], table[k][i]) > 0) {
                                        swap(table, j, k);
                                    }
                                }
                            } else { // sort first time by first row
                                if (compare(table[j][i], table[k][i]) == 1) {
                                    swap(table, j, k);
                                }
                            }
                        } catch (IndexOutOfBoundsException ignored) {
                        }
                    }
                }
            }
        }
    }

    private static void swap(String[][] table, int j, int k) {
        String[] temp = table[j];
        table[j] = table[k];
        table[k] = temp;
    }

    private static int compare(String value, String nextValue) {
        if (isNumber(value) && isNumber(nextValue)) {
            return Double.compare(Double.parseDouble(value), Double.parseDouble(nextValue));
        } else if (isNumber(value)) {
            return 1;
        } else if (isNumber(nextValue)) {
            return -1;
        } else {
            return value.compareTo(nextValue);
        }
    }

    private static boolean isNumber(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
