package level1;

public class 음양더하기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 어떤 정수들이 있습니다. 
		 * 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 
		 * 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다. 
		 * 실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.
		 * 
		 * 제한사항 
		 * absolutes의 길이는 1 이상 1,000 이하입니다. 
		 * absolutes의 모든 수는 각각 1 이상 1,000 이하입니다.
		 * signs의 길이는 absolutes의 길이와 같습니다. 
		 * signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을,
		 * 그렇지 않으면 음수임을 의미합니다.
		 * 
		 */

	}
	
    public int solution(int[] absolutes, boolean[] signs) {
        
    	/*
    	 * 내가 생각하는 풀이
    	 * 
    	 * 1. true는 양수, false는 음수
    	 * 2. 배열의 길이는 absolutes와 signs가 동일하니, 반복문 사용하기 수월하다.
    	 * 3-1. signs의 값에 따라 String 배열을 만들어 주고
    	 * 3-2. 또는 반복문 내에서 부호와 수를 합쳐서, 계산.
    	 * 4. 반복문을 통하여 합한다.
    	 * 
    	 */
    	int answer = 0;
    	for(int i = 0; i < signs.length; i++) {
    		
    		if(signs[i]) {
    			// 양수 이면
    			answer += absolutes[i];
    			
    		} else {
    			// 그 외, 즉 음수이다. (0은 합계에 있어 값을 바꾸지 못한다고 판단.)
    			answer -= absolutes[i];
    		}
    	}
    	
        return answer;
    }

}

	class 음양더하기_다른사람 {
	    public int solution(int[] absolutes, boolean[] signs) {
	        int answer = 0;
	        for (int i=0; i<signs.length; i++)
	            answer += absolutes[i] * (signs[i]? 1: -1);
	        // 깔끔하게 정리됨.
	        return answer;
	    }
	}
	
	/*
	 * 삼항 연산자 사용법 숙지 요망.
	 * 
	 * 
	 */
	
	
	