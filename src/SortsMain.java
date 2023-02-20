import sorts.*;

public class SortsMain {
    public static void main(String[] args) {

        SortBase[] sortMethods = {
                new InsertSort(),
                new BubbleSort(),
                new SelectionSort(),
                new HeapSort(),
                new ShellSort(),
                new MergeSort(),
                new QuickSort(),
                new BucketSort(),
                new RadixSort()
        };

        for (SortBase sortMethod : sortMethods) {
            sortMethod.sort();
        }
    }
}
