package org.aston.konopelko.arraylist;

public class QuickSort {

    public static <E extends Comparable<E>> void sort(CustomArrayList<E> list) {
        int from = 0;
        int to = list.length() -1;
        quickSort(list, from, to);
    }

    private static <E extends Comparable<E>> void quickSort(CustomArrayList<E> list, int from, int to) {
        if (from < to) {
            int divideIndex = partition(list, from, to);
            quickSort(list, from, divideIndex - 1);
            quickSort(list, divideIndex, to);
        }
    }

    private static <E extends Comparable<E>> int partition(CustomArrayList<E> list, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        E pivot = list.get(from + (to - from) / 2);
        while (leftIndex <= rightIndex) {

            while (list.get(leftIndex).compareTo(pivot) < 0) {
                leftIndex++;
            }

            while (list.get(rightIndex).compareTo(pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(list, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static <E> void swap(CustomArrayList<E> list, int index1, int index2) {
        E tmp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, tmp);
    }


}