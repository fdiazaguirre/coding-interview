package edu.fdiazaguirre.interviews;

public class CyclicRotation {

	
	public static Integer[] solution(Integer[] arg, int K) {
        K = K % arg.length;
        if (K == 0) {
			return arg;
		}
		int i = 0;
		while (i < arg.length) {
			int v = arg[0], pos = i+K -1;
			if (pos >= arg.length) {
			    pos = pos - arg.length;
			}
			System.out.println(pos);
			arg[0] = arg[pos]; 
			arg[pos] = v;
			i++;
		}
		if ( i == arg.length - 1) {
		 arg[0] = arg[i];
		}
		
		return arg;
    }
}
