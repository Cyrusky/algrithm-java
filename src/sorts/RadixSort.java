package sorts;

import config.Constants;
import datastructure.List.LinkedList;

import java.util.Arrays;

public class RadixSort extends SortBase {

    @Override
    public void sort() {
        int[] sortedArray = Arrays.copyOf(this.arr, this.arr.length);

        for (int i = 0; i < Constants.numberLength; i++) {
            int base = (int) Math.pow(Constants.radixSortRadix, i);
            LinkedList[] buckets = new LinkedList[Constants.radixSortRadix];
            for (int j = 0; j < buckets.length; j++) {
                buckets[j] = new LinkedList();
            }

            for (int number : sortedArray) {
                int bucketIndex = (int) (number / base) % Constants.radixSortRadix;
                buckets[bucketIndex].add(number);
            }

            int arrayIndex = 0;
            for (LinkedList bucket : buckets) {
                while (bucket.list.next != null) {
                    sortedArray[arrayIndex++] = bucket.list.next.value;
                    bucket.list.next = bucket.list.next.next;
                }
            }
        }

        this.print(sortedArray);
    }
}
