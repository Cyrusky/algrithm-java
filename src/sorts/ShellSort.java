package sorts;

import java.util.Arrays;

public class ShellSort extends SortBase {
    @Override
    public void sort() {
        double[] sortedArray = Arrays.copyOf(this.arr, this.arr.length);

        this.print(sortedArray);
    }
}
