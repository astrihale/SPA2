package astrihale.SPA2.DrugiZadatak;

import java.util.Comparator;

public class SortFunctions {

    public static class BruteForceSort {
        public static <T extends Comparable<T>> T[] sort(T[] array) {
            return sort(array, T::compareTo);
        }

        public static <T> T[] sort(T[] array, Comparator<T> comparer) {
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

    public static class BogoSort {
        public static <T extends Comparable<T>> T[] sort(T[] array) {
            return sort(array, T::compareTo);
        }

        private static <T> boolean sorted(T[] array, Comparator<T> comparator) {
            for (int i = 0; i < array.length - 1; i++) {
                if (comparator.compare(array[i], array[i + 1]) > 0) {
                    return false;
                }
            }
            return true;
        }

        private static <T> void shuffle(T[] array) {
            for (int i = array.length - 1; i > 0; i--) {
                int rndIndex = (int) (Math.random() * i);
                T temp = array[rndIndex];
                array[rndIndex] = array[i];
                array[i] = temp;
            }
        }

        public static <T> T[] sort(T[] array, Comparator<T> comparator) {
            while (!sorted(array, comparator)) {
                shuffle(array);
            }
            return array;
        }
    }

    public static class InsertionSort {
        public static <T extends Comparable<T>> T[] sort(T[] array) {
            return sort(array, T::compareTo);
        }

        public static <T> T[] sort(T[] array, Comparator<T> comparator) {
            for (int i = 1; i < array.length; i++) {
                T temporary = array[i];
                int j = i - 1;
                while (j >= 0 && comparator.compare(array[j], temporary) > 0) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temporary;
            }
            return array;
        }
    }

    public static class SelectionSort {
        public static <T extends Comparable<T>> T[] sort(T[] array) {
            return sort(array, T::compareTo);
        }

        public static <T> T[] sort(T[] array, Comparator<T> comparator) {
            for (int i = 0; i < array.length - 1; i++) {
                int min = i;

                for (int j = i + 1; j < array.length; j++) {
                    if (comparator.compare(array[min], array[j]) > 0) {
                        min = j;
                    }
                }

                if (min != i) {
                    T temp = array[min];
                    array[min] = array[i];
                    array[i] = temp;
                }
            }
            return array;
        }
    }

    public static class ExchangeSort {
        public static <T extends Comparable<T>> T[] sort(T[] array) {
            return sort(array, T::compareTo);
        }

        public static <T> T[] sort(T[] array, Comparator<T> comparator) {
            for (int i = array.length - 1; i >= 1; i--) {
                boolean exchangeOccurred = false;

                for (int j = 0; j < i; j++) {
                    if (comparator.compare(array[j], array[j + 1]) > 0) {
                        T tmp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = tmp;
                        exchangeOccurred = true;
                    }
                }

                if (!exchangeOccurred) {
                    break;
                }
            }
            return array;
        }
    }

    public static class BubbleSort {
        public static <T extends Comparable<T>> T[] sort(T[] array) {
            return sort(array, T::compareTo);
        }

        public static <T> T[] sort(T[] array, Comparator<T> comparator) {
            for (int i = 0; i <= array.length - 1; i++) {
                boolean exchangeOccurred = false;

                for (int j = array.length - 1; j > i; j--) {
                    if (comparator.compare(array[j], array[j - 1]) < 0) {
                        T tmp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = tmp;
                        exchangeOccurred = true;
                    }
                }

                if (!exchangeOccurred) {
                    break;
                }
            }
            return array;
        }
    }
}
