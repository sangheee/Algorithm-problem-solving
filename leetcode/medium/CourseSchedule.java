import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.*;
import org.junit.Test;

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Set<Integer>> courses=new ArrayList<>();
		for(int i=0; i<numCourses;i++)courses.add(new HashSet<>());
		
		for(int[]p:prerequisites) {
			int cur=p[0],pre=p[1];
			if(findTarget(courses,cur,pre)) {
				return false;
			}else {
				courses.get(cur).add(pre);
			}
		}
		return true;
	}
	
	private boolean findTarget(List<Set<Integer>>courses,int target, int cur) {
		if(courses.get(cur).contains(target))return true;
		if(courses.get(cur).size()==0)return false;
		
		for(int key:courses.get(cur)) {
			if(findTarget(courses,target,key))
				return true;
		}
		return false;
	}
	@Test
	public void test() {
		assertFalse(canFinish(3,new int[][]{{1,0},{2,0},{0,2}}));
		assertTrue(canFinish(3,new int[][]{{2,1},{1,0}}));
		assertTrue(canFinish(3,new int[][]{{0,1},{0,2},{1,2}}));
		assertTrue(canFinish(2,new int[][]{{1,0}}));
		assertFalse(canFinish(2,new int[][]{{1,0},{0,1}}));
		assertFalse(canFinish(3,new int[][]{{1,0},{0,2},{2,1}}));
	}
}
