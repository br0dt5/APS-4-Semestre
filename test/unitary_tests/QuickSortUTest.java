package unitary_tests;

import com.unip.util.GenerateArray;
import com.unip.util.sorting.QuickSort;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author luanz
 */
public class QuickSortUTest {
    @Test
    public void testQuickSortedIntArray() {
        int[] array = GenerateArray.generateIntArray(1000);
        
        QuickSort.sort(array, 0, array.length-1);
        
        for (int i = 0; i < array.length-1; i++) {
            Assert.assertTrue(array[i] <= array[i+1]);
        }
    }
    
    @Test
    public void testQuickSortedFloatArray() {
        float[] array = GenerateArray.generateFloatArray(1000);
        
        QuickSort.sort(array, 0, array.length-1);
        
        for (int i = 0; i < array.length-1; i++) {
            Assert.assertTrue(array[i] <= array[i+1]);
        }
    }
}
