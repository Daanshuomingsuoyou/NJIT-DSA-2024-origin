package oy.tol.tra;

public class Algorithms {
    // 冒泡排序
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
    // 插入排序
    public static <T extends Comparable<T>> int binarySearch(T aValue, T [] fromArray, int fromIndex, int toIndex)  {
        while (fromIndex <= toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            int cmp = fromArray[mid].compareTo(aValue);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                fromIndex = mid + 1;
            } else {
                toIndex = mid - 1;
            }
        }
        return -1;
    }

    // 快速排序
    public static <E extends Comparable<E>> void fastSort(E [] array, int start, int end) {
        quickSort(array, start, end);
    }

    private static <E extends Comparable<E>> void quickSort(E [] array, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(array, start, end);
            quickSort(array, start, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    private static <E extends Comparable<E>> int partition(E [] array, int begin, int end) {
        E pivot = array[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                E temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        E temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;
        return i + 1;
    }
}