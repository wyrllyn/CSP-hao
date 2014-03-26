package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestsResolution {
	
	private Resolution resolution_knight;
	private Solution solution_knight;
	
	private Resolution resolution_diag;
	private Solution solution_diag;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		solution_knight = new Solution(100);
		solution_knight.init_knight();
		resolution_knight = new Resolution(solution_knight);
		
		solution_diag = new Solution();
		solution_diag.init_diag();
		resolution_diag = new Resolution(solution_diag);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_knight() {
		Solution result = resolution_knight.simulatedAnnealing();
		assertNotNull(result);
	}
	
	//@Test
	public void test_diag() {
		Solution result = resolution_diag.simulatedAnnealing();
		assertNotNull(result);
	}

}
