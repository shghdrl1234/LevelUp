package level1;

public class �ڸ������ϱ� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �ڿ��� N�� �־�����, 
		 * N�� �� �ڸ����� ���� ���ؼ� return �ϴ� solution �Լ��� ����� �ּ���. 
		 * ������� N =
		 * 123�̸� 1 + 2 + 3 = 6�� return �ϸ� �˴ϴ�.
		 * 
		 * ���ѻ��� 
		 * N�� ���� : 100,000,000 ������ �ڿ���
		 * 
		 */
		Solution s = new Solution();
		
		
//		System.out.println(s.solution(133));
		
		
		�ڸ������ϱ�_�ٸ���� ss = new �ڸ������ϱ�_�ٸ����();
		ss.solution(12345343);
	}
	
	public static class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        
	        // 100,000,000 ���� 10���� ���ʴ�� ������ ��� => ����
	        // � �ڿ����� �͵� �ذ� �� �� �ִ� ���� ã�ƺ���.
	        // ���ڸ� ���ڿ��� �������, ���ڿ� �ϳ��� �߶� ���ϴ°�?
	        
	        String numStr = String.valueOf(n);
	        
	        String[] index = numStr.split("");
	        
	        for(int i = 0; i< index.length; i++ ) {
	        	
	        	answer += Integer.valueOf(index[i]);
	        	
	        }
	        
	        System.out.println("Hello Java");

	        return answer;
	    }
	}

}

	class �ڸ������ϱ�_�ٸ���� {
    public int solution(int n) {
        int answer = 0;

        while (n != 0) { // 0�� �ƴҶ��� ���� �����Ѵ�.
            answer += n % 10; // �������� ���ذ���, 
            n /= 10; // ������ ���� ������  �����Ѵ�.
            
            System.out.println(answer);
        }

        return answer;
    }
}