package level1;

public class A못품_소수찾기 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
		 * 
		 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다. (1은 소수가 아닙니다.)
		 * 
		 * 제한 조건 
		 * n은 2이상 1000000이하의 자연수입니다.
		 * 
		 * 
		 */

	}

    public int solution(int n) {
     /*
      * 내가 문제 푸는 방법
      * 1. 소수 = 최대 공약수 자기 자신.
      * => 1부터 n 사이 임의의 수의 최대 공약수를 구한다.
      * => 최대 공약수가, 임의의 수와 같으면 카운트
      * 
      */

    	int answer = 0;
    	
    	int num = 2;
    	int one = 1;
    	
    	for(int i = 1; i < n; i++) {
    		
	    	while(num != 0) {
	    		
	    		
	    	}
	    	
    	}
    	
        return answer;
    }
	
}
