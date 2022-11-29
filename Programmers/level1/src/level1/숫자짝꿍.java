package level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ����¦�� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �� ���� X, Y�� ������ �ڸ����� �������� ��Ÿ���� ���� k(0 �� k �� 9)���� �̿��Ͽ� 
		 * ���� �� �ִ� ���� ū ������ �� ���� ¦���̶� �մϴ�.
		 * (��, �������� ��Ÿ���� ���� �� ���� ¦���� �� �ִ� ���ڸ� ����մϴ�). 
		 * X, Y�� ¦���� �������� ������, ¦���� -1�Դϴ�. X, Y�� ¦���� 0���θ� �����Ǿ� �ִٸ�, ¦���� 0�Դϴ�.
		 * 
		 * ���� ���, X = 3403�̰� Y = 13203�̶��, 
		 * X�� Y�� ¦���� X�� Y���� �������� ��Ÿ���� 3, 0, 3���� ���� �� �ִ� ���� ū ������ 330�Դϴ�. 
		 * 
		 * �ٸ� ���÷� X = 5525�̰� Y = 1255�̸� X�� Y�� ¦���� X�� Y���� �������� ��Ÿ���� 
		 * 2, 5, 5�� ���� �� �ִ� ���� ū ������ 552�Դϴ�.
		 * (X���� 5�� 3��, Y���� 5�� 2�� ��Ÿ���Ƿ� ���� 5 �� ���� ¦ ���� �� �����ϴ�.) 
		 * 
		 * �� ���� X, Y�� �־����� ��, X, Y�� ¦���� return�ϴ� solution �Լ��� �ϼ����ּ���.
		 * 
		 * ���ѻ���
		 *  3 �� X, Y�� ����(�ڸ���) �� 3,000,000�Դϴ�. 
		 *  X, Y�� 0���� �������� �ʽ��ϴ�. X, Y�� ¦���� ����� ū ������ �� �����Ƿ�, ���ڿ��� ��ȯ�մϴ�.
		 * 
		 * 
		 * 
		 */
		String x ="100";
		String y ="203045";
		solution(x,y);
	}
	
    public static String solution(String X, String Y) {
        /*
         * ���� ���� Ǫ�� ���
         * 1. �� ���ڿ����� ���� ���� ������ ���� ã�´�.
         * 2. ���� ���� ��Ÿ���� �� ���ڿ����� �����.
         * 3. ���� ���ڵ��� �ٸ� ���� ���� �����Ѵ�. => answer�� �ְ� sort?
         * 
         */
    	
    	Set<String> xSet = new HashSet<String>();
        ArrayList<String> xArr = new ArrayList<String>();
    	
    	String answer = "";
    	
//    	String[] x1 = X.split("");
//    	String[] y1 = Y.split("");
    	
    	StringBuilder x = new StringBuilder(X);
    	StringBuilder y = new StringBuilder(Y);
//    	String x = X;
//    	String y = Y;
    	
    	for(int i = 0; i < x.length(); i++) {
    		
    		int j=0;
    		while(j < y.length() && x.length() != 0) {
    			    			
    			if(x.charAt(i) == (y.charAt(j))) {

    				if(xSet.contains(x.charAt(i)+"")) {
    					xArr.add(x.charAt(i)+"");
    				} else {
    					xSet.add(x.charAt(i)+"");
    				}
	    				x = x.deleteCharAt(i);
	    				y = y.deleteCharAt(j);
	    				j--;
	    				System.out.println("x.length() = "+x.length());
	    				System.out.println("y.length() = "+y.length());
    			}
    			j++;
    		}
    	}
    	
    	System.out.println("xArr = "+xArr);
    	System.out.println("xSet = "+xSet);
    	System.out.println("xArr.size() = "+xArr.size());

    	for(String i : xSet) {
    		xArr.add(i);
    	}

    	for(String i : xArr) {
    		answer += i;
    	}
    	
    	if(xArr.size() == 0) {
    		answer = "-1";
    	}
    	
    	
    	System.out.println("answer = "+answer);
    	return answer = (Integer.valueOf(answer) == 0) ? "0" : answer ;
    }

}
