package sorts;

import java.util.Arrays;

public class BubbleSort extends SortBase {
    /**
     * @see this.sort https://www.cnblogs.com/onepixel/p/7674659.html#:~:text=n%E7%9A%84%E5%87%BD%E6%95%B0%E3%80%82-,1%E3%80%81%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F%EF%BC%88Bubble%20Sort%EF%BC%89,-%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F%E6%98%AF
     */
    @Override
    public void sort() {
        int[] sortedArray = Arrays.copyOf(this.arr, this.arr.length);

        for (int i = sortedArray.length - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (sortedArray[j] < sortedArray[j - 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j - 1];
                    sortedArray[j - 1] = temp;
                }
            }
        }

        this.print(sortedArray);
    }
}
