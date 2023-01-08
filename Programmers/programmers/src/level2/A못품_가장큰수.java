package level2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class A��ǰ_����ū�� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * 0 �Ǵ� ���� ������ �־����� ��, ������ �̾� �ٿ� ���� �� �ִ� ���� ū ���� �˾Ƴ� �ּ���.
		 * 
		 * ���� ���, �־��� ������ [6, 10, 2]��� 
		 * [6102, 6210, 1062, 1026, 2610, 2106]�� ���� �� �ְ�, 
		 * ���� ���� ū ���� 6210�Դϴ�.
		 * 
		 * 0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��, 
		 * ������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���ڿ��� �ٲپ�
		 * return �ϵ��� solution �Լ��� �ۼ����ּ���.
		 * 
		 * ���� ���� 
		 * numbers�� ���̴� 1 �̻� 100,000 �����Դϴ�. 
		 * numbers�� ���Ҵ� 0 �̻� 1,000 �����Դϴ�. 
		 * ������ �ʹ� Ŭ �� ������ ���ڿ��� �ٲپ� return �մϴ�.
		 * 
		 */

		solution(new int[]{3,30,34,5,9});
	}
	
    public static String solution(int[] numbers) {
    	
    	/*
    	 * ���� Ǫ�� ���
    	 * 1. number�� ��Ҹ� Ȯ���ؼ� ����� ���� �տ� �ִ� ���� ũ��, ���� ������ ������ �Ѵ�.
    	 * => ���� ���� ���� �������� ������������ ����
    	 * 
    	 * 2. �� �ڸ� �� �̻��� ���, ���ڸ��� ���ٸ� ���� �ڸ� ���� ��
    	 * => 1+a �ڸ� ���� �������� ������������ ����
    	 * 
    	 * 3. �ڸ� ���� �ٸ���, �ڸ� ���� ���� ���� �������� �Ͽ��� ��, ���� ���� ������
    	 * ���� �ڸ����� ���� �ִ´�.
    	 * 993 9 99 992
    	 * => 9 99 993 992, ��� ����� ��Ű��, �ڸ� ���� ���� ���� ������ �̵�
    	 * 
    	 * 993 9 99 8 
    	 * => 9 99 993 8, �ٸ� ���� ������ ��.
    	 * 
    	 * 999 98 9999
    	 * => 999 9999 98
    	 * 
    	 */
    	
    	LinkedList<String> l = new LinkedList<String>();
    	
    	for(int s : numbers) {
    		// ���� ���� �� ���ڵ��� LinkedList ��ü�� ����
    		l.add(String.valueOf(s));
    	}
    	
    	// LinkedList�� ������������ ����
    	Collections.sort(l, Comparator.reverseOrder());
    	
    	for(int i = 0; i < l.size(); i++) {
    		
    		for(int j = 0; j < l.size()-1; j++) {
    			
				String store = "";
				if(l.get(j).charAt(0) == l.get(j+1).charAt(0)) {	
					if(Integer.valueOf(l.get(j).substring(0,l.get(j+1).length())) < Integer.valueOf(l.get(j+1).substring(0,l.get(j+1).length()))) {
						// 9998 999 996 998 98 80
						store = l.get(j+1);
						l.set(j+1, l.get(j));
						l.set(j, store);
					}
				}
    		}
    		
    	}
    	
    	
    	String answer = "";
    	
    	for(String s : l) {
    		answer += s;
    		System.out.print(s);
    	}

    	return answer;
    }

}
