package oy.tol.tra;

public class Algorithms {
    public static <SS extends Comparable<SS>> void sort(SS[] array) {
// implementation here...

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    SS temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // ...
    public static <SS> void reverse(SS[] array) {
// implementation here...
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            SS temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

    }
}