package sorts;

import java.util.Arrays;

public class CountingSort extends SortBase {
    @Override
    public void sort() {
        int[] sortedArray = Arrays.copyOf(this.arr, this.arr.length);
        int min = sortedArray[0];
        int max = sortedArray[0];
        for (int i = 1; i < sortedArray.length; i++) {
            min = Math.min(min, sortedArray[i]);
            max = Math.max(max, sortedArray[i]);
        }
        int[] counter = new int[max - min + 1];
        Arrays.fill(counter, 0);

        for (int k : sortedArray) {
            counter[k - min]++;
        }
        int arrayIndex = 0;
        for (int i = 0; i < counter.length; i++) {
            for (int j = counter[i]; j > 0; j--) {
                sortedArray[arrayIndex++] = i + min;
            }
        }

        this.print(sortedArray);
    }
}
