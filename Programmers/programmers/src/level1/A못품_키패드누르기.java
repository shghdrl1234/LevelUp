package level1;

public class A��ǰ_Ű�е崩���� {
	/* 
	 * 1 2 3
	 * 4 5 6
	 * 7 8 9
	 * * 0 #
	 * 
	 * �� ��ȭ Ű�е忡�� �޼հ� �������� �����հ������� �̿��ؼ� ���ڸ��� �Է��Ϸ��� �մϴ�. 
	 * �� ó�� �޼� �����հ����� * Ű�е忡, ������ �����հ����� # Ű�е� ��ġ���� �����ϸ�, �����հ����� ����ϴ� ��Ģ�� ������ �����ϴ�.
	 * 
	 * 1. �����հ����� �����¿� 4���� �������θ� �̵��� �� ������ Ű�е� �̵� �� ĭ�� �Ÿ��� 1�� �ش��մϴ�. 
	 * 2. ���� ���� 3���� ���� 1, 4, 7�� �Է��� ���� �޼� �����հ����� ����մϴ�.
	 * 3. ������ ���� 3���� ���� 3, 6, 9�� �Է��� ���� ������ �����հ����� ����մϴ�.
	 * 4. ��� ���� 4���� ���� 2, 5, 8, 0�� �Է��� ���� �� �����հ����� ���� Ű�е��� ��ġ���� �� ����� �����հ����� ����մϴ�.
	 *  4-1. ���� �� �����հ����� �Ÿ��� ���ٸ�, ���������̴� ������ �����հ���, �޼����̴� �޼� �����հ����� ����մϴ�. 
	 *  
	 * ������� ���� ��ȣ�� ��� �迭 numbers, �޼��������� ������������ ���� ��Ÿ���� ���ڿ� hand�� �Ű������� �־��� ��, 
	 * �� ��ȣ�� ���� �����հ����� �޼��� �� �������� ���� ��Ÿ���� ���ӵ� ���ڿ� ���·� return �ϵ��� solution �Լ��� �ϼ����ּ���.
	 * 
	 * [���ѻ���] 
	 * numbers �迭�� ũ��� 1 �̻� 1,000 �����Դϴ�. 
	 * numbers �迭 ������ ���� 0 �̻� 9 ������ �����Դϴ�.
	 * hand�� "left" �Ǵ� "right" �Դϴ�. 
	 * "left"�� �޼�����, "right"�� ���������̸� �ǹ��մϴ�. 
	 * �޼� �����հ����� ����� ���� L, ������ �����հ����� ����� ���� R�� ������� �̾�ٿ� ���ڿ� ���·� return ���ּ���.
	 * 
	 */

    public String solution(int[] numbers, String hand) {
    	/*
    	 * ���� ���� Ǫ�� ���.
    	 * 1, 4, 7, *�� �������� 3, 6, 9, #�� ����������.
    	 * 2, 5, 8, 0�� �� �����հ��� �� ����� ��, ��, �Ÿ��� ������ �ַ� ���� ������ �Ѵ�.
    	 * 
    	 * 1. �� �հ����� ���� ��ġ�� �˷��ִ� ������ �ʿ���. 
    	 * => (* 0 #)�� ��ġ�� 1, (7 8 9)�� ��ġ�� 2, (4 5 6)�� ��ġ�� 3, (1 2 3)�� ��ġ�� 4�� ��Ÿ����.
    	 * => �� �� �߿� ���� �� ���� ��ȣ�� -�� ���δ�. => ��ȣ�� ����̸� 2�� ��ġ�� �ִٴ� ��.  
    	 * => ��ȣ�� �����̸�, ��� �ٷ� ���� ���� �� �� �� ���������Ѵ�.
    	 * 
    	 * 2. �׸��� �� �հ����� ��ġ���� 2, 5, 8, 0 ���� �Ÿ��� �� �� �ִ� �޼��带 ��������.
    	 * => 
    	 * 
    	 * 3. 
    	 */
    	
    	int right = 4; 
    	int right_loc = -1;
    	
    	int left = 4;
    	int left_loc = -1;
    	String answer = "";
    	
    	
    	for(int i = 0; i < numbers.length; i++) {
    		// 1, 4, 7 �̸� ���� ��ġ�� 1,2,3 �� �ϳ�, ��ȣ�� -1
    		if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
    			answer += "L";
    			
    			right = numbers[i]/3+1;
    			right_loc = -1;
    		
    			// 3, 6, 9 �̸� ���� ��ġ�� 1,2,3 �� �ϳ�, ��ȣ�� -1	
    		} else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
    			answer += "R";
    			
    			left = numbers[i]/3;
    			left_loc = -1;
    		
    			// ��� ���� �´ٸ�..
    		} else if( UseFinger(right, right_loc, left, left_loc, numbers[i], hand).equals("R") ) {
    			// 2 5 7 0
    			answer += "R";
    			right_loc = 0;
    			
    			if(numbers[i] == 0) {
    				right = 4;
    			} else {
    				right = numbers[i]/3+1;
    			}
    			
    		} else {
    			answer += "L";
    			left_loc = 0;
    			
    			if(numbers[i] == 0) {
    				left = 4;
    			} else {
    				left = numbers[i]/3+1;
    			}
    		}
    	}
    	
    	
        return answer;
    }

	private String UseFinger(int right, int right_loc, int left, int left_loc, int i, String hand) {
		
		int num = 0;
		String finger ="";
		
		int right_move = 0;
		int left_move = 0;
		
		switch(i) {
		case 2 : num = 1; break;
		case 5 : num = 2; break;
		case 8 : num = 3; break;
		case 0 : num = 4; break;
		}
		
		if(right_loc < 0) {
			right_move ++;
		}
		
		if(left_loc < 0) {
			left_move ++;
		}
		
		right_move += Math.abs(num-right);
		left_move += Math.abs(num-left);
		
		if(right_move - left_move < 0) {
			finger += "R";
		} else if(right_move - left_move > 0) {
			finger += "L";
		} else if(hand.equals("right")) {
			finger += "R";
		} else {
			finger += "L";
		}

		return finger;
	}
	
}
