package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSon {
    public static int[][] merge(int[][] intervals) {
        sort(intervals,0,intervals.length-1);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < intervals.length-1; i++) {
            if(intervals[i][1] > intervals[i+1][0]){
                List<Integer> node = new ArrayList<>();
                node.add(intervals[i][0]);
                node.add(intervals[i+1][1]);
                resultList.add(node);
            }else{
                List<Integer> node = new ArrayList<>();
                node.add(intervals[i][0]);
                node.add(intervals[i][1]);
                resultList.add(node);
            }
        }
        return null;
    }

    public static void main(String[] args) {

        int[][] ints = {{1,3},{2,6},{16,10},{15,18}};
        merge(ints);
    }

    public static void sort(int[][] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private static int partition(int[][] arr, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = arr[high][0];

        // Pointer for greater element
        int i = (low - 1);

        // Traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j][0] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int[] temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
