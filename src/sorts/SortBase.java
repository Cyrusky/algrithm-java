package sorts;

public abstract class SortBase {

    protected double[] arr;

    public SortBase(int len) {
        this.init(len);
    }

    public SortBase() {
        this.init(10);
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

    public void init(int len) {
        this.arr = new double[len];
        for (int i = 0; i < len; i++) {
            this.arr[i] = Math.ceil(Math.random() * 100000) / 100;
        }
    }

    abstract public void sort();

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
