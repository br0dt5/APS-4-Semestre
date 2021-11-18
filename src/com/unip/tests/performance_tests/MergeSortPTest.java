package com.unip.tests.performance_tests;

import com.unip.util.GenerateArray;
import com.unip.util.LogGenerator;
import com.unip.util.ReadFile;
import com.unip.util.sorting.TimedSorts;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 *
 * @author luanz
 */
public class MergeSortPTest {
    public static void main(String[] args) {
        try {
            ArrayList<String[]> content = ReadFile.getFileContent("Dados.csv", ";");
            float[] array = new float[content.size()-1];
            int k;
            long avgTime = 0;
            StringBuilder string = new StringBuilder();
            
            string.append("Dados externos (Dados.csv)\n");

            for (int i = 4; i < 10; i++) {
                k = 0;
                for (int j = 1; j < content.size(); j++) {
                    String[] strings = content.get(j);
                    array[k++] = Float.valueOf(strings[i]);
                }
                
                long totalTime = TimedSorts.timedMergeSort(array);
                avgTime += totalTime;
                string.append("\nTeste n°" + (i-3));
                string.append("\nNúmero de elementos: " + (content.size()-1));
                string.append("\nTempo: " + totalTime + "ms.\n");
            }
            avgTime /= 6;
            string.append("\nTempo médio: " + avgTime + "ms.\n");
            
            string.append("\nDados aleatórios\n\nInteiros:");
            
            int arrayLength = 10000;
            avgTime = 0;
            
            for (int i = 0; i < 3; i++) {
                int[] intArray = GenerateArray.generateIntArray(arrayLength);
                long totalTime = TimedSorts.timedMergeSort(intArray);
                avgTime += totalTime;
                
                string.append("\nTeste n°" + (i+1));
                string.append("\nNúmero de elementos: " + arrayLength);
                string.append("\nTempo: " + totalTime + "ms.\n");
                
                arrayLength *= 10;
            }
            avgTime /= 3;
            string.append("\nTempo médio: " + avgTime + "ms.\n");
            
            string.append("\nDecimais:");
            
            arrayLength = 10000;
            avgTime = 0;
            
            for (int i = 0; i < 3; i++) {
                float[] floatArray = GenerateArray.generateFloatArray(arrayLength);
                long totalTime = TimedSorts.timedMergeSort(floatArray);
                avgTime += totalTime;
                
                string.append("\nTeste n°" + (i+1));
                string.append("\nNúmero de elementos: " + arrayLength);
                string.append("\nTempo: " + totalTime + "ms.\n");
                
                arrayLength *= 10;
            }
            avgTime /= 3;
            string.append("\nTempo médio: " + avgTime + "ms.\n");
            
            LogGenerator.newLog("MergeSort", String.valueOf(string));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arquivo não encontrado!");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Codificação não suportada.");
        } catch (IOException ex) {
            throw new RuntimeException("Erro! Verifique os dados informados.");
        }
    }
}
