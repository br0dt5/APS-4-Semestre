package com.unip.util.sorting;

public class InsertionSort {

    public static void sort(int[] array) {
        int aux, j;
        for(int i=1; i < array.length; i++){
            aux = array[i];
            j = i-1;
            while(j >= 0 && array[j] > aux){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = aux;
        }
    }
    
    public static void sort(float[] array) {
        float aux;
        int j;
        for(int i=1; i < array.length; i++){
            aux = array[i];
            j = i-1;
            while(j >= 0 && array[j] > aux){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = aux;
        }
    }

}
