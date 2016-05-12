package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 15/02/16.
 */
public class CyclesSum {

    private static int sum(Integer[] cycle, int[] edgeWeights) {
        int cycleSum = 0;
        for (int e:cycle) {
            cycleSum += edgeWeights[e];
        }

        return cycleSum;
    }

    public static void main(String[] args) {
        int[] edgeWeights = {2, -5, 0, 1, 1, 1};

        List<Integer[]> cycles = new ArrayList<Integer[]>();
        cycles.add(new Integer[]{0,1,2,3});
        cycles.add(new Integer[]{0,4,3});
        cycles.add(new Integer[]{0,1,5});
        int result = -1;
        for (int e = 0; e < 6; e++) {
            for (int p=0; p<=120; p++) {
                edgeWeights[e] = edgeWeights[e] + p;
                boolean allPositive = true;

                // Check if all cycles are positive
                for (Integer[] cycle : cycles) {
                    int cycleSum = sum(cycle, edgeWeights);
                    if (cycleSum < 0) {
                        allPositive = false;
                    }
                }
                edgeWeights[e] = edgeWeights[e] - p;

                if (allPositive) {
                    if (p>0 && result==-1) {
                        result = p;
                    } else if (p>0 && p <result) {
                        result = p;
                    }
                }
            }
        }
        System.out.println(result);
    }

}