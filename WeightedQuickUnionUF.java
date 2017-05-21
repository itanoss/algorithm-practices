package kr.itanoss;

import java.util.Arrays;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;

    public WeightedQuickUnionUF(int N) {
        this.id = new int[N];
        this.sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
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
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);

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
