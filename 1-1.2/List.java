public class List {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(2);
        list.add(1);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.insert(1, 5);
        System.out.println(list);
    }
}

class LinkedList {
    Node head;
    int size;

    // จง implement add method
    // โดย add method จะทำการเพิ่ม index ที่อยู่ท้ายสุดของ arrays มา 1 ตัว
    void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            // traverse ไปที่หลังสุด
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = node;
        }
    }

    // จง implement remove method
    // โดย remove method จะทำการลบ ข้อมูลตรง index ที่กำหนด
    void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            int i = 0;
            Node currNode = head;
            while (currNode.next != null && i < index - 1) {
                currNode = currNode.next;
                i++;
            }
            currNode.next = (currNode.next).next;
        }
    }

    // จง implement insert method
    // โดย insert จะทำงานโดยการ แทรก ข้อมูลไปที่ index ที่กำหนด
    void insert(int index, int value) {
        Node node = new Node(value);
        if (index == 0) {
            head = node;
        } else {
            int i = 0;
            Node currNode = head;
            while (currNode.next != null && i < index - 1) {
                currNode = currNode.next;
                i++;
            }
            node.next = currNode.next;
            currNode.next = node;
        }
    }

    @Override
    public String toString() {
        String output = "  ";
        Node currNode = head;
        output += currNode + "\n";
        while (currNode.next != null) {
            currNode = currNode.next;
            output += "  " + currNode + "\n";
        }
        return "LinkedList{\n" + output + "}";
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{data=" + this.data + "}";
    }
}