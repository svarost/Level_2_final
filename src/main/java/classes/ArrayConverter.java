package classes;

import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

public class ArrayConverter {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] strings = new String[][] {new String[]{"10", "51", "6", "88"},
                                            new String[] {"22", "32", "67", "11"},
                                            new String[]{"54", "1", "11", "56"},
                                            new String[]{"14", "50", "900", "43"}};

        arrayConverter(strings);
    }

    public static void arrayConverter(String[][] a) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        int c = 0;

        if (a.length != 4) {
            throw new MyArraySizeException("ОШИБКА. Размерность массива отлична от 4 х 4.");
        }
        for (String[] s: a) {
            if (s.length != 4) {
                throw new MyArraySizeException("ОШИБКА. Размерность массива отлична от 4 х 4.");
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                try {
                    c = Integer.parseInt(a[i][j]);
                    sum += c;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("ОШБКА. В ячейке [" + i + "][" + j + "] лежит " + a[i][j] + " вместо числа.");
                }
            }
        }
        System.out.println("Сумма элементов массива равна: " + sum);
    }
}
