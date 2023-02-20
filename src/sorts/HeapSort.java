package sorts;

import datastructure.heap.ArrayHeap;

import java.util.Arrays;


public class HeapSort extends SortBase {
    @Override
    public void sort() {
        int[] sortedArray = Arrays.copyOf(this.arr, this.arr.length);
        ArrayHeap arrayHeap = new ArrayHeap(sortedArray, false);
        for (int i = sortedArray.length - 1; i > 0; i--) {
            arrayHeap.swap(0, i);
            arrayHeap.reHeapify(i - 1);
        }
        this.print(sortedArray);
    }
}
