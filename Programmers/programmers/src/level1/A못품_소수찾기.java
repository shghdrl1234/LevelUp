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
		solution(10);
	}

    public static int solution(int n) {
     /*
      * 내가 문제 푸는 방법
      * 1. 소수 = 최대 공약수 자기 자신.
      * => 1부터 n 사이 임의의 수의 최대 공약수를 구한다.
      * => 최대 공약수가, 임의의 수와 같으면 카운트
      * => 에라토스테네스의 채 방법을 사용.
      */
    	
    	int answer = 0;
    	
    	boolean[] prime = new boolean[n+1];
    	
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
	        
			// 이미 체크된 배열이면 다음 반복문으로 skip
			if(prime[i] == true) {
				continue;
			}
        
			// i 의 배수들을 걸러주기 위한 반복문
			for(int j = i * i; j < prime.length; j = j+i) {
				prime[j] = true;
			}
		}
    	
    	for(int i = 0; i < prime.length; i++) {
			if(prime[i] == false) {	// 소수(false)일 경우 출력
				answer ++;
			}
		}
    	
    	return answer;
    }
    
}
    
