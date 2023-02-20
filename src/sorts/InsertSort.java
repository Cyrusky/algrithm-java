package sorts;

import java.util.Arrays;

public class InsertSort extends SortBase {
    /**
     * @see this.sort https://www.cnblogs.com/onepixel/p/7674659.html#:~:text=%E6%96%B9%E6%B3%95%E4%BA%86%E5%90%A7%E3%80%82-,3,-%E3%80%81%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F%EF%BC%88Insertion
     */
    @Override
    public void sort() {
        int[] sortedArray = Arrays.copyOf(this.arr, this.arr.length);

        for (int i = 0; i < sortedArray.length - 1; i++) {
            int j = i + 1;
            while (j > 0 && j < sortedArray.length) {
                if (sortedArray[j] < sortedArray[j - 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j - 1];
                    sortedArray[j - 1] = temp;
                }
                j--;
            }
        }
        this.print(sortedArray);
    }

}
