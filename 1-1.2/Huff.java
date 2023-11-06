import java.util.ArrayList;

public class Huff {
    public static void main(String[] args) {
        Huffman huff = new Huffman("AABBCCACCD");
    }
}

class Huffman {
    Huffman(String raw) {
        ArrayList<Feq> feqs = this.frequency(raw);
        ArrayList<N> nodes = this.to_nodes(feqs);
        this.tree(nodes);
        System.out.println(nodes);
        ArrayList<Bit> aBits = this.traverse(nodes.get(0), "", new ArrayList<>());
        System.out.println(aBits);
    }

    void tree(ArrayList<N> nodes) {
        while (nodes.size() > 1) {
            this.sort(nodes);
            N min1 = nodes.get(0);
            N min2 = nodes.get(1);
            N node = new N(min1.count + min2.count);
            node.left = min1;
            node.right = min2;
            nodes.remove(min1);
            nodes.remove(min2);
            nodes.add(node);
        }
    }

    ArrayList<Bit> traverse(N node, String bits, ArrayList<Bit> aBits) {
        if (node.left != null) {
            traverse(node.left, bits + "0", aBits);
        }
        if (node.left == null && node.right == null) {
            aBits.add(new Bit(node.ch, bits));
            // System.out.println(node + " " + bits);
        }
        if (node.right != null) {
            traverse(node.right, bits + "1", aBits);
        }
        return aBits;
    }

    void sort(ArrayList<N> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (nodes.get(j).count <= nodes.get(i).count) {
                    N tmp = nodes.get(i);
                    nodes.set(i, nodes.get(j));
                    nodes.set(j, tmp);
                }
            }
        }
    }

    ArrayList<N> to_nodes(ArrayList<Feq> feqs) {
        ArrayList<N> nodes = new ArrayList<>();
        for (Feq feq : feqs) {
            nodes.add(new N(feq.ch, feq.count));
        }
        return nodes;
    }

    ArrayList<Feq> frequency(String raw) {
        ArrayList<Feq> feqs = new ArrayList<>();
        for (int i = 0; i < raw.length(); i++) {
            char now = raw.charAt(i);
            boolean found = false;
            for (Feq feq : feqs) {
                if (feq.ch == now) {
                    feq.count++;
                    found = true;
                    break;
                }
            }
            if (found == false) {
                feqs.add(new Feq(now));
            }
        }
        return feqs;
    }
}

class N {
    char ch;
    int count = 1;
    N left;
    N right;

    N(int count) {
        this.count = count;
    }

    N(char c, int count) {
        this.ch = c;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Node{" + this.ch + "," + this.count + "}";
    }
}

class Bit {
    final char ch;
    String bits;

    Bit(char ch, String bits) {
        this.ch = ch;
        this.bits = bits;
    }

    @Override
    public String toString() {
        return "Bit{" + this.ch + "," + this.bits + "}";
    }
}

class Feq {
    final char ch;
    int count = 1;

    Feq(char ch) {
        this.ch = ch;
    }

    @Override
    public String toString() {
        return "Feq{" + this.ch + "," + this.count + "}";
    }
}