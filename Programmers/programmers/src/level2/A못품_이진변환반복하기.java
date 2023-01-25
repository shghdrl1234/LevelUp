package level2;

import java.util.ArrayList;
import java.util.LinkedList;

public class A��ǰ_������ȯ�ݺ��ϱ� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * 0�� 1�� �̷���� � ���ڿ� x�� ���� ���� ��ȯ�� ������ ���� �����մϴ�.
		 * 
		 * x�� ��� 0�� �����մϴ�. x�� ���̸� c��� �ϸ�, x�� "c�� 2�������� ǥ���� ���ڿ�"�� �ٲߴϴ�. 
		 * ���� ���, x = "0111010"�̶��, 
		 * x�� ���� ��ȯ�� ���ϸ� x = "0111010" -> "1111" -> "100" �� �˴ϴ�.
		 * 
		 * 0�� 1�� �̷���� ���ڿ� s�� �Ű������� �־����ϴ�. 
		 * s�� "1"�� �� ������ ����ؼ� s�� ���� ��ȯ�� ������ ��, 
		 * ���� ��ȯ�� Ƚ���� ��ȯ �������� ���ŵ� ��� 0�� ������ 
		 * ���� �迭�� ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
		 * 
		 * ���ѻ��� 
		 * s�� ���̴� 1 �̻� 150,000 �����Դϴ�. 
		 * s���� '1'�� �ּ� �ϳ� �̻� ���ԵǾ� �ֽ��ϴ�.
		 * 
		 */
		solution("01110");
	}
	   public static int[] solution(String s) {
	    	/*
	    	 * ���� ���� Ǫ�� ���
	    	 * 1. s���� 0�� ���� �Ѵ�. => 0�� ������ŭ ī��Ʈ
	    	 * 2. s�� s�� ������ 2�������� ��Ÿ����. 
	    	 * 3. s�� 1�� �� ������ �ݺ�.
	    	 * 
	    	 * ���ڿ��� ����, ������ �ַ� �߻��� => linkedList?
	    	 */
	        int[] answer = {0, 0};
	        
	        int zero = 0;
	        
	        String[] arr = s.split("");
	        
	        ArrayList ll = new ArrayList();
	        
	        for(String a : arr) {
	        	// linkedList �÷��ǿ� ���� �߰�.
	        	ll.add(a);
	        }
	        
	        int k =0;
	        while(ll.size() > 1) {
		        
	        	
		        while(ll.contains("0")) {
		        	// ���� 0�� ������ �� ���� �ݺ�
		        	ll.remove("0");
		        	zero ++;
		        }
		        
		        // ll �÷��� ��ü�� ���̸� ���������� ��Ÿ����,
		        String[] lb = Integer.toBinaryString(ll.size()).split("");
		        ll.clear();
		        
		        int i = 0;
		        for(String a : lb) {
		        	// �� �������� ll �÷��ǿ� ����
		        	ll.add(i, a);
		        	i++;
		        }
		        
	        k++;
	        }
	        answer[0] = k;
	        answer[1] = zero;
	        return answer;
	    }

	}