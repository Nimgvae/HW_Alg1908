package HW_1908;
class MyLinkedList {
    private Node head;
    private int size;


    public void pushToTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }


    public void pushToIndex(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }


    public int removeLast() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        if (size == 1) {
            int data = head.data;
            head = null;
            size--;
            return data;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int data = current.next.data;
        current.next = null;
        size--;
        return data;
    }


    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            int data = head.data;
            head = head.next;
            size--;
            return data;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        int data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }


    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
}
