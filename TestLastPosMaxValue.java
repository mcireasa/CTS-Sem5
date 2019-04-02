package s5.testare;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import s5.clase.CustomException;
import s5.clase.Utils;

public class TestLastPosMaxValue {

	// Testare CORRECT
	// Conformance
	// Ordonance
	// Reference
	// Range
	// Existence
	// Cardinality
	// Time
	
	@Test
	public void testRight() throws CustomException {
		// Right
		int[] v = {2, 10, 5, 10, 5, 4};
		int expectedValue = 3;
		int actualValue = Utils.lastPosMaxValue(v);
		assertEquals("Verificam Test Right", expectedValue, actualValue);
	}
	
	@Test(expected = CustomException.class)
	public void testException1() throws CustomException {
		int[] v1 = null;
		Utils.lastPosMaxValue(v1);
	}
	
	@Test(expected = CustomException.class)
	public void testException2() throws CustomException {
		int[] v1 = {};
		Utils.lastPosMaxValue(v1);
	}
	
	@Test
	public void testBoundary() throws CustomException {
		int[] v = {10};
		int expectedValue = 0;
		int actualValue = Utils.lastPosMaxValue(v);
		
		assertEquals("Verificam vector cu limita minima size = 1", expectedValue, actualValue);
	}
	
	@Test
	public void testPerformance1() throws CustomException {
		int[] v = {10, 50, 40, 20, 30, 40, 30, 10};
		long startTime = System.currentTimeMillis();
		Utils.lastPosMaxValue(v);
		long endTime = System.currentTimeMillis();
		assertTrue("Verificam timp de performanta", endTime - startTime <= 10);
	}
	
	@Test(timeout = 10)
	public void testPerformance2() throws CustomException {
		int[] v = {10, 50, 40, 20, 30, 40, 30, 10};
		Utils.lastPosMaxValue(v);
	}
	
	@Test
	public void testCrossCheck() throws CustomException {
		// Ca la right doar ca diferit
		int[] v = {2, 10, 5, 10, 5, 4};
		ArrayList<Integer> listInt = new ArrayList<Integer>();
		for (int i = 0; i < v.length; i++) {
			listInt.add(v[i]);
		}
		
		ArrayList<Integer> listMax = new ArrayList<>();
		listMax.add(Collections.max(listInt));
		int expected = Collections.lastIndexOfSubList(listInt, listMax);
		int actual = Utils.lastPosMaxValue(v);
		assertEquals("Verificare Cross Check", expected, actual);
	}
	
	@Test
	public void testInverse() throws CustomException {
		int[] v = {2, 10, 5, 10, 5, 4};
		int poz = -1;
		poz = Utils.lastPosMaxValue(v);
		assertNotEquals("Verificare faptul ca pozitia s-a schimbat", -1, poz);
	}
	
	@Test
	public void testOrdering() throws CustomException {
		int[] v = {10, 40, 50, 60, 70, 80};
		int expected = 5;
		int actual = Utils.lastPosMaxValue(v);
		assertEquals("Verificare cu vector sortat", expected, actual);	
	}
	
	@Test(expected = CustomException.class)
	public void testCardinality() throws CustomException {
		// 0-1-n
		int[] v = {};
		Utils.lastPosMaxValue(v);
	}
}
