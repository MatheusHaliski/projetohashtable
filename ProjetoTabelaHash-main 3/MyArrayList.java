import java.util.ArrayList;

public class MyArrayList<T> {
    private ArrayList<T> data;

    public MyArrayList(int initialSize) {
        data = new ArrayList<>(initialSize);
        for (int i = 0; i < initialSize; i++) {
            data.add(null);
        }
    }

    public void add(T value) {
        data.add(value);
    }

    public T get(int index) {
        return data.get(index);
    }

    public void set(int index, T value) {
        data.set(index, value);
    }

    public int size() {
        return data.size();
    }
}
