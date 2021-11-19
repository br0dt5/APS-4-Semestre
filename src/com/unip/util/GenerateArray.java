package com.unip.util;

import java.util.Random;

/**
 * Criador de vetores de números pseudoaleatórios,
 * de tamanho n informado por parâmetro, e retorna o array gerado.
 * @author luanz
 */
public class GenerateArray {

    public static int[] generateIntArray(int n) {
        int []v = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            v[i] = random.nextInt(n);
        }

        return v;
    }
    
    public static float[] generateFloatArray(int n) {
        float []v = new float[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            v[i] = random.nextFloat() * n;
        }

        return v;
    }

}
