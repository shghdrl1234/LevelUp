package level1;

public class 콜라츠추측 {

	public static void main(String[] args) {
		/*
		 * 
		 * 문제 설명 
		 * 1937년 Collatz란 사람에 의해 제기된 이 추측은,
		 * 주어진 수가 1이 될 때까지 다음 작업을 반복하면, 모든 수를 1로
		 * 만들 수 있다는 추측입니다. 
		 * 작업은 다음과 같습니다.
		 * 
		 * 1-1. 입력된 수가 짝수라면 2로 나눕니다. 
		 * 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다. 
		 * 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다. 
		 * 예를 들어, 주어진 수가 6이라면 
		 * 6 -> 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1 이 되어 총 8번 만에 1이 됩니다. 
		 * 위 작업을 몇 번이나 반복해야 하는지 반환하는 함수, solution을 완성해 주세요.
		 * 
		 * 단, 주어진 수가 1인 경우에는 0을, 
		 * 작업을 500번 반복할 때까지 1이 되지 않는다면 -1을 반환해 주세요.
		 * 
		 * 제한 사항 입력된 수, num은 1 이상 8,000,000 미만인 정수입니다.
		 * 
		 * 
		 */
		
		System.out.println(solution(626331));
			
	}
	
	   public static int solution(int num) {
		   // 1. 2로 나눠서 값이 0이면 짝수, 그 이외면 홀수
		   // 2. 위에 제시된 조건으로 분기한다.
		   // 3. 카운트 변수를 선언하여 500이되면 -1을 반환
		   // 4. num으로 1이 들어오면 0을 반환한다.

		   int answer = 0;
		  
		   int value = num;
		   
		   if(value == 1) {
			   return 0;
		   }
		   
		   while(value != 1) {
			  
			   if(value%2 == 0 ) {
				  // 짝수라는 말
				   System.out.println(value+" // "+answer +"번 시도 : " + value/2);
				   value /= 2;
				  
			   } else {
				  // 그 이외의 경우 즉, 홀수
				   System.out.println(value+" // "+answer +"번 시도 : " + value/2);
				   value = (3*value + 1);
			   }
			  
			   answer++;

			   if(answer == 500) {
				  return -1;
			   }

		   }
		   
	        return answer;
	    }

}

		class 콜라츠추측_다른사람 {
		    public int collatz(int num) {
		    	
		    	long n = (long)num;
		    	
		    	for(int i =0; i<500; i++){      
		    		
		    		if(n==1) return i;
		    		
		    		n = (n%2==0) ? n/2 : n*3+1;
		    		// 3항 연산자를 사용하여 더 간결한 코드를 작성함.
		    	}
		    	return -1;
		  }
		    
		}
		
		/*
		 * 
		 * 나도 문제를 풀다가 분명 소스코드는 정확한데 자꾸 답이 틀렸다.
		 * 그 이유는 value의 타입이 num이어서, int의 범위를 초과하면 오버플로우가 발생하여,
		 * 후반부에 다른 답이 나오게 되어버렸다. 
		 * 626331를 전달해주면 115번째에서 오버플로우 발생!
		 * 
		 * 
		 * /
		 */