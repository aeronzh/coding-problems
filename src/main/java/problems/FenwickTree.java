package problems;

/**
 * Created by lucas on 28/02/16.
 */
public class FenwickTree {
    int tree[];

    public FenwickTree(int arr[]) {
        tree = new int[arr.length+1];
        tree[0] = 0;
        this.construct(1, arr);
    }

    private void construct(int index, int arr[]) {
        if (index-1 < arr.length) {
            tree[index] = tree[index] + arr[index-1];
            int next = index + (index & (-1*index));
            this.construct(next, arr);
        }
    }

    public int sum(int start, int end) {
        int sum = 0;
        int treeStart = start+1;
        int treeEnd = end+1;

        if (treeStart <= treeEnd) {
            int next = treeStart + (treeStart & (-1*treeStart));
            sum += tree[treeStart] + sum (next, end);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 1, 6, 9, 10, 11, 23, 1, 7, 9};
        FenwickTree tree = new FenwickTree(arr);
        System.out.println(tree.sum(0,10));
    }
}
