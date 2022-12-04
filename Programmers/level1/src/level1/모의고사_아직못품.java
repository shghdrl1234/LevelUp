package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		int[] a = {1,3,2,4,2};
		
		System.out.println(solution(a).length);
		

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
    		i += 1;
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
    		j += 1;
    	}
    	
    	for(j = 0; j < answers.length%8; j++ ) {

    		if(j == 0 || j == 2 || j == 4 || j ==6 ) {
    			B.add(2);
    			}
    		if(j == 1) {
        		B.add(1);
        		}
    		if(j == 3) {
        		B.add(3);
        		}
    		if(j == 5) {
        		B.add(4);
        		}
    		if(j == 7) {
        		B.add(5);
        		}
    	}
		
		int k = 0;
    	while(k < answers.length/10) {
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
    		k += 1;
    	}
    	
    	 
    	for(int n = 0; n < answers.length%10; n++ ) {
			if( n == 0) {
				C.add(3);
			}
			if(n == 1) {
				C.add(3);
			}
			if(n == 2) {
				C.add(1);
			}
			if(n == 3) {
				C.add(1);
			}
			if(n == 4) {
				C.add(2);
			}
			if(n == 5) {
				C.add(2);
			}
			if(n == 6) {
				C.add(4);
			}
			if(n == 7) {
				C.add(4);
			}
			if(n == 8) {
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
    	
    	
    	if(compareA == compareB && compareB == compareC ) {
    		// �� �� ������
    		return new int[] {1,2,3};
    	} else if(compareA == compareB && compareB != compareC && compareA > compareC) {
    		// A,B ���� C�� ���� ��
    		return new int[] {1,2};
    	} else if(compareA == compareC && compareC != compareB && compareA > compareB) {
    		// A,C ���� B�� ���� ��
    		return new int[] {1,3};
    	} else if(compareB == compareC && compareC != compareA && compareB > compareA) {
    		// B,C ���� A�� ���� ��
    		return new int[] {2,3};
    	} else if(compareA > compareC && compareA > compareB) {
    		// A�� Ŭ ��
    		return new int[] {1};
    	} else if(compareB > compareC && compareB > compareA) {
    		// B�� Ŭ ��
    		return new int[] {2};
    	} else if(compareC > compareA && compareC > compareB) {   		
    		// C�� Ŭ��
    		return new int[] {3};
    	}
    		
    	return new int[] {};
    }

}






























