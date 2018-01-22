package edu.fdiazaguirre.interviews;

public class Cascade {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Main");
//		ClassB c = new ClassB();
		
		Object x= new Integer(10);
  		Object y= new Long(100);
 		Object z= new StringBuffer("Garbage");
  		Object obj = x;
 		x = z;
 		z = y;
 		y = x;
 		System.out.println(x.toString());
 		System.out.println(y.toString());
	}

}
