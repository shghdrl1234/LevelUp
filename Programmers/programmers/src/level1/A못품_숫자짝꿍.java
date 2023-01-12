package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
		String x ="5525";
		String y ="1255";
		
		System.out.println(solution2(x,y));
		
		
		
	}
	
	
	
	public static String solution2(String X, String Y) {
        
		/*
		 * �ð� ���⵵ �鿡�� ��ø for���� ������������ �Ѵ�.
		 * 
		 * 1. ���ڸ� �̿��Ͽ� ������ Ǭ��.
		 * 2. �� ���ں��� ������ Ƚ���� ���� ����
		 * 3. �۰� ���� ���� �ִ� ������ ��´�. 
		 * 
		 * 
		 * 
		 */
		ArrayList<Integer> xArr = new ArrayList<Integer>();
		ArrayList<Integer> yArr = new ArrayList<Integer>();
	 
		ArrayList<Integer> sumArr = new ArrayList<Integer>();
		
		for(int i = 0; i < 10; i++) {
			xArr.add(0);
			yArr.add(0);
		} // �� ����Ʈ�� 0�� ����.
		
		for(int i = 0; i < X.length(); i++) {
			
			for(int j = 0; j < 10; j++) {
				
				if(X.charAt(i) == j+48 ) {
					xArr.set(j, xArr.get(j)+1);
				}
				
			}
			
		}
		
		for(int i = 0; i < Y.length(); i++) {
			
			for(int j = 0; j < 10; j++) {
				
				if(Y.charAt(i) == j+48 ) {
					yArr.set(j, yArr.get(j)+1);
				}
				
			}
			
		}
		
		for(int i = 0; i < 10; i++) {
			if(xArr.get(i) <= yArr.get(i)) {
				sumArr.add(xArr.get(i));
			} else {
				sumArr.add(yArr.get(i));
			}
		}
		
		
		
		System.out.println("xArr : " + xArr);
		System.out.println("yArr : " + yArr);
		System.out.println("sumArr : " + sumArr);
		
		String answer = "";
		
		for(int i = 0; i < sumArr.size(); i++) {
			
			for(int j = 0; j < sumArr.get(i); j++) {
				answer += ("" + i);
			}
			
		}

		StringBuffer sb = new StringBuffer(answer);
		String reverse = sb.reverse().toString();
		
		System.out.println(answer);
		System.out.println(reverse);
		
	
		if(reverse.length() == 0) {
			reverse = "-1";
		}
			
		int cnt = 0;
		
		for(int i = 0; i < reverse.length(); i++) {
			if(reverse.charAt(i) != 48) {
				cnt++;
				break;
			}
		}
		
		if(cnt == 0) {
			reverse = "0";
		}
		
		return reverse;
    }

	
	 public static String solution1(String X, String Y) {
	        /*
	         * ���� ���� Ǫ�� ���
	         * 1. �� ���ڿ��� ���Ͽ� ���� ���� ������ ��ġ���� ���� �����.
	         * 2. ���� ��Ҵ� �ٸ� �迭�� ���� �����صд�.
	         * 3. ���� ������������ �����Ͽ� ��ȯ
	         */
		 
			ArrayList<String> xArr = new ArrayList<String>();
			ArrayList<String> yArr = new ArrayList<String>();
		 
			ArrayList<String> sumArr = new ArrayList<String>();
			
			for(String i : X.split("")) {
				xArr.add(i);
			}
			
			for(String i : Y.split("")) {
				yArr.add(i);
			}
			
			for(int i = 0; i < xArr.size(); i++) {
				
				for(int j = 0; j < yArr.size(); j++) {
					
					if(xArr.get(i).equals(yArr.get(j))) {
						sumArr.add(xArr.get(i));
						
						xArr.remove(i); i--;
						yArr.remove(j); j--;
						break;
					}
				}
			}
			
			System.out.println(sumArr);
			Collections.sort(sumArr, Collections.reverseOrder());
			System.out.println(sumArr);
			
			String answer = "";
			
			for(String s : sumArr) {
				answer += s;
			}
			
			if(answer.length() == 0) {
				answer = "-1";
			}
			
			int cnt = 0;
			
			for(int i = 0; i < answer.length(); i++) {
				if(answer.charAt(i) != '0') {
					cnt++;
				}
			}
			
			if(cnt == 0) {
				answer = "0";
			}
			
			
			System.out.println(answer);
	    	return answer;
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
