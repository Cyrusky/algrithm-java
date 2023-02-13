import sorts.*;

public class SortsMain {
    public static void main(String[] args) {

        SortBase[] sortMethods = {
                new InsertSort(),
                new BubbleSort(),
                new SelectionSort(),
                new ShellSort()
        };

        for (SortBase sortMethod : sortMethods) {
            sortMethod.sort();
        }
    }
}
