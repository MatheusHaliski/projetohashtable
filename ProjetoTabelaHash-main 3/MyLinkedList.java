import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {
    private Node head;

    private class Node {
        String key;
        Node next;

        Node(String key) {
            this.key = key;
            this.next = null;
        }
    }

    public MyLinkedList() {
        this.head = null;
    }

    public void add(String key) {
        if (head == null) {
            head = new Node(key);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(key);
        }
    }

    public boolean contains(String key) {
        Node current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public List<String> getAll() {
        List<String> keys = new ArrayList<>();
        Node current = head;
        while (current != null) {
            keys.add(current.key);
            current = current.next;
        }
        return keys;
    }
}
