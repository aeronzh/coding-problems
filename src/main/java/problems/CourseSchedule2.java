package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]. Given the total
 * number of courses and a list of prerequisite pairs, is it possible for you to
 * finish all courses?
 * 
 * For example, given 2 and [[1,0]], there are a total of 2 courses to take. To
 * take course 1 you should have finished course 0. So it is possible.
 * 
 * For another example, given 2 and [[1,0],[0,1]], there are a total of 2
 * courses to take. To take course 1 you should have finished course 0, and to
 * take course 0 you should also have finished course 1. So it is impossible.
 * 
 * A valid sequence of courses is required as output.
 * 
 * @author lucas
 *
 */
public class CourseSchedule2 {
	private static List<Integer> solve(int numCourses, int[][] prerequisites) {
		List<Integer> result = new ArrayList<Integer>();
		
		Map<Integer, Integer> toFrom = new HashMap<Integer, Integer>();
		
		// Count number of prerequisites for every course
		int[] pCount = new int[numCourses];
		for (int[] array:prerequisites) {
			int to = array[0];
			pCount[to]++;
		}
		
		//Store courses with no prerequisites in a queue
	    LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i=0; i<numCourses; i++) {
			if (pCount[i] == 0) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int top = queue.poll();
			result.add(top);
			
			// check if top was a prerequisite for some course
			for (int[] array:prerequisites) {
				int from = array[1];
				int to = array[0];
				if (from == top) {
					pCount[to]--;
					
					if (pCount[to] == 0) {
						// Course 'to' has no more prerequisite -> add to queue
						queue.add(to);
					}
				}
			}
		}
		
		for (int i=0; i<pCount.length; i++) {
			if (pCount[i]>0) {
				return new ArrayList<Integer>();
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[][] prerequisites = {{1,0}, {0,1}};
		int numCourses = 2;
		System.out.println(solve(numCourses, prerequisites));
	}

}
