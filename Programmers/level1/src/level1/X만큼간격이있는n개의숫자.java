package level1;

import java.util.ArrayList;

public class X��ŭ�������ִ�n���Ǽ��� {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �Լ� solution�� ���� x�� �ڿ��� n�� �Է� �޾�, 
		 * x���� ������ x�� �����ϴ� ���ڸ� n�� ���ϴ� ����Ʈ�� �����ؾ��մϴ�. 
		 * ���� ���� ������ ����, ������ �����ϴ� �Լ�, solution�� �ϼ����ּ���.
		 * 
		 * ���� ���� 
		 * x�� -10000000 �̻�, 10000000 ������ �����Դϴ�. n�� 1000 ������ �ڿ����Դϴ�.
		 * 
		 */

		solution(2,2);
		
	}
	
	static public long[] solution(int x, int n) {
        
		long[] answer = new long[n];
		
		// 0. �迭�� ����� ���ؼ� �� ���� �˾ƾ߰���..
        // 1. x���� �����ؼ� x�� ����. ��������? ����Ʈ�� ���̰� n���� �� �� ����.
        // 2. �ϴ� �ݺ����� ����ؾ��Ѵ�. 
        
		int i = 0;
		long num = x;
	
		while( i < answer.length) {
			System.out.println(num);
        	answer[i] = num;
        	num += x;
        	i++;
        }
        
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        
        return answer;
    }
}


	class X��ŭ�������ִ�n���Ǽ���_�ٸ���� {
	    public static long[] solution(int x, int n) {
	        long[] answer = new long[n];
	        answer[0] = x;
	
	        for (int i = 1; i < n; i++) {
	            answer[i] = answer[i - 1] + x;
	        }
	
	        return answer;
	        // ��ü������ ���� ����� ����� ����Ͽ�����.
	        // �� ���� �ڵ尡 �ξ� �����ϰ�, ���� ������ �� ����.
	    }
	}
	
	/*
	 * ���� ���� Ǯ� ���� �߿� ���� �����ٰ� ������.
	 * 
	 * �迭�� �ݺ����� �� Ȱ���ϸ��.
	 * 
	 * ���� n�� ������ �ƴ� n�� ����� ���� ���̾��ٸ�
	 * 
	 * �ҽ��� ������������..
	 */