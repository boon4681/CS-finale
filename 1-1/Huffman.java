import java.util.ArrayList;
import java.util.Stack;

public class Huffman {
    public static void main(String[] args) {
        Huff huff = new Huff("ACAACBAC");
        System.out.println(huff);
    }
}

class Huff {
    String value;
    ArrayList<Output> result;

    Huff(String value) {
        this.value = value;
        Node tree = this.tree();
        this.result = traverse(tree, new Stack<>());
    }

    ArrayList<Output> traverse(Node tree, Stack<Integer> order) {
        ArrayList<Output> result = new ArrayList<>();
        if (tree.left != null) {
            order.push(0);
            result.addAll(traverse(tree.left, order));
            order.pop();
        }
        if (tree.left == null && tree.right == null) {
            result.add(new Output(tree.value.charAt(0), (Stack<Integer>) order.clone()));
        }
        if (tree.right != null) {
            order.push(1);
            result.addAll(traverse(tree.right, order));
            order.pop();
        }
        return result;
    }

    Node tree() {
        ArrayList<CHAR> feq = this.feq();
        ArrayList<Node> nodes = new ArrayList<>();
        for (CHAR ch : feq) {
            nodes.add(new Node(ch.v + "", ch.count));
        }
        while (nodes.size() > 1) {
            Node[] o = getLast2(nodes);
            Node node = new Node(null, o[0].count + o[1].count);
            node.left = o[0];
            node.right = o[1];
            nodes.remove(o[0]);
            nodes.remove(o[1]);
            nodes.add(node);
        }
        return nodes.get(0);
        // System.out.println(nodes);
    }

    Node[] getLast2(ArrayList<Node> feq) {
        Node min1 = feq.get(0);
        Node min2 = feq.get(0);
        for (Node ch : feq) {
            if (min1.count >= ch.count) {
                min1 = ch;
            }
        }
        for (Node ch : feq) {
            if (ch.count >= min1.count && min2.count >= min1.count && ch.value != min1.value) {
                min2 = ch;
            }
        }
        return new Node[] { min1, min2 };
    }

    ArrayList<CHAR> feq() {
        ArrayList<CHAR> list = new ArrayList<>();
        for (int i = 0; i < this.value.length(); i++) {
            boolean found = false;
            char now = this.value.charAt(i);
            for (CHAR ch : list) {
                if (ch.v == now) {
                    ch.count++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                list.add(new CHAR(now));
            }
        }
        for (CHAR ch : list) {
            System.out.println(ch);
        }
        return list;
    }

    @Override
    public String toString() {
        return this.result + "";
    }
}

class Node {
    Node left;
    Node right;
    String value;
    int count;

    Node(String v, int count) {
        this.value = v;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Node CHAR = " + this.value + " " + this.count
                + (this.left != null ? "\n  LEFT  = " + this.left.toString(2) : "")
                + (this.right != null ? "\n  RIGHT = " + this.right.toString(2) : "");
    }

    public String toString(int depth) {
        return "Node CHAR = " + this.value + " " + this.count
                + (this.left != null ? "\n" + "  ".repeat(depth) + "LEFT  = " + this.left.toString(depth + 1) : "")
                + (this.right != null ? "\n" + "  ".repeat(depth) + "RIGHT = " + this.right.toString(depth + 1) : "");
    }
}

class CHAR {
    char v;
    int count = 1;

    CHAR(char v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "CHAR = " + this.v + " " + this.count;
    }
}

class Output {
    char v;
    Stack<Integer> bits;

    Output(char v, Stack<Integer> bits) {
        this.v = v;
        this.bits = bits;
    }

    @Override
    public String toString() {
        String b = "";
        for (Integer i : bits) {
            b += i;
        }
        return "CHAR = " + this.v + " " + b;
    }
}