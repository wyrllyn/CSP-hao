package core;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestsMoves {
	
	private Moves moves;
	private Solution solution;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		solution = new Solution();
		solution.init();
		moves = new Moves(solution);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_swap() {
		List<Integer> vector = solution.getVector();
		int first_before = vector.get(0);
		int second_before = vector.get(1);
		moves.swap(0, 1);
		int first_after = vector.get(0);
		int second_after = vector.get(1);
		assertTrue(first_before == second_after);
		assertTrue(second_before == first_after);
	}
	
	@Test
	public void test_ONE_MOVE() {
		List<Integer> vector = solution.getVector();
		int before = vector.get(0);
		//System.out.println(vector);
		moves.move(0);
		//System.out.println(vector);
		int after = vector.get(0);
		assertTrue(before != after);
		assertTrue(after >= 0);
		assertTrue(after < solution.getSize());
	}

}
