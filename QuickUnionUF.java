package kr.itanoss;

import java.util.Arrays;

public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N) {
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i])
            i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p), j = root(q);
        id[i] = j;
    }

    public static void main(String[] args) {
        QuickUnionUF uf = new QuickUnionUF(10);

        uf.union(0, 5);
        uf.union(5, 6);
        uf.union(1, 2);
        uf.union(8, 3);
        uf.union(3, 4);
        uf.union(8, 9);

        System.out.println(uf.connected(0, 6));
        System.out.println(uf.connected(8, 6));
        System.out.println(uf.connected(8, 4));
        System.out.println(Arrays.toString(uf.id));
    }
}
