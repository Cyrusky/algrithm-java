import sorts.SortBase;

public class ArrayHeap {

    double[] arr = {};
    private boolean minHeap = false;
    private int heapLength = 10;

    public ArrayHeap(int heapLength, boolean minHeap) {
        this.minHeap = minHeap;
        this.heapLength = heapLength;
        this.initializeRawData();

        if (this.minHeap) {
            this.buildMinHeap();
        } else {
            this.buildMaxHeap();
        }
    }

    private void initializeRawData() {
        this.arr = new double[this.heapLength];
        for (int i = 0; i < this.heapLength; i++) {
            this.arr[i] = Math.ceil(Math.random() * 100000) / 100;
        }
    }

    public void buildMaxHeap() {
        for (int i = this.arr.length - 1; i >= 0; i--) {
            double root = this.arr[i];
            if (2 * i + 1 < this.arr.length) {
                double left = this.arr[2 * i + 1];
                this.arr[i] = Math.max(left, root);
                this.arr[2 * i + 1] = Math.min(left, root);
            }
            if (2 * i + 2 < this.arr.length) {
                double left = this.arr[2 * i + 2];
                this.arr[i] = Math.max(left, root);
                this.arr[2 * i + 2] = Math.min(left, root);
            }
        }
    }

    public void buildMinHeap() {
        for (int i = this.arr.length - 1; i >= 0; i--) {
            double root = this.arr[i];
            if (2 * i + 1 < this.arr.length) {
                double left = this.arr[2 * i + 1];
                this.arr[i] = Math.min(left, root);
                this.arr[2 * i + 1] = Math.max(left, root);
            }
            if (2 * i + 2 < this.arr.length) {
                double left = this.arr[2 * i + 2];
                this.arr[i] = Math.min(left, root);
                this.arr[2 * i + 2] = Math.max(left, root);
            }
        }
    }

    public boolean verify() {
        return this.minHeap ? this.veryMinHeap() : this.verifyMaxHeap();
    }

    private boolean veryMinHeap() {
        for (int i = 0; i < this.arr.length; i++) {
            if (2 * i + 1 < this.arr.length) {
                double left = this.arr[2 * i + 1];
                if (this.arr[i] > left) {
                    return false;
                }
            }
            if (2 * i + 2 < this.arr.length) {
                double right = this.arr[2 * i + 2];
                if (this.arr[i] > right) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean verifyMaxHeap() {
        for (int i = 0; i < this.arr.length; i++) {
            if (2 * i + 1 < this.arr.length) {
                double left = this.arr[2 * i + 1];
                if (this.arr[i] < left) {
                    return false;
                }
            }
            if (2 * i + 2 < this.arr.length) {
                double right = this.arr[2 * i + 2];
                if (this.arr[i] < right) {
                    return false;
                }
            }
        }
        return true;
    }

    protected void print(double[] arr) {
        System.out.println("=".repeat(110));
        System.out.print(SortBase.center(String.format("Sort Result (%s)", this.getClass().getSimpleName()), 110));
        System.out.println("\n" + "-".repeat(110));
        System.out.println("Original number array:");
        for (double v : this.arr) {
            System.out.printf("\t%3.3f", v);
        }
        System.out.println();
        System.out.print("\t");
        for (int i = 0; i < this.arr.length; i++) {
            if (i == 0) {
                System.out.print("\33[33;1m---\33[0m\t\t");
            } else if (this.arr[i] >= this.arr[i - 1]) {
                System.out.print("\33[32;1m√\33[0m\t\t");
            } else {
                System.out.print("\33[31;1m×\33[0m\t\t");
            }
        }
        System.out.println("\n" + "-".repeat(100));
        System.out.println("Sorted number array:");
        for (double v : arr) {
            System.out.printf("\t%3.3f", v);
        }
        System.out.println();
        System.out.print("\t");
        int errors = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("\33[33;1m---\33[0m\t\t");
            } else if (arr[i] >= arr[i - 1]) {
                System.out.print("\33[32;1m√\33[0m\t\t");
            } else {
                errors++;
                System.out.print("\33[31;1m×\33[0m\t\t");
            }
        }
        System.out.println(errors == 0 ? "\33[32;1m(Test success)\33[0m" : "\33[31;1m(Test error)\33[0m\t\t");
        System.out.println("=".repeat(110) + "\n\n");
    }
}
