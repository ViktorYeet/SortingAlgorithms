import java.util.Arrays;
import java.util.Random;

public class Main {
    /**
     * Sort an array by finding the largest element and swapping it with the last unsorted element of the array.
     * Modifies the array in place
     * @param array
     */
    public static <T extends Comparable<T>> void SelectionSort(T[] array) {
        int high = array.length - 1;

        while (high > 0) {
            // find the largest element
            int indexlargest = 0;
            for (int i = 1; i <= high; i++) {
                int cmp = array[indexlargest].compareTo(array[i]);
                if (cmp < 0) indexlargest = i;
            }
            if(indexlargest == high) {
                high--;
                continue;
            }
            //swap the last
            T temp = array[indexlargest];
            array[indexlargest] = array[high];
            array[high] = temp;
            high--;
        }
    }

    /**
     * Sort an array by looking at the first two elements put them in order then take the next element and slide it into the correct place.
     * Modifies the array in place
     * @param array
     */
    public static <T extends Comparable<T>> void InsertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j].compareTo(array[j-1]) < 0; j--) {
                T temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
            }
        }
    }

    /**
     * Sort an array by divide and conquer, split the list in half recursively until we have single elements in the segments, feed back into the original array in sorted order.
     * Modifies the array in place
     * @param array
     */
    public static <T extends Comparable<T>> void MergeSort(T[] array) {
        MergeSortHelper(array, 0, array.length - 1);
    }

    public static void MergeSort() {}

    public static void QuickSort() {}

    public static void main(String[] args) {
        Random rand = new Random();
        Integer[] smallArray = {8, 1, 4, 65, 74, 13};
        String[] stringArray = {"chen", "wang", "wang", "banana", "wang", "wang", "wang", "orange", "orange"};
        Integer[] emptyArray = {};
        Integer[] bigArray = rand.ints(1000,0, 1000).boxed().toArray(Integer[]::new);


        SelectionSort(smallArray);
        SelectionSort(smallArray);
        System.out.println(Arrays.toString(smallArray));
    }
}