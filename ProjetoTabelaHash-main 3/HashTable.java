public abstract class HashTable {
    protected int size = 32;
    protected MyArrayList<MyLinkedList> table;
    protected int collisions = 0;
    protected int itemCount = 0;

    public HashTable() {
        table = new MyArrayList<>(size);
        for (int i = 0; i < size; i++) {
            table.set(i, new MyLinkedList());
        }
    }

    protected abstract int hash(String key);

    public void insert(String key) {
        int index = hash(key);
        MyLinkedList bucket = table.get(index);

        if (!bucket.isEmpty()) {
            collisions++;
        }

        bucket.add(key);
        itemCount++;

        if (loadFactor() > 0.75) {
            resize();
        }
    }

    public boolean search(String key) {
        int index = hash(key);
        MyLinkedList bucket = table.get(index);
        return bucket.contains(key);
    }

    public int getCollisions() {
        return collisions;
    }

    public void printDistribution() {
        for (int i = 0; i < size; i++) {
            System.out.println("Índice " + i + ": " + table.get(i).size() + " itens");
        }
    }

    private double loadFactor() {
        return (double) itemCount / size;
    }

    private void resize() {
        int newSize = size * 2;
        MyArrayList<MyLinkedList> newTable = new MyArrayList<>(newSize);

        for (int i = 0; i < newSize; i++) {
            newTable.set(i, new MyLinkedList());
        }

        for (int i = 0; i < size; i++) {
            MyLinkedList bucket = table.get(i);
            for (String key : bucket.getAll()) {
                int newIndex = hashForResize(key, newSize);
                newTable.get(newIndex).add(key);
            }
        }

        this.table = newTable;
        this.size = newSize;
    }

    private int hashForResize(String key, int tableSize) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash += c;
        }
        return Math.abs(hash) % tableSize;
    }
}
