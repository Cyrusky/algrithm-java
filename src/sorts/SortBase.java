package sorts;

import config.Constants;
import utils.SingletonCounter;

public abstract class SortBase {

    protected int[] arr;

    public SortBase(int len) {
        this.init(len);
    }

    public SortBase() {
        this.init(10);
    }

    public SortBase(int[] arr) {
        this.arr = arr;
    }

    public static String center(String s, int size) {
        return center(s, size, ' ');
    }

    public static String center(String s, int size, char pad) {
        if (s == null || size <= s.length())
            return s;

        StringBuilder sb = new StringBuilder(size);
        sb.append(String.valueOf(pad).repeat((size - s.length()) / 2));
        sb.append(s);
        while (sb.length() < size) {
            sb.append(pad);
        }
        return sb.toString();
    }

    private void init(int len) {
        this.arr = new int[len];
        for (int i = 0; i < len; i++) {
            this.arr[i] = (int) Math.ceil(Math.random() * Math.pow(10, Constants.numberLength));
        }
    }

    protected void swap(int i1, int i2) {
        int temp = this.arr[i1];
        this.arr[i1] = this.arr[i2];
        this.arr[i2] = temp;
    }

    abstract public void sort();

    protected void print(int[] arr) {
        SingletonCounter counter = SingletonCounter.getInstance();

        System.out.println("=".repeat(110));
        System.out.print(SortBase.center(String.format("【%02d】 Sort Result (%s)", ++counter.counter, this.getClass().getSimpleName()), 110));
        System.out.println("\n" + "-".repeat(110));
        System.out.println("Original number array:");
        for (int v : this.arr) {
            System.out.printf("\t%" + Constants.numberLength + "d", v);
        }
        System.out.println();
        System.out.print("\t");
        for (int i = 0; i < this.arr.length; i++) {
            if (i == 0) {
                System.out.printf("\33[33;1m%" + Constants.numberLength + "s\33[0m\t", "---");
            } else if (this.arr[i] >= this.arr[i - 1]) {
                System.out.printf("\33[32;1m%" + Constants.numberLength + "s\33[0m\t", "√");
            } else {
                System.out.printf("\33[31;1m%" + Constants.numberLength + "s\33[0m\t", "×");
            }
        }
        System.out.println("\n" + "-".repeat(100));
        System.out.println("Sorted number array:");
        for (int v : arr) {
            System.out.printf("\t%" + Constants.numberLength + "d", v);
        }
        System.out.println();
        System.out.print("\t");
        int errors = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.printf("\33[33;1m%" + Constants.numberLength + "s\33[0m\t", "---");
            } else if (arr[i] >= arr[i - 1]) {
                System.out.printf("\33[32;1m%" + Constants.numberLength + "s\33[0m\t", "√");
            } else {
                errors++;
                System.out.printf("\33[31;1m%" + Constants.numberLength + "s\33[0m\t", "×");
            }
        }
        System.out.println(errors == 0 ? "\33[32;1m(Test success)\33[0m" : "\33[31;1m(Test error)\33[0m\t\t");
        System.out.println("=".repeat(110) + "\n\n");
    }
}
