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
 * Realiza os testes de performance do método InsertionSort,
 * e ao final, gravando os resultados obtidos em um log.
 * @author luanz
 */
public class InsertionSortPTest {
    public static void main(String[] args) {
        // Leitura e separação do conteúdo a ser utilizado em um ArrayList.
        try {
            ArrayList<String[]> content = ReadFile.getFileContent("Dados.csv", ";");
            float[] array = new float[content.size()-1];
            int k;
            long avgTime = 0;
            StringBuilder string = new StringBuilder();
            
            string.append("Dados externos (Dados.csv)\n");

            // Realiza a separação da coluna de dados a ser utilizada nos testes.
            for (int i = 4; i < 10; i++) {
                k = 0;
                for (int j = 1; j < content.size(); j++) {
                    String[] strings = content.get(j);
                    array[k++] = Float.valueOf(strings[i]);
                }
                
                long totalTime = TimedSorts.timedInsertionSort(array);
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
            
            // Testes com números inteiros aleatórios, com
            // quantidades de 10000, 100000 e 1000000 de elementos.
            for (int i = 0; i < 3; i++) {
                int[] intArray = GenerateArray.generateIntArray(arrayLength);
                long totalTime = TimedSorts.timedInsertionSort(intArray);
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
            
            // Testes com números decimais aleatórios, com
            // quantidades de 10000, 100000 e 1000000 de elementos.
            for (int i = 0; i < 3; i++) {
                float[] floatArray = GenerateArray.generateFloatArray(arrayLength);
                long totalTime = TimedSorts.timedInsertionSort(floatArray);
                avgTime += totalTime;
                
                string.append("\nTeste n°" + (i+1));
                string.append("\nNúmero de elementos: " + arrayLength);
                string.append("\nTempo: " + totalTime + "ms.\n");
                
                arrayLength *= 10;
            }
            avgTime /= 3;
            string.append("\nTempo médio: " + avgTime + "ms.\n");
            
            // Geração do log com os resultados obtidos.
            LogGenerator.newLog("InsertionSort", String.valueOf(string));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arquivo não encontrado!");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Codificação não suportada.");
        } catch (IOException ex) {
            throw new RuntimeException("Erro! Verifique os dados informados.");
        }
    }
}
