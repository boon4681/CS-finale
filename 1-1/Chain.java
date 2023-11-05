public class Chain {
    public static void main(String[] args) {
        Linked a = new Linked(1, "a");
        Linked b = new Linked(2, "b");
        Linked c = new Linked(3, "c");
        Linked d = new Linked(4, "d");
        Linked e = new Linked(5, "e");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        traverse(a);
    }

    public static void traverse(Linked currLinked) {
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