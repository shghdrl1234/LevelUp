package level2;

import java.util.ArrayList;
import java.util.List;

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

		
	}
	
    public String solution(int[] numbers) {
    	
    	/*
    	 * ���� Ǫ�� ���
    	 * 1. number�� ��Ҹ� Ȯ���ؼ� ����� ���� �տ� �ִ� ���� ũ��, ���� ������ ������ �Ѵ�.
    	 * 
    	 * 2. ���� �տ� �ִ� ���� ũ��, �� ���� ���� ���Ѵ�.
    	 * 
    	 * 3. �� �� ��� 
    	 * 
    	 */
    	
    	List<String> l = new ArrayList<String>();
    	
    	for(int s : numbers) {
    		l.add(String.valueOf(s));
    	}
    	
    	for(int i = 0; i < l.size(); i++) {
    		
    		for(int j = 0; j < l.size()-1; j++) {
    			String store = "";
    			if((l.get(j)).charAt(0) < l.get(j+1).charAt(0)) {
    				store = l.get(j);
    				l.set(j, l.get(j+1));
    				l.set(j+1, store);
    			} else if((l.get(j)).charAt(1) < l.get(j+1).charAt(1)) {
    				
    			}
    		}
    		
    	}
    	
        String answer = "";
        return answer;
    }

}
