package level1;

public class 최대공약수와최소공배수 {

	public static void main(String[] args) {
		/*
		 * 문제 설명 
		 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 
		 * 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 
		 * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로
		 * solution(3, 12)는 [3, 12]를 반환해야 합니다.
		 * 
		 * 제한 사항
		 * 두 수는 1이상 1000000이하의 자연수입니다.
		 * 
		 */
		
		solution(3, 15);
	}
    public static int[] solution(int n, int m) {
    	/*
    	 * 내가 문제 푸는 방법
   		 * 1. 유클리드 알고리즘을 이용하여 문제를 풀자.
    	 * 
    	 */
        
        int num1 = n;
        int num2 = m;
        
        int store; // num1가 num2 보다 작을때, 위치를 바꿈
        if(num1 < num2) {
        	store = num1;
        	num1 = num2;
        	num2 = store;
        }
        
        // num2 값이 0이 될 때까지 실행한다.
        while(num2 != 0) {
        	
        	int remainder = (num1 % num2); // num1 % num2 의 나머지
        	
        	// 나머지가 0이 아니면 연산 할 값을 바꾼다.
        	if(remainder != 0) {
        		num1 = num2;
        		num2 = remainder;
        	} else {
        		// 나머지가 0이면 순회 종료, num2 값이 최대공약수.
        		break;
        	}
        	
        }
        
        // 최소 공배수는 주어진 값을 곱한 뒤, 최대 공약수를 나누면 된다.
        
        int[] answer = {num2, n*m/num2};
        System.out.println(num2 + "/" + n*m/num2);
        
        return answer;
    }
}

/*
 * 약 한달 전에 푼 문제인데
 * 당시에는 알고리즘이 있는지 생각도 못했다.
 * 
 * 그리고 문제 풀기에만 급급하여 알고리즘 공부에 소홀하였다.
 * 
 * 자바 공부를하면서, 알고리즘을 하나씩 찾아보던 중, 관련 알고리즘이 있어
 * 
 * 효율적으로 풀어가는 방법을 배웠다.
 * 
 */

