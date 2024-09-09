import java.util.Random;

public class Main {
    /**
     * Sort an array by finding the largest element and swapping it with the last unsorted element of the array.
     * Modifies the array in place
     */
    public static void SelectionSort(Comparable[] array) {
        int high = array.length - 1;

        while (high > 0) {
            // find the largest element
            int indexlargest = 0;
            for (int i = 1; i <= high; i++) {
                int cmp = array[indexlargest].compareTo(array[i]);
                if (cmp < 0) indexlargest = i;
            }
            //swap the last
            Comparable temp = array[indexlargest];
            array[indexlargest] = array[high];
            array[high] = temp;
            high--;
        }
    }

    public static void InsertionSort() {}

    public static void MergeSort() {}

    public static void QuickSort() {}

    public static void main(String[] args) {
        Random rand = new Random();
        Integer[] smallArray = {8, 1, 4, 65, 74, 13};
        String[] stringArray = {"chen", "wang", "wang", "banana", "wang", "wang", "wang", "orange", "orange"};
        Integer[] emptyArray = {};
        Integer[] bigArray = rand.ints(1000,0, 1000).boxed().toArray(Integer[]::new);


        SelectionSort(smallArray);

    }
}