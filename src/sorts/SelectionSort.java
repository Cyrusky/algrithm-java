package sorts;

import java.util.Arrays;

public class SelectionSort extends SortBase {
    @Override
    public void sort() {
        double[] sortedArray = Arrays.copyOf(this.arr, this.arr.length);

        for (int i = 0; i < sortedArray.length; i++) {
            double min = sortedArray[i];
            int minIndex = i;
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[j] < min) {
                    min = sortedArray[j];
                    minIndex = j;
                }
            }
            double temp = sortedArray[i];
            sortedArray[i] = sortedArray[minIndex];
            sortedArray[minIndex] = temp;
        }
        this.print(sortedArray);
    }
}
