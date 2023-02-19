package sorts;

import java.util.Arrays;

public class QuickSort extends SortBase {

    @Override
    public void sort() {
        double[] sortedArray = Arrays.copyOf(this.arr, this.arr.length);
        this.recursivelySort(0, sortedArray.length - 1, sortedArray);
        this.print(sortedArray);
    }

    private void recursivelySort(int start, int end, double[] sortedArray) {
        if (start >= end) {
            return;
        }
        double pivot = sortedArray[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (low < high && pivot <= sortedArray[high]) high--;
            sortedArray[low] = sortedArray[high];
            while (low < high && sortedArray[low] <= pivot) low++;
            sortedArray[high] = sortedArray[low];
        }
        sortedArray[low] = pivot;
        this.recursivelySort(start, low - 1, sortedArray);
        this.recursivelySort(low + 1, sortedArray.length - 1, sortedArray);
    }
}
