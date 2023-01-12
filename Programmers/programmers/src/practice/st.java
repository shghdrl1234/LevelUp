package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class st {

	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		ArrayList b = new ArrayList();
		
		
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(3);
		a.add(4);
		a.add(5);
		
		b.add(1);
		b.add(3);
		b.add(3);
		b.add(4);
		b.add(7);
		b.add(2);
		
		System.out.println(a.retainAll(b));
		System.out.println(a);
	}

    

}
