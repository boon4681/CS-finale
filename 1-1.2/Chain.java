public class Chain {
    public static void main(String[] args) {
        Node a = new Node(0);
        Node b = new Node(1);
        Node c = new Node(2);
        a.next = b;
        b.next = c;
        traverse(a);
    }

    // จง implement traverse method
    // traverse คือ การไปยังทุก node
    // travel to universe
    static void traverse(Node node) {
        Node currNode = node;
        System.out.println(currNode);
        while (currNode.next != null) {
            currNode = currNode.next;
            System.out.println(currNode);
        }
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
        return "Node data=" + this.data;
    }
}