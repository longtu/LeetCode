package wr.leetcode.algo.Facebook;

public class FlattenNode {
    String value;
    FlattenNode right;
    FlattenNode down;

    public FlattenNode(String value) {
        this.value = value;
    }

    public static FlattenNode flatten(FlattenNode node) {

        FlattenNode ret = new FlattenNode("ret");
        FlattenNode helper = ret;
        FlattenNode next = node;

        while( null != next ) {
            FlattenNode n = next;
            next = null;
            while( null != n ) {
                if( null == next && null != n.right ) {
                    next = n.right;
                }
                FlattenNode nNext = n.down;
                n.down = null;
                n.right = helper.right;
                helper.right = n;
                n = nNext;
                helper = helper.right;
            }
        }
        return ret.right;
    }

    @Override
    public String toString() {
        return String.format("[%s, down: %s]", this.value, this.down);
    }

    public static void main(String[] args) {

        FlattenNode a = new FlattenNode("A");
        FlattenNode b = new FlattenNode("B");
        FlattenNode c = new FlattenNode("C");
        FlattenNode d = new FlattenNode("D");
        FlattenNode e = new FlattenNode("E");
        FlattenNode m = new FlattenNode("M");
        FlattenNode w = new FlattenNode("W");
        FlattenNode p = new FlattenNode("P");
        FlattenNode o = new FlattenNode("O");
        FlattenNode n = new FlattenNode("N");
        FlattenNode q = new FlattenNode("Q");

        a.down = m;
        m.down = n;
        a.right = b;

        b.down = w;
        w.down = q;
        b.right = c;

        c.right = d;

        d.down = p;
        d.right = e;

        e.down = o;

        FlattenNode ret = flatten(a);
        while (null != ret) {
            System.out.println(ret);
            ret = ret.right;
        }
    }
}
