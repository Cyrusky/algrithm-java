import sorts.BubbleSort;
import sorts.InsertSort;
import sorts.SelectionSort;
import sorts.SortBase;

public class SortsMain {
    public static void main(String[] args) {

        SortBase[] sortMethods = {
                new InsertSort(),
                new BubbleSort(),
                new SelectionSort()
        };

        for (SortBase sortMethod : sortMethods) {
            sortMethod.sort();
        }
    }
}
