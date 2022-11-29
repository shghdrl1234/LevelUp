package level1;

public class 소수찾기_아직못품 {

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
      * 1. n을 1부터 n까지 나눴을때 나머지가 나오지 않는 것은 1과 n의 약수다.
      * 
      */
    	int num = n;
    	int a = 0;
    	int answer = 0;
    	
    	for(int i = 2; i <= n; i++) {
    		
    		int j = 1;
    		while(j < i) {
    			
    			if(i%j == 0) {
    				a += 1;
    			}
    			j++;
    		}
    		
    		if(a == 2 ) {
    			answer += 1;
    		}
    			a=0;	
    		}
    	
        return answer;
    }
	
}
