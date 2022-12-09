package level1;

import java.util.HashMap;

public class ���尡�������� {

	public static void main(String[] args) {
		/*
		 * 
		 * ���� ���� 
		 * ���ڿ� s�� �־����� ��, s�� �� ��ġ���� �ڽź��� �տ� �������鼭, 
		 * �ڽŰ� ���� ����� ���� �ִ� ���� ���ڰ� ��� �ִ��� �˰� �ͽ��ϴ�. 
		 * ���� ���, s="banana"��� �� ��, �� ���ڵ��� ���ʺ��� ���������� 
		 * �о� �����鼭 ������ ���� ������ ���ֽ��ϴ�.
		 * 
		 * b�� ó�� ���Ա� ������ �ڽ��� �տ� ���� ���ڰ� �����ϴ�. �̴� -1�� ǥ���մϴ�. 
		 * a�� ó�� ���Ա� ������ �ڽ��� �տ� ���� ���ڰ������ϴ�. �̴� -1�� ǥ���մϴ�. 
		 * n�� ó�� ���Ա� ������ �ڽ��� �տ� ���� ���ڰ� �����ϴ�. �̴� -1�� ǥ���մϴ�. 
		 * a�� �ڽź��� ��ĭ �տ� a�� �ֽ��ϴ�. �̴� 2�� ǥ���մϴ�. 
		 * n�� �ڽź��� �� ĭ �տ� n�� �ֽ��ϴ�. �̴� 2�� ǥ���մϴ�. 
		 * a�� �ڽź��� �� ĭ, �� ĭ �տ� a�� �ֽ��ϴ�. 
		 * 
		 * �� �� ����� ���� �� ĭ ���̰�, �̴� 2�� ǥ���մϴ�. 
		 * ���� ���� ������� [-1, -1, -1, 2, 2, 2]�� �˴ϴ�.
		 * 
		 * ���ڿ� s�� �־��� ��, ���� ���� ���ǵ� ������ �����ϴ� �Լ� solution�� �ϼ����ּ���. 
		 * 
		 * ���ѻ��� 1 �� s�� ���� �� 10,000
		 * s�� ���� �ҹ��ڷθ� �̷���� �ֽ��ϴ�.
		 * 
		 */

	}
    public int[] solution(String s) {
        
        /*
         * ���� ���� Ǫ�� ���
         * 
         * 1. �ݺ����� ��ø�Ѵ�. i�� ���ڿ� ������� ����. 
         * 2. i�� ��������, j�� i���� ���� ���� ���ȸ� ��ȸ��.
         * 3. ��ȸ�ϸ鼭 ������ �ϳ��� ������ -1 ����,
         * 4. ��ȸ�ϸ鼭 ������ ��������, ���� ����� ������ ������ i�Ÿ� ����
         * 
         * 
         */
        
    	int[] answer = new int[s.length()];
    	
    	for(int i = 0; i < answer.length; i++) {
    		answer[i] = -1;
    	}
        
        
        for(int i = 1; i < s.length(); i++) {
        	int idx = 0;
        	
        	for(int j = 0; j < i; j++ ) {
        		
        		if(s.charAt(j) == s.charAt(i)) {
        			idx = i-j;

        			answer[i] = idx;
        		}
        		
        	}
        	
        }
        
        return answer;
    }
}
	class ���尡��������_�ٸ���� {
	    public int[] solution(String s) {
	        int[] answer = new int[s.length()];
	
	        HashMap<Character, Integer> map = new HashMap<>();
	        for(int i=0; i<s.length(); i++) {
	            if(!map.containsKey(s.charAt(i))) {
	                answer[i] = -1;
	                map.put(s.charAt(i), i);
	            }else {
	                int before = map.get(s.charAt(i));
	                answer[i] = i - before;
	                map.put(s.charAt(i), i);
	            }
	        }
	        return answer;
	    }
}
	
	/*
	 * 
	 * hashMap�� Ȱ���� ���� �ڵ带 ���� ������ ���ظ����� ���ϰڴ�.
	 * 
	 * hashMap�� �����غ���.
	 * 
	 */
	
	
	