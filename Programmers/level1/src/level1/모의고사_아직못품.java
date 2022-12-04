package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 모의고사_아직못품 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 수포자는 수학을 포기한 사람의 준말입니다. 
		 * 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
		 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
		 * 
		 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... 
		 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ... 3
		 * 번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
		 * 
		 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
		 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
		 * 
		 * 제한 조건 
		 * 시험은 최대 10,000 문제로 구성되어있습니다. 
		 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다. 
		 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
		 * 
		 * 
		 */
		int[] a = {1,3,2,4,2};
		
		System.out.println(solution(a).length);
		

	}
	
    public static int[] solution(int[] answers) {
        /*
         * 내가 푸는 방법
         * 
         * 1번 수포자 : [12345] => 12345 반복
         * 2번 수포자 : [2[1-5]] => 인덱스 기준 짝수일 때 2
         * 3번 수포자 : [31245] => 33 11 22 44 55
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
    		// 셋 다 같을때
    		return new int[] {1,2,3};
    	} else if(compareA == compareB && compareB != compareC && compareA > compareC) {
    		// A,B 같고 C는 작을 때
    		return new int[] {1,2};
    	} else if(compareA == compareC && compareC != compareB && compareA > compareB) {
    		// A,C 같고 B는 작을 때
    		return new int[] {1,3};
    	} else if(compareB == compareC && compareC != compareA && compareB > compareA) {
    		// B,C 같고 A는 작을 때
    		return new int[] {2,3};
    	} else if(compareA > compareC && compareA > compareB) {
    		// A만 클 때
    		return new int[] {1};
    	} else if(compareB > compareC && compareB > compareA) {
    		// B만 클 때
    		return new int[] {2};
    	} else if(compareC > compareA && compareC > compareB) {   		
    		// C만 클때
    		return new int[] {3};
    	}
    		
    	return new int[] {};
    }

}






























