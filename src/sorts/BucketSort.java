package sorts;


import datastructure.List.LinkedList;

import java.util.Arrays;

public class BucketSort extends SortBase {

    public static int BUCKET_SIZE = 3;

    @Override
    public void sort() {
        int[] sortedArray = Arrays.copyOf(this.arr, this.arr.length);
        LinkedList[] buckets = new LinkedList[BucketSort.BUCKET_SIZE];
        for (int j : sortedArray) {
            int base = j % BucketSort.BUCKET_SIZE;
            if (buckets[base] == null) {
                buckets[base] = new LinkedList();
            }
            buckets[base].add(j);
        }
        // Bubble sort each Linked List;
        for (LinkedList list : buckets) {
            LinkedList.Node startNode = list.list.next;
            while (startNode.next != null) {
                LinkedList.Node compareNode = startNode.next;
                while (compareNode != null) {
                    if (startNode.value > compareNode.value) {
                        int temp = startNode.value;
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
            Integer min = null;
            LinkedList.Node minNode = null;
            for (LinkedList linkedList : buckets) {
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
