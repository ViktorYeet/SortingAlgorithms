import java.util.Arrays;
import java.util.Random;

public class Main {
    /**
     * Sort an array by finding the largest element and swapping it with the last unsorted element of the array.
     * Modifies the array in place
     * @param array comparable array
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
     * @param array comparable array
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
     * @param array comparable array
     */
    public static <T extends Comparable<T>> void MergeSort(T[] array) {
        System.arraycopy(MergeSortHelper(array, 0, array.length - 1), 0, array, 0, array.length); // wanted to make it modify and not return
    }

    /**
     * Recursive implementation of merge sort
     * @param array comparable array
     * @param low lowerbound to be included in this segment
     * @param high upperbound to be included in this segment
     * @return
     * @param <T> Comparable
     */
    private static <T extends Comparable<T>> T[] MergeSortHelper(T[] array, int low, int high) {
        //fracture the array
        int mid = (low + high) / 2;
        T[] array1;
        T[] array2;
        if(low < high) {
            array1 = MergeSortHelper(array, low, mid);
            array2 = MergeSortHelper(array, mid + 1, high);
        }
        //if low >= high then the array is either empty or contains 1 element
        else if(low == high) {
            return (T[])new Comparable[]{array[low]};
        }
        else return (T[])new Comparable[0];

        // Merge the two segments and return the resulting array
        T[] answer = (T[]) new Comparable[high - low + 1];
        int answerPointer = 0;
        int i = 0, j = 0;
        while (i < array1.length && j < array2.length) { // compare and insert the lower element into answer array
            int cmp = array1[i].compareTo(array2[j]);
            if (cmp <= 0) answer[answerPointer++] = array1[i++];
            else answer[answerPointer++] = array2[j++];
        }
        // one of the two segments are empty so we can safely add the remaining elements
        while (j >= array2.length && i < array1.length) answer[answerPointer++] = array1[i++];
        while (j < array2.length) answer[answerPointer++] = array2[j++];
        return answer;
    }

    public static void QuickSort() {}

    public static void main(String[] args) {
        Random rand = new Random();
        Integer[] smallArray = {8, 1, 4, 65, 74, 13};
        String[] stringArray = {"chen", "wang", "wang", "banana", "wang", "wang", "wang", "orange", "orange"};
        Integer[] emptyArray = {};
        Integer[] bigArray = rand.ints(1000,0, 1000).boxed().toArray(Integer[]::new);


        MergeSort(bigArray);
//        MergeSort(bigArray);
        System.out.println(Arrays.toString(bigArray));
    }
}