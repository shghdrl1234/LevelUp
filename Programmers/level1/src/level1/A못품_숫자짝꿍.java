package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class A��ǰ_����¦�� {

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
		String y ="123450";
		solution(x,y);
	}
	
	
	
    public static String solution(String X, String Y) {
        /*
         * ���� ���� Ǫ�� ���
         * 1. �� ���ڿ����� ���� ���� ������ ���� ã�Ƽ� ���ڿ����� �����.
         * 2. ���� ���� �ٸ� ���� ��ġ�Ͽ� ������������ ����.
         * 
         */

		ArrayList<String> xArr = new ArrayList<String>();
		ArrayList<String> yArr = new ArrayList<String>();
    	String answer = "";
    	String store ="";
		for(String i : X.split("")) {
    		xArr.add(i);
    	}

		for(String j : Y.split("")) {
			yArr.add(j);
		}
		
		for(int i = 0; i < xArr.size(); i++) {
			
			for(int j = 0; j < yArr.size(); j++) {
				if(xArr.size()==1) {
					i=0;
				}
				
				if(xArr.get(i).equals(yArr.get(j))) {
					store += xArr.get(i);
					xArr.remove(xArr.get(i));
					yArr.remove(yArr.get(j));
					j--;
				}
			}
		}
		
		String[] hi = store.split("");
    	Arrays.sort(hi);
    	System.out.println();
    	answer = Arrays.toString(hi);
    	
    	if(String.valueOf(store) == "") {
    		answer = "-1";
    	} else if(Integer.valueOf(store) == 0) {
    		answer = "0";
    	}
    	
		 System.out.println(answer);
    	return answer;
    }

}
