package core;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestsSolution {
	
	private Solution solution;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_initialization_default() {
		solution = new Solution();
		solution.init();
		List<Integer> vector = solution.getVector();
		for (Integer i : vector) {
			assertTrue(i >= 0);
			assertTrue(i < Solution.DEFAULT_SIZE);
		}
	}
	
	@Test
	public void test_initialization_100() {
		solution = new Solution(100);
		solution.init();
		List<Integer> vector = solution.getVector();
		for (Integer i : vector) {
			assertTrue(i >= 0);
			assertTrue(i < 100);
		}
	}

	@Test
	public void test_calculateCost() {
		solution = new Solution();
		List<Integer> vector = solution.getVector();
		vector.set(0, 1);
		vector.set(1, 0);
		vector.set(2, 2);
		vector.set(3, 4);
		vector.set(4, 3);
		vector.set(5, 0);
		vector.set(6, 3);
		vector.set(7, 7);
		int cost = solution.calculateCost();
		assertTrue(cost == 7);
	}
}
