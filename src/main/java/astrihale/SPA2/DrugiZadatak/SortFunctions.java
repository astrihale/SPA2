package astrihale.SPA2.DrugiZadatak;

import java.util.Comparator;

public class SortFunctions {

    public static <T extends Comparable<T>> T[] bruteForceSort(T[] array) {
        return bruteForceSort(array, T::compareTo);
    }

    public static <T> T[] bruteForceSort(T[] array, Comparator<T> comparer) {
        for (int j = 1; j < array.length; j++) {
            for (int i = 0; i < j; i++) {
                if (comparer.compare(array[i], array[j]) > 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
