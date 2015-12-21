package problems;

import java.util.HashMap;
import java.util.LinkedList;
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
 * 
 * @author lucas
 *
 */
public class CourseSchedule {
	private static boolean solve(int numCourses, int[][] prerequisites) {
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
		
		
		// If a course remains that has prerequisites left
		for (int i=0; i<pCount.length; i++) {
			if (pCount[i]>0) {
				return false;
			}
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		int[][] prerequisites = {{1,0}};
		int numCourses = 2;
		System.out.println(solve(numCourses, prerequisites));
	}

}
