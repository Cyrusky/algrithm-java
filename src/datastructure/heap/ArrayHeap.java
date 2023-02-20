package datastructure.heap;

public class ArrayHeap {

    private final boolean isMinHeap;
    private final int heapLength;
    public int[] arr = {};
    private boolean firstBuild;

    public ArrayHeap(int heapLength, boolean isMinHeap) {
        this.isMinHeap = isMinHeap;
        this.heapLength = heapLength;
        this.initializeRawData();
        this.firstBuild = true;
        this.heapify();
        this.firstBuild = false;
    }

    public ArrayHeap(int[] arr, boolean isMinHeap) {
        this.isMinHeap = isMinHeap;
        this.heapLength = arr.length;
        this.arr = arr;
        this.firstBuild = true;
        this.heapify();
        this.firstBuild = false;
    }

    public void heapify() {
        for (int i = 0; i < this.arr.length; i++) {
            this.heapify(i);
        }
    }

    public void reHeapify(int tail) {
        for (int i = 0; i <= tail; i++) {
            this.heapify(i);
        }
    }

    private void heapify(int tail) {
        int point = tail;
        while (point > 0) {
            int rootIndex = (int) Math.floor(((float) point - 1) / 2);
            if (this.isMinHeap && this.arr[point] < this.arr[rootIndex]) {
                this.swap(point, rootIndex);
            } else if (!isMinHeap && this.arr[point] > this.arr[rootIndex]) {
                this.swap(point, rootIndex);
            } else {
                if (this.firstBuild) {
                    break;
                }
            }
            point = rootIndex;
        }
    }

    public void swap(int i1, int i2) {
        int temp = this.arr[i1];
        this.arr[i1] = this.arr[i2];
        this.arr[i2] = temp;
    }


    private void initializeRawData() {
        this.arr = new int[this.heapLength];
        for (int i = 0; i < this.heapLength; i++) {
            this.arr[i] = (int) Math.ceil(Math.random() * 100000) / 100;
        }
    }


    public void verify() {
        boolean result = true;
        boolean[] resultArr = new boolean[this.arr.length];
        for (int i = 0; i < this.arr.length; i++) {
            if (!this.verifySingleNode(i)) {
                result = false;
            }
            resultArr[i] = result;
        }
        for (boolean r : resultArr) {
            System.out.print("\t" + r);
        }
        System.out.println();
        System.out.println("=".repeat(110));
    }

    public boolean verifySingleNode(int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        boolean leftNodeValid;
        boolean rightNodeValid;
        if (this.isMinHeap) {
            leftNodeValid = leftIndex >= this.arr.length || this.arr[index] <= this.arr[leftIndex];
            rightNodeValid = rightIndex >= this.arr.length || this.arr[index] <= this.arr[rightIndex];
        } else {
            leftNodeValid = leftIndex >= this.arr.length || this.arr[index] >= this.arr[leftIndex];
            rightNodeValid = rightIndex >= this.arr.length || this.arr[index] >= this.arr[rightIndex];
        }
        return leftNodeValid && rightNodeValid;
    }

}
