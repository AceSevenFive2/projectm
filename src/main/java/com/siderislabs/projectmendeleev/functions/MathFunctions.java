package com.siderislabs.projectmendeleev.functions;

public class MathFunctions {

	public static Integer SimpleSigma(Integer lower, Integer upper) {
		int result = new Integer(0);
		if(upper == 0) {
			return 0;
		}
		else {
			for(int i = 1; i <= upper; i++) {
				result += i;
			}
			return result;
		}
	}
}
