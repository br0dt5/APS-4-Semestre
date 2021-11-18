package com.unip.util.sorting;

public class MergeSort {

    public static void sort(int[] array, int[] aux, int begin, int end) {
        if (begin < end) {
            int meio = (begin + end) / 2;
            sort(array, aux, begin, meio);
            sort(array, aux, meio+1, end);
            insert(array, aux, begin, meio, end);
        }
    }
    
    public static void sort(float[] array, float[] aux, int begin, int end) {
        if (begin < end) {
            int meio = (begin + end) / 2;
            sort(array, aux, begin, meio);
            sort(array, aux, meio+1, end);
            insert(array, aux, begin, meio, end);
        }
    }

    private static void insert(
            int[] array, int[] aux, int begin, int middle, int end
    ) {
        for (int i = begin; i <= end; i++)
            aux[i] = array[i];

        int i = begin;
        int j = middle + 1;

        for (int k = begin; k <= end; k++) {
            if (i > middle) array[k] = aux[j++];
            else if (j > end) array[k] = aux[i++];
            else if (aux[i] < aux[j]) array[k] = aux[i++];
            else array[k] = aux[j++];
        }
    }
    
    private static void insert(
            float[] array, float[] aux,int begin, int middle, int end
    ) {
        for (int i = begin; i <= end; i++)
            aux[i] = array[i];

        int i = begin;
        int j = middle + 1;

        for (int k = begin; k <= end; k++) {
            if (i > middle) array[k] = aux[j++];
            else if (j > end) array[k] = aux[i++];
            else if (aux[i] < aux[j]) array[k] = aux[i++];
            else array[k] = aux[j++];
        }
    }

}
