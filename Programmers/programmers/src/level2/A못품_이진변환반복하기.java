package level2;

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
	public static int[] solution2(String s) {
		/*
		 * 
		 * 
		 */
		
		
		return new int[0];
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
        
        LinkedList ll = new LinkedList();
        System.out.println(ll.size());
	       
        for(String a : arr) {
        	ll.add(a);
        }
        
        int k =0;
        while(ll.size() > 1) {
	        
        	int j = 0;
        	for(Object a : ll) {
        		ll.set(j, a);
        		j++;
        	}
        	
	        while(ll.contains("0")) {
	        	ll.remove("0");
	        	zero ++;
	        }
	        
	        int i = 0;
	        for(String a : Integer.toBinaryString(ll.size()).split("")) {
	        	ll.set(i, a);
	        	i++;
	        }
        k++;
        }
        
        System.out.println("ll�� ��� : " +ll);
        System.out.println(zero);
        answer[0] = k;
        answer[1] = zero;
        return answer;
    }

}
