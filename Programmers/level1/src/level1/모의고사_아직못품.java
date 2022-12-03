package level1;

import java.util.ArrayList;
import java.util.Arrays;

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






























