import java.io.*;
import java.util.*;

/**
 * You are given an array of size N and another integer M. Your target is to
 * find the maximum value of sum of subarray modulo M.
 * 
 * Subarray is a continuous subset of array elements.
 * 
 * Note that we need to find the maximum value of (Sum of Subarray)%M , where
 * there are possible subarrays.
 * 
 * For a given array of size , subarray is a contiguous segment from to where
 * 
 * Input Format
 * 
 * First line contains T , number of test cases to follow. Each test case
 * consists of exactly 2 lines. First line of each test case contain 2 space
 * separated integers and , size of the array and modulo value M. Second line
 * contains N space separated integers representing the elements of the array.
 * 
 * Output Format
 * 
 * For every test case output the maximum value asked above in a newline.
 * 
 * 
 * Sample Input
 * 
 * 1
 * 
 * 5 7
 * 
 * 3 3 9 9 5
 * 
 * 
 * Sample Output
 * 
 * 6
 * 
 * 
 * @author lucas
 *
 */
public class Solution {
    static class BSTNode {
        private long value;
        private BSTNode left = null;
        private BSTNode right = null;
        private BSTNode parent = null;

        public BSTNode(long value) {
            this.value = value;
        }

        public BSTNode add(long value) {
            if (value <= this.value) {
                if (this.left == null) {
                    this.left = new BSTNode(value);
                    this.left.parent = this;
                    return this.left;
                } else {
                    return this.left.add(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new BSTNode(value);
                    this.right.parent = this;
                    return this.right;
                } else {
                    return this.right.add(value);
                }
            }
        }

        public BSTNode nextLargestAncestor() {
            BSTNode current = this;
            BSTNode parent = current.parent;
            while (parent != null) {
                if (parent.left == current) {
                    return parent;
                } else {
                    current = parent;
                    parent = parent.parent;
                }
            }

            return null;
        }
    }


    private static long mod(long x, long k) {
         return Math.floorMod(x, k);
    }

    private static long solve(long[] a, long m) {
        // Create prefix sum vector s:
        // Example: a = [4,5,3,10] m= 7. Then numbers modulo m = [4,5,3,3] and prefix sum vector s=[4,2,5,1], s[i] = sum(a[0..i]) % m
        // The mod-m sum of a sub array A[a,b] (inclusive, with a>0) is given by s[b]-s[a-1].
        // Find s[a-1]>s[b] with s[a-1] minimum.

        int n = a.length;
        long[] s = new long[n];
        s[0] = a[0] % m;
        for (int i=1; i<n; i++) {
            s[i] = (s[i-1] + a[i]) % m;
        }

        BSTNode[] treeNodes = new BSTNode[n];
        BSTNode tree = new BSTNode(s[0]);
        treeNodes[0] = tree;
        for (int i=1; i<n; i++) {
            treeNodes[i] = tree.add(s[i]);
        }

        long max = s[0];
        for (int i=1; i<n; i++) {
            BSTNode next = treeNodes[i].nextLargestAncestor();
            long value = (next != null ? next.value : 0);
            long sum = mod((s[i] - value), m);
            max = Math.max(max,Math.max(sum, s[i]));
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; t++) {
            int n = scanner.nextInt();
            long m = scanner.nextLong();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }

            System.out.println(solve(a, m));
        }
    }

}
