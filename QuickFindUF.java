package kr.itanoss;

import java.util.Arrays;

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }
    }

    public static void main(String[] args) {
        QuickFindUF uf = new QuickFindUF(10);

        uf.union(0, 5);
        System.out.println(uf.connected(0, 5));
        System.out.println(Arrays.toString(uf.id));
    }
}
