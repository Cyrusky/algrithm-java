package sorts;

import java.util.Arrays;

public class MergeSort extends SortBase {
    @Override
    public void sort() {
        int[] sortedArray = Arrays.copyOf(this.arr, this.arr.length);
        sortedArray = this.sortRecursively(sortedArray, (int) Math.pow(2, Math.ceil(Math.log((float) sortedArray.length))));
        this.print(sortedArray);
    }

    /**
     * 这个地方第一次尝试了从更长的子长度向上递归，结果发现，并不能作为
     */
    private int[] sortRecursively(int[] sortedArray, int subArrayLength) {
        if (subArrayLength == 1) {
            int[] recursiveArray = Arrays.copyOf(sortedArray, sortedArray.length);
            for (int i = 1; i < sortedArray.length; i += 2) {
                if (sortedArray[i] < sortedArray[i - 1]) {
                    int temp = recursiveArray[i];
                    recursiveArray[i] = recursiveArray[i - 1];
                    recursiveArray[i - 1] = temp;
                }
            }
            return recursiveArray;
        }
        int[] recursiveArray = new int[sortedArray.length];
        int[] newArray = this.sortRecursively(sortedArray, (int) Math.pow(2, Math.ceil(Math.log((float) subArrayLength)) - 1));
        int startPoint = 0;
        while (startPoint < newArray.length) {
            merge(subArrayLength, recursiveArray, newArray, startPoint);
            startPoint += 2 * subArrayLength;
        }
        return recursiveArray;
    }

    private void merge(int subArrayLength, int[] recursiveArray, int[] sortedArray, int startPoint) {
        int firstPoint = startPoint;
        int secondPoint = startPoint + subArrayLength;
        int recursivePoint = startPoint;
        while (firstPoint < startPoint + subArrayLength
                && secondPoint < startPoint + 2 * subArrayLength
                && secondPoint < sortedArray.length) {
            if (sortedArray[firstPoint] < sortedArray[secondPoint]) {
                recursiveArray[recursivePoint] = sortedArray[firstPoint];
                firstPoint++;
            } else {
                recursiveArray[recursivePoint] = sortedArray[secondPoint];
                secondPoint++;
            }
            recursivePoint++;
        }
        if (firstPoint == startPoint + subArrayLength) {
            int tail = Math.min(sortedArray.length, startPoint + 2 * subArrayLength);
            for (int i = secondPoint; i < tail; i++) {
                recursiveArray[recursivePoint] = sortedArray[i];
                recursivePoint++;
            }
        } else if (secondPoint >= sortedArray.length || secondPoint == startPoint + 2 * subArrayLength) {
            int tail = Math.min(startPoint + subArrayLength, sortedArray.length);
            for (int i = firstPoint; i < tail; i++) {
                recursiveArray[recursivePoint] = sortedArray[i];
                recursivePoint++;
            }
        }
    }
}
