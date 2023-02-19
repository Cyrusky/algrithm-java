package sorts;


import ComplexDataStructure.List.LinkedList;

import java.util.Arrays;

public class BucketSort extends SortBase {

    public static int BUCKET_SIZE = 3;

    @Override
    public void sort() {
        double[] sortedArray = Arrays.copyOf(this.arr, this.arr.length);
        @SuppressWarnings("unchecked")
        LinkedList<Double>[] buckets = new LinkedList[BucketSort.BUCKET_SIZE];
        for (double j : sortedArray) {
            int base = (int) j % BucketSort.BUCKET_SIZE;
            if (buckets[base] == null) {
                buckets[base] = new LinkedList<>();
            }
            buckets[base].add(j);
        }
        // Bubble sort each Linked List;
        for (LinkedList<Double> list : buckets) {
            LinkedList<Double>.Node startNode = list.list.next;
            while (startNode.next != null) {
                LinkedList<Double>.Node compareNode = startNode.next;
                while (compareNode != null) {
                    if (startNode.value > compareNode.value) {
                        double temp = startNode.value;
                        startNode.value = compareNode.value;
                        compareNode.value = temp;
                    }
                    compareNode = compareNode.next;
                }
                startNode = startNode.next;
            }
        }
        int arrayIndex = 0;
        while (arrayIndex < sortedArray.length) {
            Double min = null;
            LinkedList<Double>.Node minNode = null;
            for (LinkedList<Double> linkedList : buckets) {
                if (linkedList.list.next == null) {
                    continue;
                }
                if (min == null || min > linkedList.list.next.value) {
                    min = linkedList.list.next.value;
                    minNode = linkedList.list;
                }
            }
            if (min == null) break;
            sortedArray[arrayIndex++] = min;
            minNode.next = minNode.next.next;
        }
        this.print(sortedArray);
    }
}
