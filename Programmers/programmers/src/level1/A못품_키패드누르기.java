package level1;

public class A못품_키패드누르기 {
	/* 
	 * 1 2 3
	 * 4 5 6
	 * 7 8 9
	 * * 0 #
	 * 
	 * 이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다. 
	 * 맨 처음 왼손 엄지손가락은 * 키패드에, 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.
	 * 
	 * 1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다. 
	 * 2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
	 * 3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
	 * 4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
	 *  4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다. 
	 *  
	 * 순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 
	 * 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
	 * 
	 * [제한사항] 
	 * numbers 배열의 크기는 1 이상 1,000 이하입니다. 
	 * numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
	 * hand는 "left" 또는 "right" 입니다. 
	 * "left"는 왼손잡이, "right"는 오른손잡이를 의미합니다. 
	 * 왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
	 * 
	 */

    public String solution(int[] numbers, String hand) {
    	/*
    	 * 내가 문제 푸는 방법.
    	 * 1, 4, 7, *은 왼쪽으로 3, 6, 9, #은 오른쪽으로.
    	 * 2, 5, 8, 0은 양 엄지손가락 중 가까운 쪽, 단, 거리가 같으면 주로 쓰는 손으로 한다.
    	 * 
    	 * 1. 각 손가락의 현재 위치를 알려주는 변수가 필요함. 
    	 * => (* 0 #)의 위치는 1, (7 8 9)의 위치는 2, (4 5 6)의 위치는 3, (1 2 3)의 위치는 4로 나타낸다.
    	 * => 세 줄 중에 양쪽 두 줄의 부호는 -를 붙인다. => 부호가 양수이면 2번 위치에 있다는 것.  
    	 * => 부호가 음수이면, 가운데 줄로 가기 위해 한 번 더 움직여야한다.
    	 * 
    	 * 2. 그리고 각 손가락의 위치부터 2, 5, 8, 0 과의 거리를 알 수 있는 메서드를 만들어야함.
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
    		// 1, 4, 7 이면 현재 위치는 1,2,3 중 하나, 부호는 -1
    		if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
    			answer += "L";
    			
    			right = numbers[i]/3+1;
    			right_loc = -1;
    		
    			// 3, 6, 9 이면 현재 위치는 1,2,3 중 하나, 부호는 -1	
    		} else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
    			answer += "R";
    			
    			left = numbers[i]/3;
    			left_loc = -1;
    		
    			// 가운데 줄이 온다면..
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
