package edu.fdiazaguirre.amazon;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecondRoundTest {

	@Test
	public void test() {
		int R = 3;
        int C = 6;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                      {7,  8,  9,  10, 11, 12},
                      {13, 14, 15, 16, 17, 18}
                    };
		SecondRound.printMatrixSpiral(a, R, C);
	}

}
