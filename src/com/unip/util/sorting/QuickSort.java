package com.unip.util.sorting;

public class QuickSort {

    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            int j = split(array, left, right);
            sort(array, left, j-1);
            sort(array, j+1, right);
        }
    }
    
    public static void sort(float[] array, int left, int right) {
        if (left < right) {
            int j = split(array, left, right);
            sort(array, left, j-1);
            sort(array, j+1, right);
        }
    }

    private static int split(int[] array, int left, int right) {
        int i = left+1;
        int j = right;
        int pivo = array[left];
        while (i <= j) {
            if (array[i] <= pivo) i++;
            else if (array[j] > pivo) j--;
            else if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        swap(array, left, j);
        return j;
    }
    
    private static int split(float[] array, int left, int right) {
        int i = left+1;
        int j = right;
        float pivo = array[left];
        while (i <= j) {
            if (array[i] <= pivo) i++;
            else if (array[j] > pivo) j--;
            else if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        swap(array, left, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
    
    private static void swap(float[] array, int i, int j) {
        float aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

}
