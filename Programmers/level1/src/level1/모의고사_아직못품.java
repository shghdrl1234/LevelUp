package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class ���ǰ��_������ǰ {

	public static void main(String[] args) {
		/*
		 * ���� ���� 
		 * �����ڴ� ������ ������ ����� �ظ��Դϴ�. 
		 * ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. 
		 * �����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.
		 * 
		 * 1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... 
		 * 2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ... 3
		 * �� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
		 * 
		 * 1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, 
		 * ���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		 * 
		 * ���� ���� 
		 * ������ �ִ� 10,000 ������ �����Ǿ��ֽ��ϴ�. 
		 * ������ ������ 1, 2, 3, 4, 5�� �ϳ��Դϴ�. 
		 * ���� ���� ������ ���� ����� ������ ���, return�ϴ� ���� �������� �������ּ���.
		 * 
		 * 
		 */

	}
	
    public static int[] solution(int[] answers) {
        /*
         * ���� Ǫ�� ���
         * 
         * 1�� ������ : [12345] => 12345 �ݺ�
         * 2�� ������ : [2[1-5]] => �ε��� ���� ¦���� �� 2
         * 3�� ������ : [31245] => 33 11 22 44 55
         * 
         */
    	
    	ArrayList<Integer> A = new ArrayList<Integer>();
    	ArrayList<Integer> B = new ArrayList<Integer>();
    	ArrayList<Integer> C = new ArrayList<Integer>();
    	
    	int i = 0;
    	while(i < answers.length/5) {
    		A.add(1);
    		A.add(2);
    		A.add(3);
    		A.add(4);
    		A.add(5);
    		i += 5;
    	}
    	
    	i = 0;
    	while(i < answers.length%5) {
    		A.add(i+1);
    		i++;
    	}
    	
    	
    	int j = 0;
    	while(j < answers.length/8) {
    		B.add(2);
    		B.add(1);
    		B.add(2);
    		B.add(3);
    		B.add(2);
    		B.add(4);
    		B.add(2);
    		B.add(5);
    		j += 8;
    	}
    	
    	for(j = 0; j < answers.length%8; i++ ) {
    		if(j%2 == 0) {
    			B.add(2);
    			}
    		if(j%2 == 1) {
        		B.add(2);
        		}
    		if(j%2 == 3) {
        		B.add(3);
        		}
    		if(j%2 == 5) {
        		B.add(5);
        		}
    		if(j%2 == 7) {
        		B.add(7);
        		}

    	}
		
		int k = 0;
    	while(i < answers.length/10) {
    		C.add(3);
    		C.add(3);
    		C.add(1);
    		C.add(1);
    		C.add(2);
    		C.add(2);
    		C.add(4);
    		C.add(4);
    		C.add(5);
    		C.add(5);
    		i += 10;
    	}
    	
		if(k < answers.length%10) {
			if(k < 1) {
				C.add(3);
			}
			if(k < 2) {
				C.add(3);
			}
			if(k < 3) {
				C.add(1);
			}
			if(k < 4) {
				C.add(1);
			}
			if(k < 5) {
				C.add(2);
			}
			if(k < 6) {
				C.add(2);
			}
			if(k < 7) {
				C.add(4);
			}
			if(k < 8) {
				C.add(4);
			}
			if(k < 9) {
				C.add(5);
			}
		}

    	int compareA = 0;
    	int compareB = 0;
    	int compareC = 0;
    	
    	int y = 0;
    	for(int a : answers) {
    		
    		if(a == A.get(y)) {
    			compareA += 1;
    		}
    		if(a == B.get(y)) {
    			compareB += 1;
    		}
    		if(a == C.get(y)) {
    			compareC += 1;
    		}
    		
    		y++;
    	}
    	
    	int[] compare = {compareA,compareB,compareC};
    	
    	Arrays.sort(compare);
    	
    	
    	
    	if(compare[0] == compare[1] && compare[0] == compare[2]) {
    		int[] answer = new int[3];
    		answer[0] = compare[2];
    		answer[1] = compare[2];
    		answer[2] = compare[2];
    		 return answer;
    				
    	} else if(compare[2] == compare[1] && compare[1] > compare[0]) {
    		int[] answer = new int[2];
    		answer[0] = compare[2];
    		answer[1] = compare[2];
    		 return answer;
    		
    		
    	} else {
    		int[] answer = new int[1];
    		answer[0] = compare[2];
    		 return answer;
    	}
    	
    }

}






























