package sorts;

import java.util.Arrays;

public class ShellSort extends SortBase {
    @Override
    public void sort() {
        int[] sortedArray = Arrays.copyOf(this.arr, this.arr.length);
        int margin = sortedArray.length;
        while (margin > 1) {
            margin = (int) Math.ceil((float) (margin) / 2);
            for (int i = 0; i < margin; i++) {
                for (int j = i; j < sortedArray.length; j += margin) {
                    int k = j;
                    while (k - margin >= 0) {
                        if (sortedArray[k] < sortedArray[k - margin]) {
                            int temp = sortedArray[k];
                            sortedArray[k] = sortedArray[k - margin];
                            sortedArray[k - margin] = temp;
                        }
                        k -= margin;
                    }
                }
            }
        }
        this.print(sortedArray);
    }
}
