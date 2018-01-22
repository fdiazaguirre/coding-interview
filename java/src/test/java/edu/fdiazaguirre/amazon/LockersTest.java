package edu.fdiazaguirre.amazon;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.fdiazaguirre.amazon.Lockers.Point;

public class LockersTest {

	@Test
	public void test() {
		int length = 3, width = 5;
		int[][] expecteds = new int[length][width];
		expecteds[0][0] = 2;
		expecteds[0][1] = 1;
		expecteds[0][2] = 2;
		expecteds[0][3] = 3;
		expecteds[0][4] = 5;
		
		expecteds[1][0] = 1;
		expecteds[1][1] = 0;
		expecteds[1][2] = 1;
		expecteds[1][3] = 2;
		expecteds[1][4] = 3;
		
		expecteds[2][0] = 2;
		expecteds[2][1] = 1;
		expecteds[2][2] = 2;
		expecteds[2][3] = 3;
		expecteds[2][4] = 5;

		
		Point locker = new Point(1, 1);
		List<Point> lockerLocations = new ArrayList<>();
		lockerLocations.add(locker);
		
		assertArrayEquals(expecteds, Lockers.getLockerDistanceGrid(length, width, lockerLocations));
	}

}
