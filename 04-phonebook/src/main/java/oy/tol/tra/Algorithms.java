package oy.tol.tra;

import java.util.Comparator;

public class Algorithms {
    public static <SS extends Comparable<SS>> void fastSort(SS[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        fastSort(array, 0, array.length - 1);
    }

    private static <SS extends Comparable<SS>> void fastSort(SS[] array, int Jin, int Chu) {
        if (Jin < Chu) {
            int pivotIndex = partition(array, Jin, Chu);
            fastSort(array, Jin, pivotIndex - 1);
            fastSort(array, pivotIndex + 1, Chu);
        }
    }

    private static <SS extends Comparable<SS>> int partition(SS[] array, int Jin, int Chu) {
        SS pivot = array[Chu];
        int i = Jin - 1;
        for (int j = Jin; j < Chu; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, Chu);
        return i + 1;
    }

    private static <SS> void swap(SS[] array, int i, int j) {
        SS temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static <SS> int partitionByRule(SS[] array, int length, PartitionRule<SS> rule) {
        int Jin = 0;
        int Chu = length - 1;
        while (Jin <= Chu) {

            while (Jin <= Chu && rule.test(array[Jin])) {
                Jin++;
            }

            while (Jin <= Chu && !rule.test(array[Chu])) {
                Chu--;
            }

            if (Jin <= Chu) {
                swap(array, Jin, Chu);
                Jin++;
                Chu--;
            }
        }

        return Jin;
    }


    public static <SS> void sortWithComparator(SS[] array, Comparator<SS> comparator) {
        fastSortWithComparator(array, comparator, 0, array.length - 1);
    }

    private static <SS> void fastSortWithComparator(SS[] array, Comparator<SS> comparator, int Jin, int Chu) {
        if (Jin < Chu) {
            int pivotIndex = partitionWithComparator(array, comparator, Jin, Chu);
            fastSortWithComparator(array, comparator, Jin, pivotIndex - 1);
            fastSortWithComparator(array, comparator, pivotIndex + 1, Chu);
        }
    }

    private static <SS> int partitionWithComparator(SS[] array, Comparator<SS> comparator, int Jin, int Chu) {
        SS pivot = array[Chu];
        int i = Jin - 1;
        for (int j = Jin; j < Chu; j++) {
            if (comparator.compare(array[j], pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, Chu);
        return i + 1;
    }

    public interface PartitionRule<SS> {
        boolean test(SS element);
    }
}
