public class List {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("A", 0);
        list.add("F", -1);
        list.add("B", 1);
        list.add("C", 2);
        list.add("D", 3);
        list.insert(2, "Hello", 100);
        list.traverse();
    }
}

class LinkedList {
    Linked head;
    Linked tail;

    // add O(1);
    void add(String name, int value) {
        Linked link = new Linked(value, name);
        if (this.head == null) {
            this.head = link;
            this.tail = this.head;
        } else {
            this.tail.next = link;
            this.tail = link;
            // Linked currLinked = this.head;
            // while (currLinked.next != null) {
            // currLinked = currLinked.next;
            // }
            // currLinked.next = link;
        }
    }

    void insert(int pos, String name, int value) {
        Linked link = new Linked(value, name);
        Linked currLinked = this.head;
        int i = 0;
        while (currLinked.next != null && i < pos) {
            currLinked = currLinked.next;
            i++;
        }
        link.next = currLinked.next;
        currLinked.next = link;
    }

    void traverse() {
        Linked currLinked = this.head;
        while (currLinked.next != null) {
            System.out.println(currLinked);
            currLinked = currLinked.next;
        }
        System.out.println(currLinked);
    }
}

class Linked {
    int value;
    String name;
    Linked next;

    Linked(int v, String name) {
        this.value = v;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Linked name = " + this.name + ", value = " + this.value;
    }
}