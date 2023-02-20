package utils;

public class SingletonCounter {
    private static SingletonCounter instance;

    public int counter;

    private SingletonCounter() {
        this.counter = 0;
    }

    public static SingletonCounter getInstance() {
        if (SingletonCounter.instance == null) {
            SingletonCounter.instance = new SingletonCounter();
        }
        return SingletonCounter.instance;
    }
}
