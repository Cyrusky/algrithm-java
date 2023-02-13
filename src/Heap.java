public class Heap {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ArrayHeap arrayHeap = new ArrayHeap(10, true);
            System.out.println(arrayHeap.verify());
        }
    }
}
