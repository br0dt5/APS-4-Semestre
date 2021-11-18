package com.unip.util.sorting;

/**
 *
 * @author luanz
 */
public class TimedSorts {
    static long startTime, endTime, totalTime;
    
    public static long timedInsertionSort(int[] array) {
        startTime = System.currentTimeMillis();

        InsertionSort.sort(array);

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;

        return totalTime;
    }
    
    public static long timedInsertionSort(float[] array) {
        startTime = System.currentTimeMillis();

        InsertionSort.sort(array);

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;

        return totalTime;
    }
    
    public static long timedMergeSort(int[] array) {
        int[] aux = new int[array.length];
        
        startTime = System.currentTimeMillis();

        MergeSort.sort(array, aux, 0, array.length-1);

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        
        return totalTime;
    }
    
    public static long timedMergeSort(float[] array) {
        float[] aux = new float[array.length];
        
        startTime = System.currentTimeMillis();

        MergeSort.sort(array, aux, 0, array.length-1);

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        
        return totalTime;
    }
    
    public static long timedQuickSort(int[] array) {
        startTime = System.currentTimeMillis();

        QuickSort.sort(array, 0, array.length-1);

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        
        return totalTime;
    }
    
    public static long timedQuickSort(float[] array) {
        startTime = System.currentTimeMillis();

        QuickSort.sort(array, 0, array.length-1);

        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        
        return totalTime;
    }
}
