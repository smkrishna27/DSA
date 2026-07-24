package tesco;

import java.util.*;

public class UnionFind {
    int[] parent, rank;
    int count;

    public UnionFind(int m, int n) {
        parent = new int[m * n];
        rank = new int[m * n];
        Arrays.fill(parent, -1);
        count = 0;
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return;
        if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        count--;
    }

    public void addLand(int x) {
        if (parent[x] == -1) {
            parent[x] = x;
            count++;
        }
    }

    public int getCount() { return count; }
}

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind uf = new UnionFind(m, n);
        List<Integer> result = new ArrayList<>();
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];
            int idx = r * n + c;
            uf.addLand(idx);

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                int nIdx = nr * n + nc;
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && uf.parent[nIdx] != -1) {
                    uf.union(idx, nIdx);
                }
            }
            result.add(uf.getCount());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] positions = {{0,0},{0,1},{1,2},{2,1}};
        System.out.println(sol.numIslands2(3, 3, positions)); // [1,1,2,3]
    }
}

