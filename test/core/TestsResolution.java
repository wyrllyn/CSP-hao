package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestsResolution {
	
	private Resolution resolution;
	private Solution solution;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		solution = new Solution();
		solution.init();
		resolution = new Resolution(solution);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Solution result = resolution.simulatedAnnealing();
		assertNotNull(result);
	}

}
