package problems;
import java.util.*;


public class ScalarProduct {

    private static class MyVector {
        Long x;
        Long y;

        public MyVector(Long x, Long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyVector myVector = (MyVector) o;

            if (x != null ? !x.equals(myVector.x) : myVector.x != null) return false;
            return y != null ? y.equals(myVector.y) : myVector.y == null;

        }

        @Override
        public int hashCode() {
            int result = x != null ? x.hashCode() : 0;
            result = 31 * result + (y != null ? y.hashCode() : 0);
            return result;
        }
    }

    private static Long[] sequence(int c, int m, int n) {
        int len = 2*n+2;
        Long[] seq = new Long[len];

        seq[0] = new Long(0);
        seq[1] = new Long(c);
        int i=0;
        do {
            seq[i+2] = (seq[i+1] + seq[i])%m;
            i++;
        } while (i<len-2);

        return seq;
    }

    private static Set<Long>  residues(Long[] seq, int m) {
        Set<MyVector> vectors = new HashSet<MyVector>();
        Set<Long> residues = new HashSet<Long>();

        for (int i=2; i<seq.length; i=i+2) {
            MyVector newVect = new MyVector(seq[i], seq[i+1]);
            for (MyVector existingVect:vectors) {
                residues.add((existingVect.x*newVect.x + existingVect.y*newVect.y ) % m);
            }
            vectors.add(newVect);
        }

        return residues;
    }

    public static void main(String[] args) {
        int c = 1000000000;
        int m = 99;
        int n = 300000;


        if (c % m == 0) {
            System.out.println(1);
            return;
        }

        Long[] seq = sequence(c,m,n);
        Set<Long> residues = residues(seq,m);
        System.out.println("Result="+(residues.size() % m));

    }
}
